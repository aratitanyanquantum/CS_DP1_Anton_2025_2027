package GalaxyBankService.dao;

import GalaxyBankService.db.DatabaseConnection;
import GalaxyBankService.model.Loans;
import RentalService.model.Office;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class LoansDAO {
    Connection con = DatabaseConnection.getConnection();
    Statement stmt = con.createStatement();


    public LoansDAO() throws SQLException, IOException {
    }

    public ArrayList<Loans> getLoansTypeAmount() throws SQLException {
        ArrayList<Loans> loans = new ArrayList<>();

        ResultSet rs = stmt.executeQuery("SELECT Type,sum(amount) as Total_Amount from Loans "
                +"group by Type "
                +"having sum(amount)>1000000 ");
        while (rs.next()) {
            loans.add(new Loans(rs.getString("Type"), rs.getInt("Total_Amount")));
        }
        return loans;
    }
}
