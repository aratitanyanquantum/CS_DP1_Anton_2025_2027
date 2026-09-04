package HealthClinic.dao;

import HealthClinic.db.DatabaseConnection;
import HealthClinic.model.Consultation;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class ConsultationDAO {

    private Connection con = DatabaseConnection.getConnection();
    private Statement stmt = con.createStatement();

    public ConsultationDAO() throws SQLException, IOException {
    }

    private static final String SELECT_BASE =
            "SELECT c.consultation_id, c.date, c.patient_id, c.diagnosis, c.prescription, "
          + "       p.id, p.name, d.phone, d.present "
          + "FROM Consultation c "
          + "INNER JOIN Doctor d ON d.id = c.doctor_id "
          + "INNER JOIN Person p ON p.id = d.id ";

    private Consultation mapRow(ResultSet rs) throws SQLException {
        Consultation c = new Consultation();
        c.setConsultationID(rs.getInt("consultation_id"));
        Date sqlDate = rs.getDate("date");
        c.setDate(sqlDate == null ? null : sqlDate.toString());
        c.setPatientId(rs.getInt("patient_id"));
        c.setDoctor(DoctorDAO.mapRow(rs));
        c.setDiagnosis(rs.getString("diagnosis"));
        c.setPrescription(rs.getString("prescription"));
        return c;
    }

    public ArrayList<Consultation> getAllConsultations() throws SQLException {
        ResultSet rs = stmt.executeQuery(SELECT_BASE + "ORDER BY c.consultation_id");

        ArrayList<Consultation> consultations = new ArrayList<Consultation>();
        while (rs.next()) {
            consultations.add(mapRow(rs));
        }
        return consultations;
    }

    public Consultation getConsultationById(int consultationId) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(SELECT_BASE + "WHERE c.consultation_id = ?")) {
            ps.setInt(1, consultationId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        }
        System.out.println("No consultation with ID " + consultationId);
        return null;
    }

    public ArrayList<Consultation> getConsultationsByPatient(int patientId) throws SQLException {
        ArrayList<Consultation> consultations = new ArrayList<Consultation>();
        try (PreparedStatement ps = con.prepareStatement(
                SELECT_BASE + "WHERE c.patient_id = ? ORDER BY c.date")) {
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                consultations.add(mapRow(rs));
            }
        }
        return consultations;
    }

    public int insert(Consultation c) throws SQLException {
        String sql = "INSERT INTO Consultation (date, patient_id, doctor_id, diagnosis, prescription) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, c.getDate() == null ? null : Date.valueOf(c.getDate()));
            ps.setInt(2, c.getPatientId());
            ps.setInt(3, c.getDoctor().getPersonID());
            ps.setString(4, c.getDiagnosis());
            ps.setString(5, c.getPrescription());
            return ps.executeUpdate();
        }
    }

    public int delete(int consultationId) throws SQLException {
        String sql = "DELETE FROM Consultation WHERE consultation_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, consultationId);
            return ps.executeUpdate();
        }
    }
}
