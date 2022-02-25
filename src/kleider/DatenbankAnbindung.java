package kleider;

import java.sql.*;

public class DatenbankAnbindung {

    public static void main(String[] args) {
        String url = "";
        String user= "root";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, user, password)){

           System.out.println("Erfolgreich");

        }catch(SQLException ex){
          System.err.println(ex.getMessage());
        }
    }


}
