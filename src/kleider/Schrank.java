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

    String test ="";
    String name2="";
    String groesse="";
    String farbe="";
    String art="";
    String langKurz="";
    String schuhTyp="";

    JTextField artikelN;
    JTextField loeschenName;
    JTextField loeschenGroesse;
    JTextField loeschenFarbe;
    JTextField loeschenArt;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton allesAkzept;
    JButton selectLoeschen;
    JButton allesLoeschen;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel klamotteAnzeigen;
    JLabel groesseL;
    JLabel farbeL;
    JLabel schuhArtl;
    JTextArea angezeigteKleidung;
    JTextArea angezeigteKleidungLoeschen;
    JLabel loeschenFarbeText;
    JLabel loeschenGroesseText;
    JLabel loeschenNameText;
    JLabel loeschenArtText;


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

        loeschenName = new JTextField();
        this.add(loeschenName);
        loeschenName.setBounds(290,110,130,20);

        loeschenGroesse = new JTextField();
        this.add(loeschenGroesse);
        loeschenGroesse.setBounds(715,110,130,20);

        loeschenFarbe = new JTextField();
        this.add(loeschenFarbe);
        loeschenFarbe.setBounds(490,110,130,20);

        loeschenArt = new JTextField();
        this.add(loeschenArt);
        loeschenArt.setBounds(70,110,130,20);




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


        //Label
        label1 = new JLabel("Kleidung zeigen");
        this.add(label1);
        label1.setBounds(400,70,200,30);

        klamotteAnzeigen = new JLabel("");

        angezeigteKleidung=new JTextArea("");
        this.add(angezeigteKleidung);
        angezeigteKleidung.setBounds(300,100,300,600);
        //angezeigteKleidung.setBackground(Color.black);

        angezeigteKleidungLoeschen=new JTextArea("");
        this.add(angezeigteKleidungLoeschen);
        angezeigteKleidungLoeschen.setBounds(300,150,300,350);


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

        loeschenFarbeText = new JLabel("Farbe:");
        this.add(loeschenFarbeText);
        loeschenFarbeText.setBounds(450,110,200,20);

        loeschenGroesseText = new JLabel("Größe:");
        this.add(loeschenGroesseText);
        loeschenGroesseText.setBounds(675,110,200,20);

        loeschenNameText = new JLabel("Name:");
        this.add(loeschenNameText);
        loeschenNameText.setBounds(255,110,200,20);

        loeschenArtText = new JLabel("Art:");
        this.add(loeschenArtText);
        loeschenArtText.setBounds(50,110,200,20);


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

        String farbListe[] = {"Farben:","Weiß","Beige","Grün","Hellgrün","Hellblau","Blau","Gelb","Orange","Rot","Pink","Lila","Grau","Schwarz","Braun"};
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

        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        //angezeigteKleidung.setVisible(false);


        name.setVisible(false);

        loeschenFarbe.setVisible(false);
        loeschenGroesse.setVisible(false);
        loeschenName.setVisible(false);
        loeschenNameText.setVisible(false);
        loeschenGroesseText.setVisible(false);
        loeschenFarbeText.setVisible(false);

        loeschenArtText.setVisible(false);
        loeschenArt.setVisible(false);

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
        loeschenFarbe.setVisible(true);
        loeschenGroesse.setVisible(true);
        loeschenName.setVisible(true);
        loeschenNameText.setVisible(true);
        loeschenGroesseText.setVisible(true);
        loeschenFarbeText.setVisible(true);
        selectLoeschen.setVisible(true);
        allesLoeschen.setVisible(true);
        loeschenArt.setVisible(true);
        loeschenArtText.setVisible(true);
    }

    public void seite4() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label4.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1) {

            allesWeg();
            seite1();

            System.out.println("button1");

            try {
                angezeigteKleidungLoeschen.setVisible(false);
                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.ausgebenOutfit();
                test = db2.ausgebenOutfit();
                angezeigteKleidung.setVisible(true);
                //angezeigteKleidung.setBackground(Color.black);

                angezeigteKleidung.setText(test);

                        System.out.println(test);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==button2) {
            angezeigteKleidungLoeschen.setVisible(false);
            angezeigteKleidung.setVisible(false);
            allesWeg();
            seite2();
            System.out.println("button2");
        }
        if(e.getSource()==button3) {
            angezeigteKleidung.setVisible(false);
            allesWeg();
            seite3();
            System.out.println("button3");

            try {
                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.ausgebenOutfit();
                test = db2.ausgebenOutfit();
                angezeigteKleidungLoeschen.setVisible(true);
                //angezeigteKleidung.setBackground(Color.black);

                angezeigteKleidungLoeschen.setText(test);

                System.out.println(test);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //angezeigteKleidung.setBackground(Color.black);

            angezeigteKleidung.setText(test);

            System.out.println(test);


        }
        if(e.getSource()==button4) {
            angezeigteKleidungLoeschen.setVisible(false);
            angezeigteKleidung.setVisible(false);
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
            art = "SH";
            schuhArt.setVisible(true);
            schuhArtl.setVisible(true);


        }
        if(e.getSource()==selectLoeschen){

            System.out.println("F");
            switch (loeschenArt.getText()){
                case "Kurze Hose":
                    System.out.println("M");
                    String la = loeschenArt.getText();
                    String ln = loeschenName.getText();
                    String lg = loeschenGroesse.getText();
                    try {
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenHose(ln,la,lg);
                        String test2="";
                        test2 = db2.ausgebenOutfit();
                        angezeigteKleidungLoeschen.setText(test2);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(ln+""+la+""+lg);

                    break;
                case "Lange Hose":
                    System.out.println("M");
                     la = loeschenArt.getText();
                     ln = loeschenName.getText();
                     lg = loeschenGroesse.getText();
                    try {
                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenHose(ln,la,lg);

                        String test2="";
                        test2 = db2.ausgebenOutfit();
                        angezeigteKleidungLoeschen.setText(test2);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(ln+""+la+""+lg);
                    break;
                case "Kurzes Oberteil":
                    try {
                        la = loeschenArt.getText();
                        ln = loeschenName.getText();
                        lg = loeschenGroesse.getText();

                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenOberteil(ln,la,lg);
                        System.out.println(ln+""+la+""+lg);

                        String test2="";
                        test2 = db2.ausgebenOutfit();
                        angezeigteKleidungLoeschen.setText(test2);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Langes Oberteil":
                    try {
                        la = loeschenArt.getText();
                        ln = loeschenName.getText();
                        lg = loeschenGroesse.getText();

                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenOberteil(ln,la,lg);
                        System.out.println(ln+""+la+""+lg);

                        String test2="";
                        test2 = db2.ausgebenOutfit();
                        angezeigteKleidungLoeschen.setText(test2);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "Schuh":
                    try {
                        la = loeschenArt.getText();
                        ln = loeschenName.getText();
                        lg = loeschenGroesse.getText();

                        DatenbankAnbindung db2 = new DatenbankAnbindung();
                        db2.datenbankNutzen();
                        db2.loeschenSchuhe(ln,la,lg);
                        System.out.println(ln+""+la+""+lg);

                        String test2="";
                        test2 = db2.ausgebenOutfit();
                        angezeigteKleidungLoeschen.setText(test2);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;

            }

            loeschenArt.setText("");
            loeschenGroesse.setText("");
            loeschenName.setText("");
            loeschenFarbe.setText("");
        }
        if(e.getSource()==allesLoeschen){
            try {
                DatenbankAnbindung db2 = new DatenbankAnbindung();
                db2.datenbankNutzen();
                db2.tabellenLeeren();
                
                String test2="";
                test2 = db2.ausgebenOutfit();
                angezeigteKleidungLoeschen.setText(test2);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        if(e.getSource()==allesAkzept) {



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

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
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