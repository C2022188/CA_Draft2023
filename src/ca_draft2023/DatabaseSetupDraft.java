/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_draft2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author caroo
 */
public class DatabaseSetupDraft extends DatabaseDraft {
    
    public static boolean setupDB() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            
             Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            stmt.execute("USE " + DB_NAME + ";");
            String sql = 
                    "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + "id INT PRIMARY KEY,"
                    + "firstName VARCHAR(255,"
                    + "lastName VARCHAR(255,"
                    + "email VARCHAR(255,"
                    + "PPSN VARCHAR(255,"
                    + "grossIncome DOUBLE(10, 2),"
                    + "taxCredit DOUBLE(10, 2),"
                    + "taxOwed DOUBLE (10, 2),"
                    + "userType BOOLEAN"
                    + ");";
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
}
}
}

// private String firstName;
//    private String lastName;
//    private String email;
//    private String PPSN;
//    private double grossIncome;
//    private double taxCredit;
//    private double taxOwed;
//    private boolean admin;
//    private static int currentID = 1;