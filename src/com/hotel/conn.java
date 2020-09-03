package com.hotel;

import java.sql.*;


public class conn {

    Connection c;
    Statement s;

    public conn(){
        try{
            // register driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // download jar file and add it to library in project struct
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","mysql");
            s = c.createStatement();


        }catch(Exception e){
            // print the stack
            e.printStackTrace();

        }
    }

}