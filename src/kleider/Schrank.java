package kleider;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Schrank extends JFrame implements ActionListener {


    JTextField artikelN;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton allesAkzept;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel klamotteAnzeigen;

    JLabel name;

    JRadioButton kaltHose;
    JRadioButton warmHose;
    JRadioButton kaltOberteil;
    JRadioButton warmOberteil;
    JRadioButton schuhe;

    ButtonGroup gruppeteile;
    JPanel panelGruppe;


    Schrank(){



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

        //Label
        label1 = new JLabel("Kleidung zeigen");
        this.add(label1);
        label1.setBounds(380,70,200,30);

        klamotteAnzeigen = new JLabel("");

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

        //Radio button
        kaltHose = new JRadioButton("Kurze Hose");
        this.add(kaltHose);
        kaltHose.addActionListener(this);

        warmHose = new JRadioButton("Lange Hose");
        this.add(warmHose);
        warmHose.addActionListener(this);

        kaltOberteil = new JRadioButton("Kurzes Oberteil");
        this.add(kaltOberteil);
        kaltOberteil.addActionListener(this);

        warmOberteil = new JRadioButton("Warmes Oberteil");
        this.add(warmOberteil);
        warmOberteil.addActionListener(this);

        schuhe = new JRadioButton("Schuhe");
        this.add(schuhe);
        schuhe.addActionListener(this);

        //Group of radio buttons
        gruppeteile = new ButtonGroup();
        gruppeteile.add(kaltHose);
        gruppeteile.add(warmHose);
        gruppeteile.add(kaltOberteil);
        gruppeteile.add(warmOberteil);
        gruppeteile.add(schuhe);

        panelGruppe = new JPanel();
        panelGruppe.add(kaltHose);
        panelGruppe.add(warmHose);
        panelGruppe.add(kaltOberteil);
        panelGruppe.add(warmOberteil);
        panelGruppe.add(schuhe);
        this.add(panelGruppe);
        panelGruppe.setBounds(380,150,130,150);


        this.setVisible(true);
        allesWeg();
    }
    public void allesWeg() {
        artikelN.setVisible(false);

        allesAkzept.setVisible(false);

        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);

        name.setVisible(false);

        kaltHose.setVisible(false);
        warmHose.setVisible(false);
        kaltOberteil.setVisible(false);
        warmOberteil.setVisible(false);
        schuhe.setVisible(false);


        panelGruppe.setVisible(false);
        klamotteAnzeigen.setVisible(false);
    }

    public void seite1() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label1.setVisible(true);
        klamotteAnzeigen.setVisible(true);
    }

    public void seite2() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label2.setVisible(true);
        name.setVisible(true);
        artikelN.setVisible(true);
        kaltHose.setVisible(true);
        warmHose.setVisible(true);
        kaltOberteil.setVisible(true);
        warmOberteil.setVisible(true);
        schuhe.setVisible(true);
        panelGruppe.setVisible(true);
        allesAkzept.setVisible(true);

    }

    public void seite3() {
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        label3.setVisible(true);
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

            try {
                FileReader reader = new FileReader("obj.txt");
                int data= reader.read();

                while(data != -1) {
                    System.out.println(((char)data));
                }
                //klamotteAnzeigen = new JLabel(data);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


            System.out.println("button1");
        }
        if(e.getSource()==button2) {
            allesWeg();
            seite2();
            System.out.println("button2");
        }
        if(e.getSource()==button3) {
            allesWeg();
            seite3();
            System.out.println("button3");
        }
        if(e.getSource()==button4) {
            allesWeg();
            seite4();
            System.out.println("button4");
        }

        if(kaltOberteil.isSelected() == true) {

            System.out.println("ko");
        }
        if(warmOberteil.isSelected() == true) {

            System.out.println("wo");
        }
        if(kaltHose.isSelected() == true) {

            System.out.println("kh");
        }
        if(warmHose.isSelected() == true) {

            System.out.println("wh");
        }
        if(schuhe.isSelected() == true) {

            System.out.println("schuh");
        }
        if(e.getSource()==allesAkzept) {
            String name = artikelN.getText();
            try {
                FileWriter writer = new FileWriter("obj.txt");
                writer.write(name);
            }
            catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            System.out.println(name);
        }



    }




    public static void main(String[] args) {
        new Schrank();
    }
}

