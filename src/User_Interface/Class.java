package User_Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Class extends JFrame implements ActionListener{
    private JLabel ClassName;
    private JLabel ClassAttribute;
    private JLabel ClassMethod;
    private JPanel Panel1;
    private JPanel Panel2;

    public Class() {
        setTitle("Main frame");
        setSize(400, 400);
        setLayout(new GridLayout(1, 2, 5, 5));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        setVisible(true);
        setLocationRelativeTo(null);

        Panel1 = new JPanel();
        add(Panel1);
        Panel2 = new JPanel();
        add(Panel2);

        ClassName = new JLabel("Name of class", JLabel.CENTER);
        Panel1.add(ClassName);
        ClassAttribute = new JLabel("Attribute of class",JLabel.CENTER);
        Panel2.add(ClassAttribute);
        ClassMethod = new JLabel("Method of class",JLabel.CENTER);
        Panel2.add(ClassMethod);


    }

    public static void main(String[] args) {
        new Class();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
