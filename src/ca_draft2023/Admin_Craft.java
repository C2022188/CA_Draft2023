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
public class Admin_Craft extends Users {
    
     public Admin_Craft(int ID, String firstName, String lastName, String email, String PPSN, double grossIncome, double taxCredit, double taxOwed, String username, String password) {
        super(ID, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed, username, password);
    }
//    
//  public void modifyOwnProfile(String newFirstName, String newLastName, String newemail, String newPPSN, double newgrossIncome, double newtaxCredit, double newtaxOwed, String newusername, String newpassword) {
//        setFirstName(newFirstName);
//        setLastName(newLastName);
//        setEmail(newemail);
//        setPPSN(newPPSN);
//        setGrossIncome(newgrossIncome);
//        setTaxCredit(newtaxCredit);
//        setTaxOwed(newtaxOwed);
//        setUsername(newusername);
//        setPassword(newpassword);
//}
//    
//
//    
//       
//    // Method to access a list of all other users in the system
//    public List<Users> getAllUsers(List<Users> usersList) {
//        List<Users> otherUsers = new ArrayList<>(usersList);
//
//        otherUsers.remove(this); // Remove the manager from the list
//        return otherUsers;
//    }
//
//
//
//    // Method to remove other users from the system
//    public void removeUser(List<Users> usersList, Users userToRemove) {
//        if (usersList.contains(userToRemove)) {
//            usersList.remove(userToRemove);
//
//            System.out.println(userToRemove.getFirstName() + " " + userToRemove.getLastName() + " removed from the system.");
//        } else {
//            System.out.println("User not found in the system.");
//        }
//    }
//
//    
//    public void reviewUserOperations(Users user) {
//        
//        System.out.println("Reviewing operations performed by " + user.getFirstName() + " " + user.getLastName());
//    }
//}


  public static double calculatePRSI(double grossIncome) {
    double prsi;
    
    if (grossIncome <= 398) {
        prsi = grossIncome * 0.005; // 0.5% PRSI rate for income up to €398
    } else {
        double remainingIncome = grossIncome - 398;
        prsi = (398 * 0.005) + (remainingIncome * 0.02); // 0.5% up to €398, 2% above that
    }

    return prsi;
}
  

    public static double calculateUSC(double grossIncome) {

    
    double rate1 = 0.005;
    double rate2 = 0.02;
    double rate3 = 0.045;

    double band1 = 12012.00;
    double band2 = 19068.00;

    double USC;
    
    if (grossIncome <= band1) {
        USC = grossIncome * rate1;
    } else if (grossIncome <= band2) {
        USC = (band1 * rate1) + ((grossIncome - band1) * rate2);
    } else {
        USC = (band1 * rate1) + ((band2 - band1) * rate2) + ((grossIncome - band2) * rate3);
    }
    
    return USC;
}
}

    


