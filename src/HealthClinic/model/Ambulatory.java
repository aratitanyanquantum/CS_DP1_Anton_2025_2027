package HealthClinic.model;

public class Ambulatory extends Treatment {
    private String medication;

    public Ambulatory() {
        super();
    }

    public Ambulatory(int treatmentID, String date, int patientId, Doctor doctor,
                      String actions, String medication) {
        super(treatmentID, date, patientId, doctor, actions);
        this.medication = medication;
    }

    @Override
    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }

    @Override
    public String getType() {
        return "Ambulatory";
    }

    @Override
    public String toString() {
        return super.toString() + "}";
    }
}
