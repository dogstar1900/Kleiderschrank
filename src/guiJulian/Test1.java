package guiJulian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 extends JFrame{
    private JButton button1;
    private JPanel panel1;
    private JLabel julian;

    public Test1(){
        super("test1");
        this.setSize(500,200);
        setVisible(true);
        setLocationRelativeTo(null);
        setContentPane(panel1);
        pack();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Test2();
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {
         new Test1();
    }

}
