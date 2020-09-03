package com.hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class register extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    //constructor
    register() {
        //username
        l1 = new JLabel("Username");
        l1.setBounds(40, 30, 100, 30);
        add(l1);

        //password
        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);


        //textfield
        t1 = new JTextField();
        t1.setBounds(150, 30, 100, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150, 70, 100, 30);
        add(t2);


        //Button
        b1 = new JButton("Register");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40, 130, 120, 30);
        b1.addActionListener(this); // ActionListener on press
        add(b1);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,200,600,270);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String username =t1.getText(); // get username input
        String password = t2.getText();
        conn c = new conn(); // make object of conn class


        String str ="insert into login values('"+username+"','"+password+"')";

        try {
            Statement stmt = c.c.createStatement();


            stmt.executeUpdate(str);

            new login().setVisible(true); // goes to dashboard if matches
            this.setVisible(false);

        }catch(Exception e){

        }

    }

    public static void main(String[] args){
        new register();
    }
}