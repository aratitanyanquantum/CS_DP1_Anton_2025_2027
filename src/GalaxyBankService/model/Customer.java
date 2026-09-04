package GalaxyBankService.model;

public class Customer {
    private int CustomerID;
    private String FamilyName;
    private int ZipCode;
    private int phone;

    // constructors, getters, setters
    public Customer() {
    }


    public Customer(int CustomerID, String FamilyName, int ZipCode, int phone) {
        this.CustomerID = CustomerID;
        this.FamilyName = FamilyName;
        this.ZipCode = ZipCode;
        this.phone = phone;
    }

    public int getCustomerID() {
        return CustomerID;
    }
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }
    public String getFamilyName() {
        return FamilyName;
    }
    public void setFamilyName(String FamilyName) {
        this.FamilyName = FamilyName;
    }
    public int getZipCode() {
        return ZipCode;
    }
    public void setZipCode(int ZipCode) {
        this.ZipCode = ZipCode;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "CustomerID=" + CustomerID +
                ", FamilyName='" + FamilyName + '\'' +
                ", ZipCode=" + ZipCode +
                ", phone=" + phone +
                '}';
    }

}
