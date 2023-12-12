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

                        public static void newUser() throws SQLException {

                        Scanner UserInput = new Scanner(System.in);

                        String firstName;
                        String lastName;
                        String email;
                        String PPSN;
                        double grossIncome;
                        double taxCredit;
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

                        System.out.println("Tax Credit: ");
                        taxCredit = UserInput.nextDouble();
                        UserInput.nextLine();

    //                    System.out.println("User Type: ADMIN / REGULAR USER ");
    //                    usertype = UserInput.nextLine();


                        System.out.println("New Username: ");
                        username = UserInput.nextLine();

                        System.out.println("Password: ");
                        password = UserInput.nextLine();

                        Admin_Craft adm = new Admin_Craft (0, firstName, lastName, email, PPSN, grossIncome, taxCredit, 0, username, password);
                        
 
                    
                        addToDatabase(adm);
                        
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





