/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_draft2023;

/**
 *
 * @author caroo
 */
public class Users extends CA_Draft2023{
    
    private int ID;
    private static int currentID = 1;
    
    private String firstName;
    private String lastName;
    private String email;
    private String PPSN;
    private double grossIncome;
    private double taxCredit;
    private double taxOwed;
    
    private boolean usertype;
    private String username;
    private String password;
    

    public Users(int ID, String firstName, String lastName, String email, String PPSN, double grossIncome, double taxCredit, double taxOwed, boolean usertype, String username, String password) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.PPSN = PPSN;
        this.grossIncome = grossIncome;
        this.taxCredit = taxCredit;
        this.taxOwed = taxOwed;
        this.usertype = usertype;
        this.username = username;
        this.password = password;
    }


   

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPPSN(String PPSN) {
        this.PPSN = PPSN;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public void setTaxCredit(double taxCredit) {
        this.taxCredit = taxCredit;
    }

    public void setTaxOwed(double taxOwed) {
        this.taxOwed = taxOwed;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPPSN() {
        return PPSN;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public double getTaxCredit() {
        return taxCredit;
    }

    public double getTaxOwed() {
        return taxOwed;
    }

    public boolean isUsertype() {
        return usertype;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public int getID() {
        return ID;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
