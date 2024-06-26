package com.swervtech.hrmsproject;

import java.sql.*;

public class E1 {
    public static void main(String[] args) {
        // A db url string contains all the reuiqed info to connect to any database
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        // username and password to connect to the database
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        try {
            // creates a connection to the database
            Connection connection = DriverManager.getConnection(dbURL,userName,password);
            // creates a statement object to execute the query
            Statement statement = connection.createStatement();
            // query to execute
            String query = "Select * from person";
            // executes the query and stores the result in a resultset
            ResultSet resultset = statement.executeQuery(query);
            // iterates through the resultset and prints the values
            while(resultset.next()){
                String firstName = resultset.getString("Firstname");
                int age = resultset.getInt("age");
                String city = resultset.getString("city");
                System.out.println(firstName+" "+age+" "+city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
