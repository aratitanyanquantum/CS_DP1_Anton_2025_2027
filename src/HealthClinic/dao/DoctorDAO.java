package HealthClinic.dao;

import HealthClinic.db.DatabaseConnection;
import HealthClinic.model.Doctor;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DoctorDAO {

    private Connection con = DatabaseConnection.getConnection();
    private Statement stmt = con.createStatement();

    public DoctorDAO() throws SQLException, IOException {
    }

    private static final String SELECT_BASE =
            "SELECT p.id, p.name, d.phone, d.present "
          + "FROM Person p INNER JOIN Doctor d ON d.id = p.id ";

    public static Doctor mapRow(ResultSet rs) throws SQLException {
        Doctor d = new Doctor();
        d.setPersonID(rs.getInt("id"));
        d.setName(rs.getString("name"));
        d.setPhone(rs.getString("phone"));
        d.setPresent(rs.getBoolean("present"));
        return d;
    }

    public ArrayList<Doctor> getAllDoctors() throws SQLException {
        ResultSet rs = stmt.executeQuery(SELECT_BASE + "ORDER BY p.id");

        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        while (rs.next()) {
            doctors.add(mapRow(rs));
        }
        return doctors;
    }

    public Doctor getDoctorById(int id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(SELECT_BASE + "WHERE p.id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        }
        System.out.println("No doctor with ID " + id);
        return null;
    }

    public int insert(Doctor d) throws SQLException {
        String personSql = "INSERT INTO Person (id, name) VALUES (?, ?)";
        String doctorSql = "INSERT INTO Doctor (id, phone, present) VALUES (?, ?, ?)";

        con.setAutoCommit(false);
        try (PreparedStatement psPerson = con.prepareStatement(personSql);
             PreparedStatement psDoctor = con.prepareStatement(doctorSql)) {

            psPerson.setInt(1, d.getPersonID());
            psPerson.setString(2, d.getName());
            psPerson.executeUpdate();

            psDoctor.setInt(1, d.getPersonID());
            psDoctor.setString(2, d.getPhone());
            psDoctor.setBoolean(3, d.isPresent());
            int rows = psDoctor.executeUpdate();

            con.commit();
            return rows;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public int update(Doctor d) throws SQLException {
        String personSql = "UPDATE Person SET name = ? WHERE id = ?";
        String doctorSql = "UPDATE Doctor SET phone = ?, present = ? WHERE id = ?";

        con.setAutoCommit(false);
        try (PreparedStatement psPerson = con.prepareStatement(personSql);
             PreparedStatement psDoctor = con.prepareStatement(doctorSql)) {

            psPerson.setString(1, d.getName());
            psPerson.setInt(2, d.getPersonID());
            psPerson.executeUpdate();

            psDoctor.setString(1, d.getPhone());
            psDoctor.setBoolean(2, d.isPresent());
            psDoctor.setInt(3, d.getPersonID());
            int rows = psDoctor.executeUpdate();

            con.commit();
            return rows;
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public Doctor delete(int id) throws SQLException {
        Doctor removed = getDoctorById(id);
        if (removed == null) {
            System.out.println("Nothing to delete");
            return null;
        }

        con.setAutoCommit(false);
        try (PreparedStatement psDoctor = con.prepareStatement("DELETE FROM Doctor WHERE id = ?");
             PreparedStatement psPerson = con.prepareStatement("DELETE FROM Person WHERE id = ?")) {

            psDoctor.setInt(1, id);
            psDoctor.executeUpdate();

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
