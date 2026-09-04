package RentalService.model;

public class Office {
    private int officeId;
    private String officeName;
    private String city;

    public Office(){}

    public Office(int officeId, String officeName, String city) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}