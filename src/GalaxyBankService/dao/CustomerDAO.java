package GalaxyBankService.dao;

import GalaxyBankService.db.DatabaseConnection;
import GalaxyBankService.model.Customer;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class CustomerDAO {
    Connection con = DatabaseConnection.getConnection();
    Statement stmt = con.createStatement();

    public CustomerDAO() throws SQLException, IOException {
    }

    public ArrayList<Customer>  getAllCustomers() throws SQLException, IOException {
        String sql = "SELECT * FROM Customers";

        ResultSet rs = stmt.executeQuery(sql);

        ArrayList<Customer> customers = new ArrayList<Customer>();
        while(rs.next()){
            Customer c = new Customer();
            c.setCustomerID(rs.getInt("Customer_ID"));
            c.setFamilyName(rs.getString("Family_Name"));
            c.setZipCode(rs.getInt("Zip_Code"));
            c.setPhone(rs.getInt("Phone"));
            customers.add(c);
        }
        return customers;
    }

    public Customer delete(int customerID) throws SQLException, IOException {

        String sql = "DELETE FROM Customers "
                + "OUTPUT DELETED.Customer_ID, DELETED.Family_Name, "
                + "       DELETED.Zip_Code, DELETED.Phone "
                + "WHERE Customer_ID = ?";

        PreparedStatement ps = con.prepareStatement(sql) ;
            ps.setInt(1, customerID);

            ResultSet rs = ps.executeQuery() ;
                if (rs.next()) {
                    Customer c = new Customer();
                    c.setCustomerID(rs.getInt("Customer_ID"));
                    c.setFamilyName(rs.getString("Family_Name"));
                    c.setZipCode(rs.getInt("Zip_Code"));
                    c.setPhone(rs.getInt("Phone"));
                    return c;
                }
        System.out.println("Nothing to delete");
                return null; // nothing matched that ID


    }

    public int insert(Customer c) throws SQLException {

        String sql = "INSERT INTO Customers "
                + "(Customer_ID, Family_Name, Zip_Code, Phone) "
                + "VALUES (?, ?, ?, ?)";


        try (PreparedStatement ps = con.prepareStatement(sql)) {

            // Fill the four ? placeholders, in order.
            ps.setInt(1, c.getCustomerID());
            ps.setString(2, c.getFamilyName());
            ps.setInt(3, c.getZipCode());
            ps.setInt(4, c.getPhone());

            return ps.executeUpdate(); // rows inserted
        }
    }

    public int update(Customer c) throws SQLException {

        String sql = "UPDATE Customers "
                + "SET Family_Name = ?, Zip_Code = ?, Phone = ? "
                + "WHERE Customer_ID = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            // The three new values...
            ps.setString(1, c.getFamilyName());
            ps.setInt(2, c.getZipCode());
            ps.setInt(3, c.getPhone());


            ps.setInt(4, c.getCustomerID());

            return ps.executeUpdate(); // rows changed
        }
    }
}
