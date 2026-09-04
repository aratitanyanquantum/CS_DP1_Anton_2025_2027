package GalaxyBankService.model;

public class Accounts {
    private int acct_no;
    private int Customer_ID;
    private int balance;
    private String account_type;

    Accounts(int acct_no, int Customer_ID, int balance, String account_type) {
        this.acct_no = acct_no;
        this.Customer_ID = Customer_ID;
        this.balance = balance;
        this.account_type = account_type;
    }
    Accounts(){};

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public int getAcct_no() {
        return acct_no;
    }

    public void setAcct_no(int acct_no) {
        this.acct_no = acct_no;
    }
}
