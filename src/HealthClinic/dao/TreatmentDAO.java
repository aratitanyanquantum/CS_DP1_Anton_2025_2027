package HealthClinic.dao;

import HealthClinic.db.DatabaseConnection;
import HealthClinic.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class TreatmentDAO {

    private Connection con = DatabaseConnection.getConnection();
    private Statement stmt = con.createStatement();

    public TreatmentDAO() throws SQLException, IOException {
    }

    private static final String SELECT_BASE =
            "SELECT t.treatment_id, t.date, t.patient_id, t.actions, t.medication, "
          + "       t.treatment_type, t.room_number, t.hospital_name, t.ambulance_used, "
          + "       p.id, p.name, d.phone, d.present "
          + "FROM Treatment t "
          + "INNER JOIN Doctor d ON d.id = t.doctor_id "
          + "INNER JOIN Person p ON p.id = d.id ";

    private Treatment mapRow(ResultSet rs) throws SQLException {
        Doctor doctor = DoctorDAO.mapRow(rs);

        int treatmentId = rs.getInt("treatment_id");
        Date sqlDate    = rs.getDate("date");
        String date     = (sqlDate == null) ? null : sqlDate.toString();
        int patientId   = rs.getInt("patient_id");
        String actions  = rs.getString("actions");
        String type     = rs.getString("treatment_type");

        if ("Referral".equalsIgnoreCase(type)) {
            return new Referral(treatmentId, date, patientId, doctor, actions,
                    rs.getString("hospital_name"),
                    rs.getBoolean("ambulance_used"));
        }
        if ("Inpatient".equalsIgnoreCase(type)) {
            return new Inpatient(treatmentId, date, patientId, doctor, actions,
                    rs.getString("medication"),
                    rs.getInt("room_number"));
        }
        return new Ambulatory(treatmentId, date, patientId, doctor, actions,
                rs.getString("medication"));
    }

    public ArrayList<Treatment> getAllTreatments() throws SQLException {
        ResultSet rs = stmt.executeQuery(SELECT_BASE + "ORDER BY t.treatment_id");

        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        while (rs.next()) {
            treatments.add(mapRow(rs));
        }
        return treatments;
    }

    public Treatment getTreatmentById(int treatmentId) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(SELECT_BASE + "WHERE t.treatment_id = ?")) {
            ps.setInt(1, treatmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        }
        System.out.println("No treatment with ID " + treatmentId);
        return null;
    }

    public ArrayList<Treatment> getTreatmentsByPatient(int patientId) throws SQLException {
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        try (PreparedStatement ps = con.prepareStatement(
                SELECT_BASE + "WHERE t.patient_id = ? ORDER BY t.date")) {
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                treatments.add(mapRow(rs));
            }
        }
        return treatments;
    }

    public ArrayList<Treatment> getTreatmentsByDoctor(String doctorName) throws SQLException {
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        try (PreparedStatement ps = con.prepareStatement(
                SELECT_BASE + "WHERE p.name = ? ORDER BY t.date")) {
            ps.setString(1, doctorName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                treatments.add(mapRow(rs));
            }
        }
        return treatments;
    }

    private void fillTypeColumns(PreparedStatement ps, Treatment t) throws SQLException {
        if (t instanceof Referral) {
            Referral r = (Referral) t;
            ps.setNull(5, Types.VARCHAR);
            ps.setNull(7, Types.INTEGER);
            ps.setString(8, r.getHospitalName());
            ps.setBoolean(9, r.isAmbulanceUsed());
        } else if (t instanceof Inpatient) {
            Inpatient i = (Inpatient) t;
            ps.setString(5, i.getMedication());
            ps.setInt(7, i.getRoomNumber());
            ps.setNull(8, Types.VARCHAR);
            ps.setNull(9, Types.BIT);
        } else {
            ps.setString(5, t.getMedication());
            ps.setNull(7, Types.INTEGER);
            ps.setNull(8, Types.VARCHAR);
            ps.setNull(9, Types.BIT);
        }
    }

    public int insert(Treatment t) throws SQLException {
        String sql = "INSERT INTO Treatment "
                + "(date, patient_id, doctor_id, actions, medication, "
                + " treatment_type, room_number, hospital_name, ambulance_used) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, t.getDate() == null ? null : Date.valueOf(t.getDate()));
            ps.setInt(2, t.getPatientId());
            ps.setInt(3, t.getDoctor().getPersonID());
            ps.setString(4, t.getActions());
            ps.setString(6, t.getType());
            fillTypeColumns(ps, t);
            return ps.executeUpdate();
        }
    }

    public int update(Treatment t) throws SQLException {
        String sql = "UPDATE Treatment SET "
                + "date = ?, patient_id = ?, doctor_id = ?, actions = ?, medication = ?, "
                + "treatment_type = ?, room_number = ?, hospital_name = ?, ambulance_used = ? "
                + "WHERE treatment_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, t.getDate() == null ? null : Date.valueOf(t.getDate()));
            ps.setInt(2, t.getPatientId());
            ps.setInt(3, t.getDoctor().getPersonID());
            ps.setString(4, t.getActions());
            ps.setString(6, t.getType());
            fillTypeColumns(ps, t);
            ps.setInt(10, t.getTreatmentID());
            return ps.executeUpdate();
        }
    }

    public Treatment delete(int treatmentId) throws SQLException {
        Treatment removed = getTreatmentById(treatmentId);
        if (removed == null) {
            System.out.println("Nothing to delete");
            return null;
        }
        try (PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Treatment WHERE treatment_id = ?")) {
            ps.setInt(1, treatmentId);
            ps.executeUpdate();
        }
        return removed;
    }
}
