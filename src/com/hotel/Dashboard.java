package com.hotel;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){
        mb = new JMenuBar();
        add(mb);

        // Menu Tabs
        m1= new JMenu("Hotel Management");
        m1.setForeground(Color.BLUE);
        mb.add(m1);

        m2= new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1 = new JMenuItem("Reception");
        m1.add(i1);

        i2 = new JMenuItem("Add Employee");
        m2.add(i2);

        i3 = new JMenuItem("Add Rooms");
        m2.add(i3);

        i4 = new JMenuItem("Add Drivers");
        m2.add(i4);

        // set menu bar up
        mb.setBounds(0,0,1900,40);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotel/Icons/third.jpg"));
        // Change size of image
        Image i2 = i1.getImage().getScaledInstance(1359,727,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1359,727);
        add(l1);


        //Text on Screen
        JLabel l2 = new JLabel("Welcome to my Hotel!");
        l2.setBounds(400,100,600,50);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,50));
        l1.add(l2);


        setLayout(null);
        setBounds(0,0,1359,727);
        setVisible(true);
    }

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
}
