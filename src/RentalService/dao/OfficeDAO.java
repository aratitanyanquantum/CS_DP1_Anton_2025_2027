package RentalService.dao;

import RentalService.db.DatabaseConnection;
import RentalService.model.Office;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OfficeDAO {
    Connection con = DatabaseConnection.getConnection();
    Statement stmt = con.createStatement();


    public OfficeDAO() throws SQLException, IOException {
    }

    public ArrayList<Office> getAllOffices() throws SQLException, IOException {
        ArrayList<Office> offices = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT distinct offices.office_id,office_name,city FROM offices "
        +"JOIN rental "
        +"ON offices.office_id = rental.office_id "
        +"WHERE rental.Start_Date >= DATEADD(month, -1, GETDATE()) and city='Yerevan' ");
        while (rs.next()) {
            Office o=new Office();
            o.setOfficeId(rs.getInt("Office_id"));
            o.setOfficeName(rs.getString("Office_name"));
            o.setCity(rs.getString("City"));
            offices.add(o);
        }
        return offices;
    }
}
