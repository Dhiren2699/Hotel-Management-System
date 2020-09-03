package com.hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    //constructor
    login(){
        //username
        l1 = new JLabel("Username");
        l1.setBounds(40,30,100,30);
        add(l1);

        //password
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);


        //textfield
        t1 = new JTextField();
        t1.setBounds(150,30,100,30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150,70,100,30);
        add(t2);


        //Button
        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,130,120,30);
        b1.addActionListener(this); // ActionListener on press
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,130,120,30);
        b2.addActionListener(this);
        add(b2);


        //Add Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotel/Icons/second.jpg"));
        //Resize the image. create image object, specify dimensions
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        //Make that image to image icon then add it to label
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3); // add image in label
        l3.setBounds(350,10,200,200);
        add(l3);

        //set bg color white of whole frame
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(400,200,600,270);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        // there are 2 buttons so use getsource to match the button click
        if(ae.getSource() == b1){
            String username =t1.getText(); // get username input
            String password = t2.getText();
            conn c = new conn(); // make object of conn class

            // sql query
            String str = "Select * from login where username = '"+username+"' and password = '"+password+"'";

            //Execute query
            // s is statement
            try {
                ResultSet rs =c.s.executeQuery(str); // store the result in resultset class

                // if username matches with input
                // cuz we want to close it now
                if(rs.next()){
                    new Dashboard().setVisible(true); // goes to dashboard if matches
                    this.setVisible(false);
                }else{
                    // swing class to print message dialog
                    JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                    this.setVisible(false);
                }
            }catch(Exception e){

            }


        }else if(ae.getSource() == b2){
            System.exit(0); // exit project if clicked cancel
        }

    }

    public static void main(String[] args){
        new login();
    }
}
