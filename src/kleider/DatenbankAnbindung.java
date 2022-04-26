package kleider;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;


public class DatenbankAnbindung {
    private Connection conn;
    private String sqlBefehl;

    public DatenbankAnbindung() throws SQLException {

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String pw = "admin";

            conn = DriverManager.getConnection(url, user, "");
            System.out.println("Inside");


        } catch (SQLException ex) {
            System.out.println("Outside");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


    }

    public void datenbankErstellen() throws SQLException {

        Statement stm = conn.createStatement();

        try {
            stm.executeUpdate("CREATE DATABASE IF NOT EXISTS kleiderschrank");
            stm.executeUpdate("use kleiderschrank");
            stm.executeUpdate("CREATE TABLE Hose (name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255));");
            stm.executeUpdate("CREATE TABLE Schuhe (name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255));");
            stm.executeUpdate("CREATE TABLE Oberteil (name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255));");



        }catch(SQLException e){System.out.print(e);}
    }
    public void sendSqlBefehl(String sqlBefehl) throws SQLException{

        this.sqlBefehl = sqlBefehl;

        Statement stm = conn.createStatement();
        System.out.println(sqlBefehl);
        stm.executeUpdate(sqlBefehl);
    }




    public void auslesenSchuhe(){
        try {
            String abfrage = "SELECT * FROM schuhe";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4));
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
    }
    public void auslesenOberteil(){
        try {
            String abfrage = "SELECT * FROM oberteil";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2)
                        + " " + rs.getString(3)+ " " +
                        rs.getString(4));
            }
        } catch (SQLException e ){
            e.printStackTrace();
        }
    }
    public void einfuegenHose(String name, String farbe, String art, String groesse){
        try {
            String einfuegen =
                    "INSERT INTO hose(name, farbe, art, groesse) VALUES (" + name + ",'" + farbe + "', '" + art + "', " + groesse + ");";
            Statement stm = conn.createStatement();
            stm.execute(einfuegen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void einfuegenSchuhe(String name, String farbe, String art, String groesse){
        try {
            String einfuegen =
                    "INSERT INTO schuhe(name, farbe, art, groesse) VALUES (" + name + ",'" + farbe + "', '" + art + "', " + groesse + ");";
            Statement stm = conn.createStatement();
            stm.execute(einfuegen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void einfuegenOberteil(String name, String farbe, String art, String groesse){
        try {
            String einfuegen =
                    "INSERT INTO oberteil(name, farbe, art, groesse) VALUES (" + name + ",'" + farbe + "', '" + art + "', " + groesse + ");";
            Statement stm = conn.createStatement();
            stm.execute(einfuegen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void loeschenHose(String name, String farbe, String art, String groesse) {
        try {
            String loeschen = "DELETE FROM hose WHERE name = " + name + ";";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void loeschenSchuhe(String name, String farbe, String art, String groesse) {
        try {
            String loeschen = "DELETE FROM Schuhe WHERE name = " + name + ";";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }public void loeschenOberteil(String name, String farbe, String art, String groesse) {
        try {
            String loeschen = "DELETE FROM oberteil WHERE name = " + name + ";";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}







