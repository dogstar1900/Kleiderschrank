package kleider;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchrankVerwaltung {

    private Connection conn;
    public static void main(String[] args) throws SQLException {
        new Schrank();

        DatenbankAnbindung db1;
        db1 = new DatenbankAnbindung();
        db1.datenbankErstellen();

        //db1.zusammenstellenOutfit();

        //db1.einfuegenSchuhe("rebook","rot","sneaker","46");
        //db1.auslesenSchuhe();
        //db1.loeschenSchuhe("rebook","rot","sneaker","46");

        // db1.einfuegenOberteil("Peso","rot","t-shirt","Xl");
        //db1.auslesenOberteil();
        //db1.loeschenOberteil("Vans","schwarz","longsleve","M");

        //db1.einfuegenHose("Hummel","grün","shorts","XL");
        //db1.auslesenHose();
        //db1.loeschenHose("Hummel","grün","shorts","XL");

        //db1.zusammenstellenOutfit();

        //db1.ausgebenOutfit();
    }





}


