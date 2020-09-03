package com.hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener{


    JTextField t1,t2,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;



    AddEmployee(){

        JLabel name = new JLabel("Name:");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);

        t1 = new JTextField();
        t1.setBounds(140,30,120,30);
        add(t1);


        JLabel age = new JLabel("Age:");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);

        t2 = new JTextField();
        t2.setBounds(140,80,120,30);
        add(t2);

        JLabel Gender = new JLabel("Gender:");
        Gender.setBounds(60,130,120,30);
        Gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(140,130,70,30);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(220,130,90,30);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(r2);

        JLabel job = new JLabel("Job:");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);

        String str[] = {"Front Desk Clerks","House Keeping","Kitchen Staff","Room Service","Manager"};
        c1 = new JComboBox(str);
        c1.setBounds(140,180,140,30);
        add(c1);


        JLabel salary = new JLabel("Salary:");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);

        t5 = new JTextField();
        t5.setBounds(140,230,120,30);
        add(t5);

        JLabel Email = new JLabel("Email:");
        Email.setBounds(60,280,120,30);
        Email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(Email);

        t6 = new JTextField();
        t6.setBounds(140,280,120,30);
        add(t6);

        b1 = new JButton("Submit");
        b1.setBounds(140,340,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);




        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/hotel/Icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(320,420,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(330,55,280,280);
        add(l1);

        JLabel l2 = new JLabel("Add Employee Details");
        l2.setBounds(310,15,450,30);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(l2);




        setLayout(null);
        setBounds(400,180,680,430);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String name = t1.getText();
        String age = t2.getText();
        String salary = t5.getText();
        String Email = t6.getText();

        String gender = null;
        if(r1.isSelected()){
            gender = "Male";

        }else if(r2.isSelected()){
            gender = "Female";
        }

        String job = (String)c1.getSelectedItem();

        conn c = new conn();

        //same seq as database value
        String str = "insert into employee value('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+Email+"')";

        try{
            // we are not comparing values like login so we can execute query direct
            c.s.executeUpdate(str);

            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);


        }catch(Exception e){
            System.out.println(e);

        }



    }

    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }




}
