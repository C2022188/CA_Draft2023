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
public class DataBaseWriterDraft extends DatabaseDraft {
    
     public boolean newUUser(Users users) throws SQLException {
        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();  
        ){
            String sql = String.format("INSERT INTO " + TABLE_NAME + " VALUES ("
                    + "'%s', '%s', '%s', %d);",
                    patient.getName(), patient.getBirthDate(), patient.getBloodType(), patient.getPatientID());
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addAllPatients(List<Patient> patientList) {
        return true;
    }
}
    
}
