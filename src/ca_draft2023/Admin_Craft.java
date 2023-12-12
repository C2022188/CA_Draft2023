package ca_draft2023;



import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danie
 */
public class Admin_Craft extends Users{
     public Admin_Craft(int ID, String firstName, String lastName, String email, String PPSN, double grossIncome, double taxCredit, double taxOwed, String username, String password) {
        super(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
    }
    
  public void modifyOwnProfile(String newFirstName, String newLastName, String newemail, String newPPSN, double newgrossIncome, double newtaxCredit, double newtaxOwed, String newusername, String newpassword) {
        setFirstName(newFirstName);
        setLastName(newLastName);
        setEmail(newemail);
        setPPSN(newPPSN);
        setGrossIncome(newgrossIncome);
        setTaxCredit(newtaxCredit);
        setTaxOwed(newtaxOwed);
        setUsername(newusername);
        setPassword(newpassword);
}
    

    
       
    // Method to access a list of all other users in the system
    public List<Users> getAllUsers(List<Users> usersList) {
        List<Users> otherUsers = new ArrayList<>(usersList);

        otherUsers.remove(this); // Remove the manager from the list
        return otherUsers;
    }



    // Method to remove other users from the system
    public void removeUser(List<Users> usersList, Users userToRemove) {
        if (usersList.contains(userToRemove)) {
            usersList.remove(userToRemove);

            System.out.println(userToRemove.getFirstName() + " " + userToRemove.getLastName() + " removed from the system.");
        } else {
            System.out.println("User not found in the system.");
        }
    }

    
    public void reviewUserOperations(Users user) {
        
        System.out.println("Reviewing operations performed by " + user.getFirstName() + " " + user.getLastName());
    }
        
    
}

