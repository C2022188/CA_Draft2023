/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_draft2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author caroo
 */
public class DataBaseWriterDraft extends DatabaseDraft {
    
     public boolean newUser(Users users) throws SQLException {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            String sql = String.format("INSERT INTO " + TABLE_NAME + " VALUES ("
                    + "'%d', '%s', '%s', '%s', '%s', '%f', '%f', '%f', '%b', '%s', %s);",
                    users.getID(), users.getFirstName(), users.getLastName(), users.getEmail(), users.getPPSN(), users.getGrossIncome(), 
                    users.getTaxCredit(), users.getTaxOwed(), users.isUsertype(), users.getUsername(), users.getPassword());
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addAllUsers(List<Users> usersList) {
        return true;
    }
}
    

