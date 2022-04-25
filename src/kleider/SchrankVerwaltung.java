package kleider;

import java.sql.SQLException;
import java.sql.Statement;

public class SchrankVerwaltung {
private Kleidung kleidung;

public SchrankVerwaltung(){

}
public void einfuegenHose(String name, String farbe, String art, String groesse){
try {
  String einfuegen = 
  "INSERT INTO hose(name, farbe, art, groesse) VALUES (" + name + ",'" + farbe + "', '" + art + "', " + groesse + ");";
  Statement stm = con.createStatement();
  stm.execute(einfuegen);
} catch (SQLException e) {
  e.printStackTrace();  
} 
}
public void einfuegenSchuhe(String name, String farbe, String art, String groesse){
  try {
    String einfuegen = 
    "INSERT INTO schuhe(name, farbe, art, groesse) VALUES (" + name + ",'" + farbe + "', '" + art + "', " + groesse + ");";
    Statement stm = con.createStatement();
    stm.execute(einfuegen);
  } catch (SQLException e) {
    e.printStackTrace();  
  } 
  }
  public void einfuegenOberteil(String name, String farbe, String art, String groesse){
    try {
      String einfuegen = 
      "INSERT INTO oberteil(name, farbe, art, groesse) VALUES (" + name + ",'" + farbe + "', '" + art + "', " + groesse + ");";
      Statement stm = con.createStatement();
      stm.execute(einfuegen);
    } catch (SQLException e) {
      e.printStackTrace();  
    } 
    }
    public void loeschenHose(String name, String farbe, String art, String groesse) {
      try {
        String loeschen = "DELETE FROM hose WHERE name = " + name + ";";
        Statement stm = con.createStatement();
        stm.execute(loeschen);
      }catch (SQLException e) {
        e.printStackTrace();
      }
      }
      public void loeschenSchuhe(String name, String farbe, String art, String groesse) {
        try {
          String loeschen = "DELETE FROM Schuhe WHERE name = " + name + ";";
          Statement stm = con.createStatement();
          stm.execute(loeschen);
        }catch (SQLException e) {
          e.printStackTrace();
        }
        }public void loeschenOberteil(String name, String farbe, String art, String groesse) {
          try {
            String loeschen = "DELETE FROM oberteil WHERE name = " + name + ";";
            Statement stm = con.createStatement();
            stm.execute(loeschen);
          }catch (SQLException e) {
            e.printStackTrace();
          }
          }
    public static void main(String[] args) throws SQLException {
       new Schrank();
      // new DatenbankAnbindung();

    }




}





