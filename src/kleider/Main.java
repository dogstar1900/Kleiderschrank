package kleider;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {

    private static String sqlBefehl = "";

    public static void main(String[] args) throws Exception {
        DBConnection db1 = new DBConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("***** Herzlich Willkommen beim Shop eWaste *****");
        System.out.println("Was möchten sie tun?");
        System.out.println("1. Objekt inserieren");
        System.out.println("2. Objekte anzeigen");
        System.out.println("3. Benutzerkonto anlegen / verwalten");

        int auswahl = sc.nextInt();
        sc.nextLine();

        if(auswahl  == 1){

            try{

                String befehl = sc.nextLine();
                db1.sendSqlBefehl(befehl);

            }catch (SQLException e){

                System.out.println(e);

            }


        }

        //sqlBefehl = sc.nextLine();

        try {
            db1.getSqlEintrag(1);
            db1.getSqlEintrag(2);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
