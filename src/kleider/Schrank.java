package kleider;
import java.awt.font.LineBreakMeasurer;
import java.sql.*;
import com.mysql.cj.x.protobuf.MysqlxCrud;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class Schrank extends JFrame implements ActionListener {

   String test="";
    String testS = "", testH = "", testO = "";

    //String test2S="",test2H="",test2O="";

    String name2="";
    String groesse="";
    String farbe="";
    String art="";
    String langKurz="";
    String schuhTyp="";
    int sID=0,hID=0,oID=0;



    JTextField artikelN;
    JTextField loeschenName;
    JTextField loeschenGroesse;
    JTextField loeschenFarbe;
    JTextField loeschenID;
    JTextField loeschenArt;


    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton allesAkzept;
    JButton selectLoeschen;
    JButton allesLoeschen;
    JButton randomOutfit;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel klamotteAnzeigen;
    JLabel groesseL;
    JLabel farbeL;
    JLabel schuhArtl;

    JTextArea angezeigteKleidungS;
    JTextArea angezeigteKleidungH;
    JTextArea angezeigteKleidungO;

    JTextArea angezeigteKleidungLoeschenS;
    JTextArea angezeigteKleidungLoeschenH;
    JTextArea angezeigteKleidungLoeschenO;

    JTextArea outfitAngezeigt;

    JLabel loeschenArtText;
    JLabel loeschenIDText;

    JLabel name;

    JRadioButton kurzHose;
    JRadioButton langHose;
    JRadioButton kurzOberteil;
    JRadioButton langOberteil;
    JRadioButton schuhe;

    ButtonGroup gruppeteile;
    JPanel panelGruppe;
    JComboBox groessenListe;
    JComboBox schuhArt;
    JComboBox farbenListe;



    public Schrank(){

        this.setTitle("Digitaler Kleiderschrank");
        this.getContentPane().setLayout(null);
        this.setBounds(260,150,900,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.blue);
        this.setResizable(false);


        //TextField
        artikelN = new JTextField();
        this.add(artikelN);
        artikelN.setBounds(380,110,130,20);

        loeschenArt = new JTextField();
        this.add(loeschenArt);
        loeschenArt.setBounds(70,110,130,20);

        loeschenID = new JTextField();
        this.add(loeschenID);
        loeschenID.setBounds(270,110,130,20);




        //Buttons menu
        button1=new JButton("Kleidung zeigen");
        this.add(button1);
        button1.setBounds(50,20,200,40);
        button1.addActionListener(this);

        button2=new JButton("Kleidung hinzufügen");
        this.add(button2);
        button2.setBounds(250,20,200,40);
        button2.addActionListener(this);

        button3=new JButton("Kleidung entfernen");
        this.add(button3);
        button3.setBounds(450,20,200,40);
        button3.addActionListener(this);

        button4=new JButton("Ouftfit zusammenstellen");
        this.add(button4);
        button4.setBounds(650,20,200,40);
        button4.addActionListener(this);

        allesAkzept =new JButton("hinzufügen");
        this.add(allesAkzept);
        allesAkzept.setBounds(380,530,130,20);
        allesAkzept.addActionListener(this);

        selectLoeschen = new JButton("Löschen");
        this.add(selectLoeschen);
        selectLoeschen.setBounds(450,530,130,20);
        selectLoeschen.addActionListener(this);

        allesLoeschen = new JButton("Alles Löschen");
        this.add(allesLoeschen);
        allesLoeschen.setBounds(300,530,130,20);
        allesLoeschen.addActionListener(this);

        randomOutfit = new JButton("Outfit aussgeben");
        this.add(randomOutfit);
        randomOutfit.setBounds(380,530,130,20);
        randomOutfit.addActionListener(this);

        //Label
        label1 = new JLabel("Kleidung zeigen");
        this.add(label1);
        label1.setBounds(400,70,200,30);

        klamotteAnzeigen = new JLabel("");

        angezeigteKleidungS=new JTextArea("");
        this.add(angezeigteKleidungS);
        angezeigteKleidungS.setBounds(10,100,280,450);

        angezeigteKleidungH=new JTextArea("");
        this.add(angezeigteKleidungH);
        angezeigteKleidungH.setBounds(310,100,280,450);

        angezeigteKleidungO=new JTextArea("");
        this.add(angezeigteKleidungO);
        angezeigteKleidungO.setBounds(610,100,280,450);
        //angezeigteKleidung.setBackground(Color.black);

        angezeigteKleidungLoeschenS = new JTextArea("");
        this.add(angezeigteKleidungLoeschenS);
        angezeigteKleidungLoeschenS.setBounds(10,150,280,350);

        angezeigteKleidungLoeschenH=new JTextArea("");
        this.add(angezeigteKleidungLoeschenH);
        angezeigteKleidungLoeschenH.setBounds(310,150,280,350);

        angezeigteKleidungLoeschenO=new JTextArea("");
        this.add(angezeigteKleidungLoeschenO);
        angezeigteKleidungLoeschenO.setBounds(610,150,280,350);

        outfitAngezeigt = new JTextArea("");
        this.add(outfitAngezeigt);
        outfitAngezeigt.setBounds(400,150,280,20);


        label2 = new JLabel("Kleidung hinzufügen");
        this.add(label2);
        label2.setBounds(380,70,200,30);

        label3 = new JLabel("Kleidung entfernen");
        this.add(label3);
        label3.setBounds(380,70,200,30);

        label4 = new JLabel("Outfit zusammenstellen");
        this.add(label4);
        label4.setBounds(380,70,200,30);



        name = new JLabel("Name: ");
        this.add(name);
        name.setBounds(330,110,130,20);

        groesseL = new JLabel("Größe wählen:");
        this.add(groesseL);
        groesseL.setBounds(285,320,200,20);

        farbeL = new JLabel("Farbe wählen:");
        this.add(farbeL);
        farbeL.setBounds(285,370,200,20);

        schuhArtl = new JLabel("Schuhart wählen:");
        this.add(schuhArtl);
        schuhArtl.setBounds(275,420,200,20);



        loeschenArtText = new JLabel("Art:");
        this.add(loeschenArtText);
        loeschenArtText.setBounds(50,110,200,20);

        loeschenIDText = new JLabel("ID:");
        this.add(loeschenIDText);
        loeschenIDText.setBounds(250,110,200,20);




        //Radio button
        kurzHose = new JRadioButton("Kurze Hose");
        this.add(kurzHose);
        kurzHose.addActionListener(this);

        langHose = new JRadioButton("Lange Hose");
        this.add(langHose);
        langHose.addActionListener(this);

        kurzOberteil = new JRadioButton("Kurzes Oberteil");
        this.add(kurzOberteil);
        kurzOberteil.addActionListener(this);

        langOberteil = new JRadioButton("Langes Oberteil");
        this.add(langOberteil);
        langOberteil.addActionListener(this);

        schuhe = new JRadioButton("Schuhe");
        this.add(schuhe);
        schuhe.addActionListener(this);

        String groesseListe[] = {"Kleidergrößen:","xxs","xs", "xs", "s", "m", "l", "xl", "xxl","Schuhgrößen:", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49"};
        groessenListe = new JComboBox(groesseListe);
        this.add(groessenListe);
        groessenListe.setBounds(380,320,150,20);

        String farbListe[] = {"Farben:","Weiss","Beige","Gruen","Hellgruen","Hellblau","Blau","Gelb","Orange","Rot","Pink","Lila","Grau","Schwarz","Braun"};
        farbenListe = new JComboBox(farbListe);
        this.add(farbenListe);
        farbenListe.setBounds(380,370,150,20);

        String schuhListe[] = {"Schuhart","Sneaker","Sportschuhe","Sandalen","Stiefel","Highheels","Lackschuhe"};
        schuhArt = new JComboBox(schuhListe);
        this.add(schuhArt);
        schuhArt.setBounds(380,420,150,20);


        //Group of radio buttons
        gruppeteile = new ButtonGroup();
        gruppeteile.add(kurzHose);
        gruppeteile.add(langHose);
        gruppeteile.add(kurzOberteil);
        gruppeteile.add(langOberteil);
        gruppeteile.add(schuhe);

        panelGruppe = new JPanel();
        panelGruppe.add(kurzHose);
        panelGruppe.add(langHose);
        panelGruppe.add(kurzOberteil);
        panelGruppe.add(langOberteil);
        panelGruppe.add(schuhe);
        this.add(panelGruppe);
        panelGruppe.setBounds(380,150,130,150);
        //panelGruppe.setBackground(Color.black);


        this.setVisible(true);
        allesWeg();
    }
    public void allesWeg() {
        artikelN.setVisible(false);

        allesAkzept.setVisible(false);
        selectLoeschen.setVisible(false);
        allesLoeschen.setVisible(false);
        randomOutfit.setVisible(false);
        outfitAngezeigt.setVisible(false);

        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        //angezeigteKleidung.setVisible(false);


        name.setVisible(false);

        loeschenArtText.setVisible(false);
        loeschenArt.setVisible(false);

        loeschenIDText.setVisible(false);
        loeschenID.setVisible(false);

        kurzHose.setVisible(false);
        langHose.setVisible(false);
        kurzOberteil.setVisible(false);
        langOberteil.setVisible(false);
        schuhe.setVisible(false);


        panelGruppe.setVisible(false);
        klamotteAnzeigen.setVisible(false);
        groessenListe.setVisible(false);
        groesseL.setVisible(false);
        farbenListe.setVisible(false);
        farbeL.setVisible(false);
        schuhArt.setVisible(false);
        schuhArtl.setVisible(false);

    }

    public void seite1() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label1.setVisible(true);
        klamotteAnzeigen.setVisible(true);
        //angezeigteKleidung.setVisible(true);
    }

    public void seite2() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label2.setVisible(true);
        name.setVisible(true);
        artikelN.setVisible(true);
        kurzHose.setVisible(true);
        langHose.setVisible(true);
        kurzOberteil.setVisible(true);
        langOberteil.setVisible(true);
        schuhe.setVisible(true);
        panelGruppe.setVisible(true);
        allesAkzept.setVisible(true);
        groessenListe.setVisible(true);
        groesseL.setVisible(true);
        farbenListe.setVisible(true);
        farbeL.setVisible(true);

    }

    public void seite3() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label3.setVisible(true);


        selectLoeschen.setVisible(true);
        allesLoeschen.setVisible(true);
        loeschenArt.setVisible(true);
        loeschenArtText.setVisible(true);

        loeschenIDText.setVisible(true);
        loeschenID.setVisible(true);
    }

    public void seite4() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label4.setVisible(true);
        randomOutfit.setVisible(true);
        outfitAngezeigt.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1) {
            schuhArt.setVisible(false);
            allesWeg();
            seite1();

            System.out.println("button1");

            try {
                angezeigteKleidungLoeschenS.setVisible(false);
                angezeigteKleidungLoeschenH.setVisible(false);
                angezeigteKleidungLoeschenO.setVisible(false);

                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.ausgebenOutfit();

                testS = db2.ausgebenOutfitS();
                testH = db2.ausgebenOutfitH();
                testO = db2.ausgebenOutfitO();

                angezeigteKleidungH.setVisible(true);
                angezeigteKleidungS.setVisible(true);
                angezeigteKleidungO.setVisible(true);
                //angezeigteKleidung.setBackground(Color.black);

                angezeigteKleidungS.setText(testS);
                angezeigteKleidungH.setText(testH);
                angezeigteKleidungO.setText(testO);

                System.out.println(test);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==button2) {
            angezeigteKleidungLoeschenH.setVisible(false);
            angezeigteKleidungLoeschenS.setVisible(false);
            angezeigteKleidungLoeschenO.setVisible(false);

            angezeigteKleidungH.setVisible(false);
            angezeigteKleidungS.setVisible(false);
            angezeigteKleidungO.setVisible(false);

            allesWeg();
            seite2();
            System.out.println("button2");
        }
        if(e.getSource()==button3) {
            try {
                allesWeg();
                schuhArt.setVisible(false);
                seite3();
                System.out.println("button3");

                angezeigteKleidungS.setVisible(false);
                angezeigteKleidungH.setVisible(false);
                angezeigteKleidungO.setVisible(false);

                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.ausgebenOutfit();

                testS = db2.ausgebenOutfitS();
                testH = db2.ausgebenOutfitH();
                testO = db2.ausgebenOutfitO();

                angezeigteKleidungLoeschenS.setVisible(true);
                angezeigteKleidungLoeschenH.setVisible(true);
                angezeigteKleidungLoeschenO.setVisible(true);

                //angezeigteKleidung.setBackground(Color.black);

                angezeigteKleidungS.setText(testS);
                angezeigteKleidungH.setText(testH);
                angezeigteKleidungO.setText(testO);

                System.out.println(test);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }



            try {
                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.ausgebenOutfit();
                test = db2.ausgebenOutfit();
                angezeigteKleidungLoeschenS.setVisible(true);
                angezeigteKleidungLoeschenO.setVisible(true);
                angezeigteKleidungLoeschenH.setVisible(true);
                //angezeigteKleidung.setBackground(Color.black);

                angezeigteKleidungLoeschenS.setText(testS);
                angezeigteKleidungLoeschenH.setText(testH);
                angezeigteKleidungLoeschenO.setText(testO);

                System.out.println(test);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //angezeigteKleidung.setBackground(Color.black);

            angezeigteKleidungS.setText(testS);
            angezeigteKleidungO.setText(testO);
            angezeigteKleidungH.setText(testH);

            System.out.println(test);


        }
        if(e.getSource()==button4) {
            angezeigteKleidungLoeschenS.setVisible(false);
            angezeigteKleidungLoeschenH.setVisible(false);
            angezeigteKleidungLoeschenO.setVisible(false);

            angezeigteKleidungS.setVisible(false);
            angezeigteKleidungO.setVisible(false);
            angezeigteKleidungH.setVisible(false);

            schuhArt.setVisible(false);
            allesWeg();
            seite4();
            System.out.println("button4");

        }

        if(kurzOberteil.isSelected()) {

            System.out.println("Kurz Oberteil");
            langKurz = "KO";
            schuhArt.setVisible(false);
            schuhArtl.setVisible(false);
        }
        if(langOberteil.isSelected() == true) {

            System.out.println("Lang Oberteil");
            langKurz = "LO";
            schuhArt.setVisible(false);
            schuhArtl.setVisible(false);
        }
        if(kurzHose.isSelected() == true) {

            System.out.println("Kurze Hose");
            langKurz = "KH";
            schuhArt.setVisible(false);
            schuhArtl.setVisible(false);
        }
        if(langHose.isSelected() == true) {

            System.out.println("Lang Hose");
            langKurz = "LH";
            schuhArt.setVisible(false);
            schuhArtl.setVisible(false);
        }
        if(schuhe.isSelected() == true) {

            System.out.println("Schuh");
            langKurz = "SH";
            schuhArt.setVisible(false);
            schuhArtl.setVisible(false);


        }
        if(e.getSource()==selectLoeschen){

            System.out.println("F");
            switch (loeschenArt.getText()){
                case "Kurze Hose":
                    System.out.println("M");
                    String la = loeschenArt.getText();
                    String strID = loeschenID.getText();
                    int li = Integer.parseInt(strID);
                    try {
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenHose(la,li);

                       String test2H="";
                        test2H = db2.ausgebenOutfitH();
                        angezeigteKleidungLoeschenH.setText(test2H);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    //System.out.println(ln+""+la+""+lg);

                    break;
                case "Lange Hose":
                    System.out.println("M");
                    la = loeschenArt.getText();
                    strID = loeschenID.getText();
                    li = Integer.parseInt(strID);

                    try {
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenHose(la,li);

                        String test2H="";
                        test2H = db2.ausgebenOutfitH();
                        angezeigteKleidungLoeschenH.setText(test2H);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    //System.out.println(ln+""+la+""+lg);
                    break;
                case "Kurzes Oberteil":
                    try {
                        la = loeschenArt.getText();
                        strID = loeschenID.getText();
                        li = Integer.parseInt(strID);

                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenOberteil(la,li);
                        //System.out.println(ln+""+la+""+lg);

                        String test2O="";
                        test2O = db2.ausgebenOutfitO();
                        angezeigteKleidungLoeschenO.setText(test2O);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Langes Oberteil":
                    try {
                        la = loeschenArt.getText();
                        strID = loeschenID.getText();
                        li = Integer.parseInt(strID);

                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenOberteil(la,li);
                        //System.out.println(ln+""+la+""+lg);

                        String test2O="";
                        test2O = db2.ausgebenOutfitO();
                        angezeigteKleidungLoeschenO.setText(test2O);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Schuh":
                    try {
                        la = loeschenArt.getText();
                        strID = loeschenID.getText();
                        li = Integer.parseInt(strID);

                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenSchuhe(la,li);
                        //System.out.println(ln+""+la+""+lg);

                        String test2S="";
                        test2S = db2.ausgebenOutfitS();
                        angezeigteKleidungLoeschenS.setText(test2S);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;

            }
            loeschenID.setText("");
            loeschenArt.setText("");

        }
        if(e.getSource()==allesLoeschen){
            try {
                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.tabellenLeeren();

                String test2S="";
                String test2H="";
                String test2O="";

                test2S = db2.ausgebenOutfit();
                angezeigteKleidungLoeschenS.setText(test2S);
                test2H = db2.ausgebenOutfit();
                angezeigteKleidungLoeschenH.setText(test2H);
                test2O = db2.ausgebenOutfit();
                angezeigteKleidungLoeschenO.setText(test2O);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        if(e.getSource()==allesAkzept) {

            gruppeteile.clearSelection();

            name2 = artikelN.getText();
            artikelN.setText("");
            System.out.println(name2);

            groesse = (String) groessenListe.getItemAt(groessenListe.getSelectedIndex());
            System.out.println(groesse);

            farbe = (String) farbenListe.getItemAt(farbenListe.getSelectedIndex());
            System.out.println(farbe);

            schuhTyp = (String) schuhArt.getItemAt(schuhArt.getSelectedIndex());
            System.out.println(schuhTyp);


            switch(langKurz){
                case "KO":
                    try {
                        langKurz = "Kurzes Oberteil";
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.einfuegenOberteil(name2,farbe,langKurz,groesse);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "LO":
                    try {
                        langKurz = "Langes Oberteil";
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.einfuegenOberteil(name2,farbe,langKurz,groesse);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "KH":
                    try {
                        langKurz = "Kurze Hose";
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.einfuegenHose(name2,farbe,langKurz,groesse);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "LH":
                    try {
                        langKurz = "Lange Hose";
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.einfuegenHose(name2,farbe,langKurz,groesse);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "SH":
                    try {
                        langKurz = "Schuh";
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.einfuegenSchuhe(name2,farbe,langKurz,groesse);
                        System.out.println("moin");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;


            }

        }
        if(e.getSource()==randomOutfit){
            try {
                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.zusammenstellenOutfit();
                String testao="";
                testao = db2.zusammenstellenOutfit();
                outfitAngezeigt.setText(testao);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    public String getName2() {
        return name2;
    }

    public String getGroesse() {
        return groesse;
    }

    public String getFarbe() {
        return farbe;
    }
}

//fertig