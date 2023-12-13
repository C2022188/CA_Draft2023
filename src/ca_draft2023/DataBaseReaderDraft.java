/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_draft2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caroo
 */
public class DataBaseReaderDraft extends DatabaseDraft{
    
    public ArrayList<Users> getAllUsers() {
       ArrayList<Users> usersList =  new ArrayList<>();
    
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement(); 
                ResultSet results = stmt.executeQuery(String.format(
                    "SELECT * FROM %s;",
                    TABLE_NAME));
        ){
    
            while (results.next()){
           
           System.out.println(results.getString("firstName"));
                int ID = results.getInt("ID");
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");
                String email = results.getString("email");
                String PPSN = results.getString("PPSN");
                double grossIncome = results.getDouble("grossIncome");
                double taxCredit = results.getDouble("taxCredit");
                double taxOwed = results.getDouble("taxOwed");
//                String usertype = results.getString("usertype");
                String username = results.getString("username");
                String password = results.getString("Password");
                
                Admin_Craft adm= new Admin_Craft(ID, firstName, lastName, email,  PPSN, grossIncome, taxCredit, taxOwed, username, password);
                
                usersList.add(adm);
            }
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return usersList;
    }

    
public Users getUsersData(int UsersID) {
            try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
                // Object that stores the result of our query
                ResultSet results = stmt.executeQuery(String.format(
                        "SELECT * FROM %s WHERE id=%d;",
                        TABLE_NAME, UsersID));
                results.next();
                System.out.println(results.getString("firstName"));
                int ID = results.getInt("ID");
                String firstName = results.getString("firstName");
                String lastName = results.getString("lastName");
                String email = results.getString("email");
                String PPSN = results.getString("PPSN");
                double grossIncome = results.getDouble("grossIncome");
                double taxCredit = results.getDouble("taxCredit");
                double taxOwed = results.getDouble("taxOwed");
                String username = results.getString("username");
                String password = results.getString("Password");
                
                Admin_Craft adm= new Admin_Craft (ID, firstName, lastName, email,  PPSN, grossIncome, taxCredit, taxOwed, username, password);
                return adm;
                
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } 
}
}

            
        
    

