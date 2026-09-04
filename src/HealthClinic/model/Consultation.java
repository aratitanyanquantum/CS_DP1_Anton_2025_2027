package HealthClinic.model;

public class Consultation {
    private int consultationID;
    private String date;
    private int patientId;
    private Doctor doctor;
    private String diagnosis;
    private String prescription;
    private int treatmentId;

    public Consultation() {}

    public Consultation(int consultationID, String date, int patientId, Doctor doctor,
                        String diagnosis, String prescription, int treatmentId) {
        this.consultationID = consultationID;
        this.date = date;
        this.patientId = patientId;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.treatmentId = treatmentId;
    }

    public int getConsultationID() {
        return consultationID;
    }
    public void setConsultationID(int consultationID) {
        this.consultationID = consultationID;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getPrescription() {
        return prescription;
    }
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    public int getTreatmentId() {
        return treatmentId;
    }
    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Override
    public String toString() {
        return "\nConsultation{" +
                "consultation_ID=" + consultationID +
                ", date='" + date + '\'' +
                ", patient_ID=" + patientId +
                ", doctor='" + (doctor == null ? "none" : doctor.getName()) + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", treatment_ID=" + treatmentId +
                '}';
    }
}
