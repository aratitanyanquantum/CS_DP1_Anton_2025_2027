package RentalService.dao;

import RentalService.db.DatabaseConnection;
import RentalService.model.Cars;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CarsDAO {
    Connection con = DatabaseConnection.getConnection();
    Statement stmt = con.createStatement();


    public CarsDAO() throws SQLException, IOException {
    }

    public int addCar(Cars c) throws SQLException, IOException {
        String sql = "INSERT INTO Cars "
                + "(Car_ID, Brand, Production_Year, Has_Insurance, Office_ID, Price_ID) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, c.getCarId());
            ps.setString(2, c.getBrand());
            ps.setInt(3, c.getProductionYear());
            ps.setBoolean(4, c.isHasInsurance());
            ps.setInt(5, c.getOfficeId());
            ps.setInt(6, c.getPriceId());

            return ps.executeUpdate();
        }
    }

    public void deleteCarBefore2010()  throws SQLException, IOException {
        String sql = "DELETE FROM Cars WHERE Production_Year<2010";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }


}
