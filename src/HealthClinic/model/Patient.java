package HealthClinic.model;

public class Patient extends Person {
    private int priority;
    private int doctorId;

    public Patient() {
        super();
    }

    public Patient(int personID, String name, int priority, int doctorId) {
        super(personID, name);
        this.priority = priority;
        this.doctorId = doctorId;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "\nPatient{" +
                "person_ID=" + super.getPersonID() +
                ", name='" + super.getName() + '\'' +
                ", priority=" + priority +
                ", doctor_ID=" + doctorId +
                '}';
    }
}
