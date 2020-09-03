package com.hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



// action listener for action
public class Main extends JFrame implements ActionListener {
    //all coding is done in constructor!

    JButton b1,b2;
    Main(){
        //setSize(400,400); // length of frame
        setBounds(0,100,1366,600); //x y is location

        //setLocation(400,300); // location of window

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotel/Icons/first1.jpg")); // for image icons
        JLabel l1 = new JLabel(i1); // put image in label

        l1.setBounds(0,0,1366,600);
        add(l1);

        //button
        b1 = new JButton("Login");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(1150,480,150,30);
        //on press
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("Register");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        b2.setBounds(950,480,150,30);
        //on press
        b2.addActionListener(this);
        l1.add(b2);

        JLabel l3 = new JLabel("Welcome to my Hotel!");
        l3.setBounds(400,150,600,50);
        l3.setForeground(Color.CYAN);
        l3.setFont(new Font("Tahoma",Font.PLAIN,50));
        l1.add(l3);



        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(10,450,1000,75);
        l2.setForeground(Color.WHITE); //awt package
        l2.setFont(new Font("serif",Font.PLAIN,50));
        l1.add(l2); // on image object



        setLayout(null);
        setVisible(true); // its false by default. ALWAYS AT LAST!!!
        // infinite loop down

        // for text l2 to blink every 5 seconds
      while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){

            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            }catch(Exception e){}
        }




    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            // this calls login constructor
            new login().setVisible(true);
            // after action is performed close the current window
            this.setVisible(false);}
        else{
            new register().setVisible(true);
            this.setVisible(false);
            }
    }

    public static void main(String[] args) {
        new Main(); //object
    }
}
