package HealthClinic.model;

public class Referral extends Treatment {
    private String hospitalName;
    private boolean ambulanceUsed;

    public Referral() {
        super();
    }

    public Referral(int treatmentID, String date, int patientId, Doctor doctor,
                    String actions, String hospitalName, boolean ambulanceUsed) {
        super(treatmentID, date, patientId, doctor, actions);
        this.hospitalName = hospitalName;
        this.ambulanceUsed = ambulanceUsed;
    }

    @Override
    public String getMedication() {
        return "none";
    }

    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public boolean isAmbulanceUsed() {
        return ambulanceUsed;
    }
    public void setAmbulanceUsed(boolean ambulanceUsed) {
        this.ambulanceUsed = ambulanceUsed;
    }

    @Override
    public String getType() {
        return "Referral";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", hospital='" + hospitalName + '\'' +
                ", ambulance=" + ambulanceUsed + "}";
    }
}
