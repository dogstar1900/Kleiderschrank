package guiJulian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 extends JFrame{
    private JButton test2Button;
    private JPanel panel1;


    public Test2(){
        super("test2");
        setSize(500,200);
        setVisible(true);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        this.pack();


        test2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panel1.setVisible(false);
                new Test1();

            }
        });
}
}
