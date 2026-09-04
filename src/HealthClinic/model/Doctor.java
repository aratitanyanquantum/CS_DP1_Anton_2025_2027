package HealthClinic.model;

public class Doctor extends Person {
    private String phone;
    private boolean present;

    public Doctor() {
        super();
    }

    public Doctor(int personID, String name, String phone, boolean present) {
        super(personID, name);
        this.phone = phone;
        this.present = present;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isPresent() {
        return present;
    }
    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "\nDoctor{" +
                "person_ID=" + super.getPersonID() +
                ", name='" + super.getName() + '\'' +
                ", phone='" + phone + '\'' +
                ", present=" + present +
                '}';
    }
}
