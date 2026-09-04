package RentalService.dao;

import RentalService.db.DatabaseConnection;
import RentalService.model.Office;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class PriceListDAO {
    Connection con = DatabaseConnection.getConnection();
    Statement stmt = con.createStatement();

    public PriceListDAO() throws SQLException, IOException {
    }

    public void addPrice5000(){
        String sql = "UPDATE Customers "
                + "SET Hourly_Rate = Hourly_Rate + 5000";


    }




}
