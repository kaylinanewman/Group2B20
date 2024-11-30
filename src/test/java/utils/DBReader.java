package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBReader {
    public static List<Map<String, String>> fetch(String query) {

        String dbURL = ConfigReader.read("dbURL");
        String userName = ConfigReader.read("dbUserName");
        String password = ConfigReader.read("dbPassword");


        List<Map<String, String>> tableData = new ArrayList<>();
        //creating connection
        try (Connection connection = DriverManager.getConnection(dbURL, userName, password);
             //goes to database and executes instructions
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            ResultSetMetaData rsm = resultSet.getMetaData();

            while (resultSet.next()) {
                //for every row we create a new map
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int i = 1; i < rsm.getColumnCount(); i++) {
                    String key = rsm.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key, value);
                }
                tableData.add(rowMap);
            }
        } catch (SQLException sqlException) {
        }

        return tableData;


    }
}