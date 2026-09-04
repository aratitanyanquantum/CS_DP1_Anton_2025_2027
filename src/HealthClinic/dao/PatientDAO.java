package HealthClinic.dao;

import HealthClinic.db.DatabaseConnection;
import HealthClinic.model.Patient;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PatientDAO {

    private Connection con = DatabaseConnection.getConnection();
    private Statement stmt = con.createStatement();

    public PatientDAO() throws SQLException, IOException {
    }

    private static final String SELECT_BASE =
            "SELECT p.id, p.name, pa.priority, pa.doctor_id "
          + "FROM Person p INNER JOIN Patient pa ON pa.id = p.id ";

    public static Patient mapRow(ResultSet rs) throws SQLException {
        Patient p = new Patient();
        p.setPersonID(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setPriority(rs.getInt("priority"));
        p.setDoctorId(rs.getInt("doctor_id"));
        return p;
    }

    public ArrayList<Patient> getAllPatients() throws SQLException {
        ResultSet rs = stmt.executeQuery(SELECT_BASE + "ORDER BY p.id");

        ArrayList<Patient> patients = new ArrayList<Patient>();
        while (rs.next()) {
            patients.add(mapRow(rs));
        }
        return patients;
    }

    public Patient getPatientById(int id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(SELECT_BASE + "WHERE p.id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        }
        System.out.println("No patient with ID " + id);
        return null;
    }

    public ArrayList<Patient> getPatientsByDoctor(int doctorId) throws SQLException {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try (PreparedStatement ps = con.prepareStatement(SELECT_BASE + "WHERE pa.doctor_id = ?")) {
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                patients.add(mapRow(rs));
            }
        }
        return patients;
    }

    public int insert(Patient p) throws SQLException {
        String personSql  = "INSERT INTO Person (id, name) VALUES (?, ?)";
        String patientSql = "INSERT INTO Patient (id, priority, doctor_id) VALUES (?, ?, ?)";

        con.setAutoCommit(false);
        try (PreparedStatement psPerson = con.prepareStatement(personSql);
             PreparedStatement psPatient = con.prepareStatement(patientSql)) {

            psPerson.setInt(1, p.getPersonID());
            psPerson.setString(2, p.getName());
            psPerson.executeUpdate();

            psPatient.setInt(1, p.getPersonID());
            psPatient.setInt(2, p.getPriority());
            if (p.getDoctorId() == 0) {
                psPatient.setNull(3, Types.INTEGER);
            } else {
                psPatient.setInt(3, p.getDoctorId());
            }
            int rows = psPatient.executeUpdate();

            con.commit();
            return rows;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public int update(Patient p) throws SQLException {
        String personSql  = "UPDATE Person SET name = ? WHERE id = ?";
        String patientSql = "UPDATE Patient SET priority = ?, doctor_id = ? WHERE id = ?";

        con.setAutoCommit(false);
        try (PreparedStatement psPerson = con.prepareStatement(personSql);
             PreparedStatement psPatient = con.prepareStatement(patientSql)) {

            psPerson.setString(1, p.getName());
            psPerson.setInt(2, p.getPersonID());
            psPerson.executeUpdate();

            psPatient.setInt(1, p.getPriority());
            if (p.getDoctorId() == 0) {
                psPatient.setNull(2, Types.INTEGER);
            } else {
                psPatient.setInt(2, p.getDoctorId());
            }
            psPatient.setInt(3, p.getPersonID());
            int rows = psPatient.executeUpdate();

            con.commit();
            return rows;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public Patient delete(int id) throws SQLException {
        Patient removed = getPatientById(id);
        if (removed == null) {
            System.out.println("Nothing to delete");
            return null;
        }

        con.setAutoCommit(false);
        try (PreparedStatement psPatient = con.prepareStatement("DELETE FROM Patient WHERE id = ?");
             PreparedStatement psPerson  = con.prepareStatement("DELETE FROM Person WHERE id = ?")) {

            psPatient.setInt(1, id);
            psPatient.executeUpdate();

            psPerson.setInt(1, id);
            psPerson.executeUpdate();

            con.commit();
            return removed;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
}
