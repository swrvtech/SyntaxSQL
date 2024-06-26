package com.swervtech.hrmsproject;

import java.sql.*;
import java.util.*;

public class E3 {
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
            // gets the metadata of the resultset
            ResultSetMetaData rsm = resultset.getMetaData();

            List<Map<String,String>> tableData = new ArrayList<>();

            // iterates through the resultset and prints the values
            while(resultset.next()){
                // creates a map to store the values of each row
                Map<String,String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i < rsm.getColumnCount(); i++) {
                    String key = rsm.getColumnLabel(i);
                    String value = resultset.getString(i);
                    rowMap.put(key,value);
                }
                // adds the map to the list
                tableData.add(rowMap);
            }
            // prints the table data
            System.out.println(tableData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
