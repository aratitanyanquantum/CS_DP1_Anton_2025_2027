package GalaxyBankService.model;

public class Loans {
    private int loanID;
    private int customerID;
    int amount;
    String type;
    public Loans(int loanID, int customerID, int amount, String type) {
        this.loanID = loanID;
        this.customerID = customerID;
        this.amount = amount;
        this.type = type;
    }
    public Loans(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }
    public Loans(){};

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    @Override
    public String toString() {
        return "Loans{" +
                "Loan_Id=" + loanID +
                ", Customer_ID='" + customerID + '\'' +
                ", Amount='" + amount + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }
}
