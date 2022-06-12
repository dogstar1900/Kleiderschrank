package kleider;

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
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS Hose  (hID INTEGER NOT NULL AUTO_INCREMENT, name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255), PRIMARY KEY (hID));");
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS Schuhe  (sID INTEGER NOT NULL AUTO_INCREMENT, name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255), PRIMARY KEY (sID));");
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS Oberteil  (oID INTEGER NOT NULL AUTO_INCREMENT, name varchar(255), farbe varchar(255), art varchar(255), groesse varchar(255), PRIMARY KEY (oID));");


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

    public void loeschenHose(String art, int hID) {
        try {
            String loeschen = "DELETE FROM Hose WHERE hID = '" + hID + "';";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loeschenSchuhe(String art, int sID) {
        try {
            String loeschen = "DELETE FROM Schuhe WHERE sID = '"+sID+"' ;";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loeschenOberteil(String art, int oID) {
        try {
            String loeschen = "DELETE FROM Oberteil WHERE oID = '"+oID+"' ;";
            Statement stm = conn.createStatement();
            stm.execute(loeschen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String zusammenstellenOutfit() {

        String m="",c="",d="",n="";

        String farb = "";
        int random = (int) (Math.random() * 14);

        
        switch (1) {
            case 1:
                farb = "schwarz";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'schwarz' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);


                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }

                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'rot' OR farbe LIKE 'gelb' OR farbe LIKE 'orange' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' OR farbe LIKE 'gruen' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    ResultSet rp = stm.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                farb = "Rot";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'rot' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }

                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    ResultSet rp = stm.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();

                }

                break;
            case 3:
                farb = "gelb";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'gelb' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                farb = "gr�n";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'gruen' ORDER BY RAND() LIMIT 1";

                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }

                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' OR farbe LIKE 'schwarz' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                farb = "braun";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'braun' ORDER BY RAND() LIMIT 1";

                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' OR farbe LIKE 'schwarz' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                farb = "grau";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'grau' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                farb = "weiss";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'weiss' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' OR farbe LIKE 'gruen' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                farb = "orange";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'orange' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'blau' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 9:
                farb = "blau";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'blau' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'blau' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 10:
                farb = "hellblau";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'hellblau' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'blau' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 11:
                farb = "beige";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'beige' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'blau' OR farbe LIKE 'hellblau' ORDER BY RAND() LIMIT 1";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 12:
                farb = "hellgr�n";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'hellgruen' ORDER BY RAND() LIMIT 1";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1 ";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 13:
                farb = "pink";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'pink' ORDER BY RAND() LIMIT 1; ";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;

                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1 ";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+""+n;
                    }
                    if(d.isBlank()){
                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 14:
                farb = "Lila";
                try {
                    String abfrage = "SELECT * FROM Oberteil WHERE farbe LIKE 'lila' ORDER BY RAND() LIMIT 1; ";
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(abfrage);
                    while (rs.next()) {
                        m = rs.getString(1) + ", " +
                                rs.getString(2) + ", " +
                                rs.getString(3) + ", " +
                                rs.getString(4);
                        c=c+""+m;
                    }if(c.isBlank()){
                        System.out.println("ja");
                        zusammenstellenOutfit();
                    }
                    String abfrage2 = "SELECT * FROM Hose WHERE farbe LIKE 'grau' OR farbe LIKE 'schwarz' OR farbe LIKE 'beige' ORDER BY RAND() LIMIT 1 ";
                    Statement sta = conn.createStatement();
                    ResultSet rp = sta.executeQuery(abfrage2);

                    while (rp.next()) {
                        n = rp.getString(1) + ", " +
                                rp.getString(2) + ", " +
                                rp.getString(3) + ", " +
                                rp.getString(4);
                        d=d+"\n   "+n;
                    }if(d.isBlank()){

                        zusammenstellenOutfit();
                    }
                    System.out.println(c+d);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;



        }
        String a = c+d;
        return a;
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
                m = rs.getInt(1) + ", " +
                        rs.getString(2) + ", " +
                        rs.getString(3) + ", " +
                        rs.getString(4) + ", " +
                        rs.getString(5);
                c=c+"\n   "+m;
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
                n = rs.getInt(1) + ", " +
                        rs.getString(2) + ", " +
                        rs.getString(3) + ", " +
                        rs.getString(4) + ", " +
                        rs.getString(5);
                a=a+"\n   "+n;
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
                o = rs.getInt(1) + ", " +
                        rs.getString(2) + ", " +
                        rs.getString(3) + ", " +
                        rs.getString(4) + ", " +
                        rs.getString(5);
                b=b+"\n   "+o;
            }

            System.out.println(o);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return c+ a+ b;
    }
    public String  ausgebenOutfitS(){
        String m= "";
        String c="";

        try {
            String abfrage = "SELECT * FROM Schuhe";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);

            while (rs.next()) {
                m = rs.getInt(1) + ", " +
                        rs.getString(2) + ", " +
                        rs.getString(3) + ", " +
                        rs.getString(4) + ", " +
                        rs.getString(5);
                c=c+"\n   "+m;
            }

            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return c ;
    }
    public String  ausgebenOutfitH(){
        String m= "";
        String c="";

        try {
            String abfrage = "SELECT * FROM Hose";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);

            while (rs.next()) {
                m = rs.getInt(1) + ", " +
                        rs.getString(2) + ", " +
                        rs.getString(3) + ", " +
                        rs.getString(4) + ", " +
                        rs.getString(5);
                c=c+"\n   "+m;
            }

            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return c ;
    }
    public String  ausgebenOutfitO(){
        String m= "";
        String c="";

        try {
            String abfrage = "SELECT * FROM Oberteil";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(abfrage);

            while (rs.next()) {
                m = rs.getInt(1) + ", " +
                        rs.getString(2) + ", " +
                        rs.getString(3) + ", " +
                        rs.getString(4) + ", " +
                        rs.getString(5);
                c=c+"\n   "+m;
            }

            System.out.println(m);
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return c ;
    }

    public void tabellenLeeren(){
        try {
            String loeschenH = "DELETE FROM Hose;";
            Statement stm = conn.createStatement();
            stm.execute(loeschenH);

            String loeschenO = "DELETE FROM Oberteil;";
            stm = conn.createStatement();
            stm.execute(loeschenO);

            String loeschenS = "DELETE FROM Schuhe;";
            stm = conn.createStatement();
            stm.execute(loeschenS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}