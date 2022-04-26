package kleider;

import java.sql.SQLException;
import java.sql.Statement;

public class SchrankVerwaltung {

    public static void main(String[] args) throws SQLException {
       new Schrank();

       DatenbankAnbindung db1 = new DatenbankAnbindung();
       db1.datenbankErstellen();

    }

    public static void hinzufügenOberteil() {

    }

}





