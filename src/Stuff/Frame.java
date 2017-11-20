package Stuff;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame {
    public Frame() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setLocation(50, 50);
        frame.setLayout(null);        //don't know how this work yet
//        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello world");
        frame.add(label);

      //  label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setHorizontalTextPosition(SwingConstants.LEFT);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setDisplayedMnemonic(1);  //wtf is this thing, i do not know

//        label.setEnabled(false);        //ability to interact

//        BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File("image.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(250, 150, image.SCALE_SMOOTH));
//        label.setIcon(imageIcon);
//        label.setDisabledIcon(imageIcon);

        setText(label);
//
        setPicture(label, "image.jpg");
//
        label.setIconTextGap(100);


        JButton button = new JButton("Click");
        button.setBounds( 800, 50, 150, 50);
        frame.add(button);

    }

    public void setText(JLabel label) {
        label.setText("Goodbye world");
        label.setToolTipText("Now you can close this"); //hint
        label.setForeground(Color.red);
        label.setSize(500, 300);
        System.out.println("x = " + label.getSize().width);
        System.out.println("y = " + label.getSize().height);
    }

    public void setPicture(JLabel label, String filename) {
        try {
            BufferedImage image = ImageIO.read(new File(filename));
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(250, 150, image.SCALE_SMOOTH));
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon("image.jpg");
        label.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        Frame f = new Frame();
    }
}
