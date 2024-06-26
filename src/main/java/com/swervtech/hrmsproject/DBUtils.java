package com.swervtech.hrmsproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static List<Map<String, String>> fetch(String query) {
        List<Map<String, String>> tableData = new ArrayList<>();
        try {
            // creates a connection to the database
            Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
            // creates a statement object to execute the query
            Statement statement = connection.createStatement();
            // executes the query and stores the result in a resultset
            ResultSet resultset = statement.executeQuery(query);
            // gets the metadata of the resultset
            ResultSetMetaData rsm = resultset.getMetaData();

            // iterates through the resultset and prints the values
            while (resultset.next()) {
                // creates a map to store the values of each row
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String key = rsm.getColumnLabel(i);
                    String value = resultset.getString(i);
                    rowMap.put(key, value);
                }
                // adds the map to the list
                tableData.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableData;
    }
}
