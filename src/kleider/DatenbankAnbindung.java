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
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS Hose  (name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255));");
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS Schuhe  (name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255));");
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS Oberteil  (name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255));");


        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public void datenbankNutzen() throws SQLException{
        Statement stm = conn.createStatement();
        stm.executeUpdate("use kleiderschrank");
    }

    public void sendSqlBefehl(String sqlBefehl) throws SQLException {

        this.sqlBefehl = sqlBefehl;
        Statement stm = conn.createStatement();
        System.out.println(sqlBefehl);
        stm.executeUpdate(sqlBefehl);
    }


    public void auslesenSchuhe() {
        try {
            String abfrage = "SELECT * FROM Schuhe";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void auslesenOberteil() {
        try {
            String abfrage = "SELECT * FROM Oberteil";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2)
                        + " " + rs.getString(3) + " " +
                        rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void auslesenHose() {
        try {
            String abfrage = "SELECT * FROM Hose";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2)
                        + " " + rs.getString(3) + " " +
                        rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void einfuegenHose(String name, String farbe, String art, String groesse) {
        try {
            String einfuegen =
                    "INSERT INTO Hose(name, farbe, art, groesse) VALUES ('" + name + "','" + farbe + "', '" + art + "','" + groesse + "');";
            Statement stm = conn.createStatement();
            stm.execute(einfuegen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void einfuegenSchuhe(String name, String farbe, String art, String groesse) {
        try {
            String einfuegen =
                    "INSERT INTO Schuhe(name, farbe, art, groesse) VALUES ('" + name + "','" + farbe + "','" + art + "','" + groesse + "');";
            Statement stm = conn.createStatement();
            stm.execute(einfuegen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void einfuegenOberteil(String name, String farbe, String art, String groesse) {
        try {
            String einfuegen =
                    "INSERT INTO Oberteil(name, farbe, art, groesse) VALUES ('" + name + "','" + farbe + "', '" + art + "','" + groesse + "');";
            Statement stm = conn.createStatement();
            stm.execute(einfuegen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loeschenHose(String name, String farbe, String art, String groesse) {
        try {
            String loeschen = "DELETE FROM Hose WHERE name = '" + name + "';";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loeschenSchuhe(String name, String farbe, String art, String groesse) {
        try {
            String loeschen = "DELETE FROM Schuhe WHERE name = '" + name + "';";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loeschenOberteil(String name, String farbe, String art, String groesse) {
        try {
            String loeschen = "DELETE FROM Oberteil WHERE name = '" + name + "';";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void zusammenstellenOutfit() {
        String farb = "";
        int random = (int) (Math.random() * 11);
        switch (random) {
            case 1:
                farb = "schwarz";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'schwarz'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {

                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                farb = "Rot";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'rot'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            case 3:
                farb = "gelb";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'gelb'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                farb = "grün";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'grün'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                farb = "braun";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'braun'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                farb = "grau";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'grau'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                farb = "weiß";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'weiß'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                farb = "orange";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'orange'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 9:
                farb = "blau";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'blau'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 10:
                farb = "hellblau";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'hellblau'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 11:
                farb = "beige";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'beige'";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        System.out.println(rs.getString(1) + " " +
                                rs.getString(2) + " " +
                                rs.getString(3) + " " +
                                rs.getString(4));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    public String  ausgebenOutfit(){
        String m= "";
        String n= "";
        String o= "";
        String c="";
        String a="";
        String b="";
        try {
            String abfrage = "SELECT * FROM Schuhe";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);

            while (rs.next()) {
                m = rs.getString(1) + "," +
                        rs.getString(2) + "," +
                        rs.getString(3) + "," +
                        rs.getString(4);
                c=c+"   "+m;
            }

            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        try {
            String abfrage = "SELECT * FROM Oberteil";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);

            while (rs.next()) {
                n = rs.getString(1) + "," +
                        rs.getString(2) + "," +
                        rs.getString(3) + "," +
                        rs.getString(4);
                a=a+"   "+n;
            }

            System.out.println(n);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        try {
            String abfrage = "SELECT * FROM Hose";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);

            while (rs.next()) {
                o = rs.getString(1) + "," +
                        rs.getString(2) + "," +
                        rs.getString(3) + "," +
                        rs.getString(4);
                b=b+"   "+o;
            }

            System.out.println(o);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return ""+c+"\n "+a+"\n "+"\n "+b+"\n";
    }

}












