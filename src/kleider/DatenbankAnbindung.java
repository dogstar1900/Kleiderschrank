package kleider;
import java.sql.*;


public class DatenbankAnbindung {


    public static void main(String[] args) {
        Connection conn;
        try {
            String url = "jdbc:mysql://localhost:3306/Kleiderschrank";
            String user = "root";
            String pw = "";

            conn = DriverManager.getConnection(url, user, null);

            System.out.println("Im in Bitch!");


        } catch (SQLException ex) {
            System.out.println("Mach doch nicht diese...");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


}
