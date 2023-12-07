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
                                System.out.println("User already exists in the database.");
                            }   break;
                        default:
                            System.out.println("Error!.");
                            break;
                    }
                }


                public static boolean userExists() {
                    DataBaseReaderDraft dbr = new DataBaseReaderDraft();
                    IOUtils newUserInput = new IOUtils();

                    String username = newUserInput.getUserText("Choose a username: ");

                    ArrayList<Users> usersList = dbr.getAllUsers();
                    for (Users user : usersList) {
                        if (user.getUsername().equals(username)) {
                            return true; // User already exists
                        }
                    }
                    return false; // User not founded
                }


                public static boolean login() {

                    IOUtils newUserInput = new IOUtils();

                    boolean usertype;
                    String username;
                    String password;

                    Scanner UserInput = new Scanner(System.in);
                    System.out.println("User Type: ADMIN / REGULAR USER ");
                    usertype = UserInput.nextBoolean();

                    username = newUserInput.getUserText("Choose a new username: ");
                    password = newUserInput.getUserText("Choose a password: ");

                    return true;

                }

                    public static void newUser() throws SQLException {

                    Scanner UserInput = new Scanner(System.in);

                    String firstName;
                    String lastName;
                    String email;
                    String PPSN;
                    double grossIncome;
                    double taxCredit;
                    String usertype;
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
                    
                    System.out.println("Tax Credit: ");
                    taxCredit = UserInput.nextDouble();

                    System.out.println("User Type: ADMIN / REGULAR USER ");
                    usertype = UserInput.nextLine();
             
                    
                    System.out.println("New Username: ");
                    username = UserInput.nextLine();
                    
                    System.out.println("Password: ");
                    password = UserInput.nextLine();

                    Users newUser = new Users (0, firstName, lastName, email, PPSN, grossIncome, taxCredit, 0, usertype, username, password);
                    addToDatabase(newUser);

                    }


                    public static void addToDatabase(Users newUser) throws SQLException {
                    DataBaseWriterDraft dbw = new DataBaseWriterDraft();
                    boolean success = dbw.newUser(newUser);

                    if (success) {
                        System.out.println("Novo usuário adicionado ao banco de dados com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar novo usuário ao banco de dados.");
                    }
                }
                    }





