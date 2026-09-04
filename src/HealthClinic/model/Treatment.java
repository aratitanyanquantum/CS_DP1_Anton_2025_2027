package HealthClinic.model;

public abstract class Treatment {
    private int treatmentID;
    private String date;
    private int patientId;
    private Doctor doctor;
    private String actions;

    public Treatment() {}

    public Treatment(int treatmentID, String date, int patientId, Doctor doctor, String actions) {
        this.treatmentID = treatmentID;
        this.date = date;
        this.patientId = patientId;
        this.doctor = doctor;
        this.actions = actions;
    }

    public abstract String getMedication();

    public abstract String getType();

    public int getTreatmentID() {
        return treatmentID;
    }
    public void setTreatmentID(int treatmentID) {
        this.treatmentID = treatmentID;
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
    public String getActions() {
        return actions;
    }
    public void setActions(String actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "\n" + getType() + "{" +
                "treatment_ID=" + treatmentID +
                ", date='" + date + '\'' +
                ", patient_ID=" + patientId +
                ", doctor='" + (doctor == null ? "none" : doctor.getName()) + '\'' +
                ", actions='" + actions + '\'' +
                ", medication='" + getMedication() + '\'';
    }
}
