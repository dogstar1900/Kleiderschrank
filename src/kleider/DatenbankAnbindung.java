package kleider;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;


public class DatenbankAnbindung {
private Connection conn;
    public DatenbankAnbindung() throws SQLException {

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String pw = "";

            conn = DriverManager.getConnection(url, user, null);
            System.out.println("Inside");


        } catch (SQLException ex) {
            System.out.println("Outside");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        datenbankErstellen();

    }

    public void datenbankErstellen() throws SQLException {

        Statement stm = conn.createStatement();

        try {
            stm.executeUpdate("CREATE DATABASE IF NOT EXISTS kleiderschrank");
            stm.executeUpdate("use kleiderschrank");
        } catch (SQLException e) {
            System.out.print(e);
        }

    }





}







