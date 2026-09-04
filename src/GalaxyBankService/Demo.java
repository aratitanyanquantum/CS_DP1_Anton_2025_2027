package GalaxyBankService;

import GalaxyBankService.dao.CustomerDAO;

import java.io.IOException;
import java.sql.*;





public class Demo {



    public static void main(String[] args) throws SQLException, IOException {

        System.out.println(new CustomerDAO().getAllCustomers());
        System.out.println(new CustomerDAO().delete(1234567552));

        System.out.println(new CustomerDAO().getAllCustomers());



    }
}
