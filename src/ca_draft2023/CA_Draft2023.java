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
                                    
                                    Users currentUser = login();
                                    
                                    if (currentUser != null){
                                        System.out.println("Welcome " + currentUser.getUsername() + "!");
                                        
                                    currentUser.executeUserOptions();
                                   if (currentUser.isAdmin()) {
                    Admin_Craft adminUser = (Admin_Craft) currentUser;
                    System.out.println("Admin Menu:");
                    System.out.println("1: Modify Own Profile");
                    System.out.println("2: Access User List");
                    System.out.println("3: Other Admin Option"); // Adicione outras opções, se necessário
                    System.out.println("0: Logout");

                    }else {
                    System.out.println("Regular Menu:");
                    System.out.println("1: Modify Own Profile");
                    System.out.println("2: Access User List");
                    System.out.println("3: Other Admin Option"); // Adicione outras opções, se necessário
                    System.out.println("0: Logout");
                    
                }
                                    
                                    }
                                    break;
                                case 2:
                                    if (!userExists()) {
                                        if (newUser() == 0){
                                    } else {
                        System.out.println("Error creating user.");
                    }
                } else {
                    System.out.println("User already exists in the database. Please choose a different username.");
                }
                                    break;
                                default:
                                    System.out.println("Error!.");
                                    break;
                            }
                        }


                        public static Users login() {



                           Scanner loginInput = new Scanner(System.in);

                          

                           String username;
                           String password;
                            
                            
                           System.out.println("Username: ");
                           username = loginInput.nextLine();
                            
                           System.out.println("Password: ");
                           password = loginInput.nextLine();
                            
                           DataBaseReaderDraft dbr = new DataBaseReaderDraft();
        ArrayList<Users> usersList = dbr.getAllUsers();


        for (Users user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Login successful
            }
        }
        return null; // Invalid username or password
                        }
                        
        
        
        
     

                        public static boolean userExists() {
                            DataBaseReaderDraft dbr = new DataBaseReaderDraft();
                            IOUtils newUserInput = new IOUtils();

                            String username = newUserInput.getUserText("Choose a username: ");
//                            String password = newUserInput.getUserText("Choose a password: ");

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


                            System.out.println("Single or Married?");
                             double singlePersonCredit = 1775.0;
                             double marriedPersonCredit = 3550.0;
                             double employeeCredit = 1775.0;


                             
                             String userInputString =  UserInput.nextLine(); 
                             double taxCredit = 0.0;

                             if( userInputString.equalsIgnoreCase("Single") ){
                                 taxCredit = singlePersonCredit + employeeCredit;
                                                              

                             }else if (userInputString.equalsIgnoreCase("Married")){
                              taxCredit = marriedPersonCredit + employeeCredit;

                             }else {
                                 System.out.println("Error");
                             }

        double prsi = TaxCalculatation.calculatePRSI(grossIncome);
        double usc = TaxCalculatation.calculateUSC(grossIncome);
        double taxOwed = prsi + usc;



        System.out.println("To proceed with the registration, please enter your chosen USERNAME again: ");
        username = UserInput.nextLine();

        System.out.println("Please, enter your PASSWORD: ");
        password = UserInput.nextLine();

        Admin_Craft adm = new Admin_Craft (0, firstName, lastName, email, PPSN, grossIncome, taxCredit, taxOwed , username, password);


        try {
            addToDatabase(adm);
        } catch (SQLException e) {
            e.printStackTrace();
                            }
                            return 0;
                     }
           
                
                            
    
    public static void addToDatabase(Admin_Craft newUser) throws SQLException {
                            DataBaseWriterDraft dbw = new DataBaseWriterDraft();
                            boolean success = dbw.newUser(newUser);

                            if (success) {
                                System.out.println("Sucess - New user add.");
                            } else {
                                System.out.println("Error.");
                            }
    }
    
    
                }
                

//***************Codigo para verificar se a database foi criada*************************************

//            public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
//                    if (DatabaseSetupDraft.setupDB()){
//           System.out.println("Database and table created");
//            
//        }else {
//            System.out.println("Oh no! There was a database creation problem...");
//       }
//                    }
//                }
//                

                
                




