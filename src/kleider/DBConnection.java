// Klasse erstellt durch Maurice Chapellier
// Klasse bindet die DB in die Anwendung ein. Benutzt wurde dafür die durch Oracle bereitgestellte scr mit den darin enthaltenen Methoden. Vgl: https://dev.mysql.com/downloads/connector/j/

package kleider;

import java.sql.*;

public class DBConnection {

    private String sqlBefehl;
    private int stringNr;
    private int index;
    private Connection con;
    public DBConnection() throws SQLException{


        try{
            String url = "jdbc:mysql://localhost:3306/Kleiderschrank"; // Aufbau der URL = Protokoll: Adresse:Port
            String usr = "root"; // Benutzer der DB
            String pw = "root"; // Passwort des Benutzers
            con = DriverManager.getConnection(url, usr, pw); //bindet die DB mit den entsprechenden Werten für die Adresse und den Benutzer ein
        }catch (SQLException e){ System.out.println(e); }
    }

    public void sendSqlBefehl(String sqlBefehl) throws SQLException{

        Statement stm = con.createStatement();
        
        stm.executeUpdate(sqlBefehl);
    }

    // Gibt SQL Eintrag an der entsprechenden Indexstelle der angegebenen Tabelle aus */

    public String getSqlEintrag(int index) throws SQLException{
        this.index = index;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("Select * from anzeigen");
            while (rs.next()) {
                System.out.println(rs.getString(index));
            }

        return null;
    }
    }