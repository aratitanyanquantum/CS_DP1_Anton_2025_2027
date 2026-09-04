package HealthClinic.model;

public class Inpatient extends Treatment {
    private String medication;
    private int roomNumber;

    public Inpatient() {
        super();
    }

    public Inpatient(int treatmentID, String date, int patientId, Doctor doctor,
                     String actions, String medication, int roomNumber) {
        super(treatmentID, date, patientId, doctor, actions);
        this.medication = medication;
        this.roomNumber = roomNumber;
    }

    @Override
    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String getType() {
        return "Inpatient";
    }

    @Override
    public String toString() {
        return super.toString() + ", room=" + roomNumber + "}";
    }
}
