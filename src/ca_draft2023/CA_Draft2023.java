            /*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
             */
            package ca_draft2023;

            import ioutils.IOUtils;
            import java.sql.SQLException;
            import java.util.ArrayList;
            import java.util.Scanner;

            /**
             *
             * @author caroo
             */
            public class CA_Draft2023 {

                /**
                 * @param args the command line arguments
                 * @throws java.sql.SQLException
                 * @throws java.lang.ClassNotFoundException
                 * @throws java.lang.InstantiationException
                 * @throws java.lang.IllegalAccessException
                 */
                    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

                      Scanner system = new Scanner(System.in);

                        System.out.println("\"WELCOME TO YOUR REVENUE TAX CALCULATION!\n" +
                "CHOOSE AN OPTION:\n" +
                "1: LOGIN\n" +
                "2: SIGN UP");


            int optionNum = system.nextInt();

                        switch (optionNum) {
                            case 1:
                                login();
                                break;
                            case 2:
                                if (!userExists()) {
                                    newUser();
                                } else {
                                    System.out.println("User already exists in the database. Please choose a different username.");
                                }   break;
                            default:
                                System.out.println("Error!.");
                                break;
                        }
                    }


                    public static boolean login() {
                        
                        //***********Aqui precisamos validar o Login, e verificar se esta correto username e password *****************

                        IOUtils newUserInput = new IOUtils();

                       // boolean usertype;
                        String username;
                        String password;

                        Scanner UserInput = new Scanner(System.in);
    //                    System.out.println("User Type: ADMIN / REGULAR USER ");
    //                    usertype = UserInput.nextBoolean();

                        username = newUserInput.getUserText("Username: ");
                        password = newUserInput.getUserText("Password: ");
                        

                        return true;

                    }
                    
                    public static boolean userExists() {
                        DataBaseReaderDraft dbr = new DataBaseReaderDraft();
                        IOUtils newUserInput = new IOUtils();

                        String username = newUserInput.getUserText("Type your a username: ");

                        ArrayList<Users> usersList = dbr.getAllUsers();
                        for (Users user : usersList) {
                            if (user.getUsername().equals(username)) {
                                return true; // User already exists
                            }
                        }
                        return false; // User not founded
                    }

                        public static double newUser() throws SQLException {

                        Scanner UserInput = new Scanner(System.in);

                        String firstName;
                        String lastName;
                        String email;
                        String PPSN;
                        double grossIncome;
<<<<<<< HEAD
                        double taxCredit = 0.0;
=======
                      //  double taxCredit;
>>>>>>> b4c110b58a2c3f57524a6a9b8b8a235757747ef4
    //                    String usertype;
                        String username;
                        String password;


                        System.out.println("First Name: ");
                        firstName = UserInput.nextLine();


                        System.out.println("Last Name: ");
                        lastName = UserInput.nextLine();

                        System.out.println("Email: ");
                        email = UserInput.nextLine();

                        System.out.println("PPSN: ");
                        PPSN = UserInput.nextLine();

                        System.out.println("grossIncome: ");
                        grossIncome = UserInput.nextDouble();
                        UserInput.nextLine();
                        
<<<<<<< HEAD
                        System.out.println("Single or Married?");
                         double singlePersonCredit = 1775.0;
                         double marriedPersonCredit = 3550.0;
                         double employeeCredit = 1775.0;
                         
                         
                         
                         String userInputString =  UserInput.nextLine(); 
                                 
                         

                         
                         if( userInputString.equalsIgnoreCase("Single") ){
                             double totalTaxCredits = singlePersonCredit + employeeCredit;
                             System.out.println(totalTaxCredits);                             
                             
                         }else if (userInputString.equalsIgnoreCase("Married")){
                             double totalmarried = marriedPersonCredit + employeeCredit;
                             
                             System.out.println(totalmarried);
                         }else {
                             System.out.println("Error");
                         }
=======
>>>>>>> b4c110b58a2c3f57524a6a9b8b8a235757747ef4
        
        double prsi = TaxCalculatation.calculatePRSI(grossIncome);
        double usc = TaxCalculatation.calculateUSC(grossIncome);

        System.out.println("Single or Married? ");
        String maritalStatus = UserInput.nextLine();

        double taxCredit = 0;

        if (maritalStatus.equalsIgnoreCase("Single")) {
            taxCredit = TaxCalculatation.TaxCreditSingleYearly();
        } else if (maritalStatus.equalsIgnoreCase("Married")) {
            taxCredit = TaxCalculatation.TaxCreditMarriedYearly();
        } else {
            System.out.println("Invalid marital status input.");
        }

        System.out.println("PRSI: " + prsi);
        System.out.println("USC: " + usc);
        System.out.println("Tax Credits: " + taxCredit);

        UserInput.close();
    
                        

    //                    System.out.println("User Type: ADMIN / REGULAR USER ");
    //                    usertype = UserInput.nextLine();


                        System.out.println("New Username: ");
                        username = UserInput.nextLine();

                        System.out.println("Password: ");
                        password = UserInput.nextLine();

                        Admin_Craft adm = new Admin_Craft (0, firstName, lastName, email, PPSN, grossIncome, taxCredit, 0, username, password);
                        
 
                    
                        addToDatabase(adm);
                        return 0;
                        
                        }



                        public static void addToDatabase(Users newUser) throws SQLException {
                        DataBaseWriterDraft dbw = new DataBaseWriterDraft();
                        boolean success = dbw.newUser(newUser);

                        if (success) {
                            System.out.println("Sucess - New user add.");
                        } else {
                            System.out.println("Error.");
                        }
                    }
                        }





