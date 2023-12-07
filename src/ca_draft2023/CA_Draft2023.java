/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_draft2023;

import java.util.Scanner;

/**
 *
 * @author caroo
 */
public class CA_Draft2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
       int optionNum = system();

        if (optionNum == 1) {
            login();
        } else if (optionNum == 2) {
            register();
        } else {
            System.out.println("Opção inválida.");
        }
    }
   
    
    
    public static int system() {
        
      Scanner userInput = new Scanner(System.in);
    
      System.out.println("WELCOME TO YOUR REVENUE TAX CALCULATION! "
               + "CHOOSE AN OPTION: "
               + "1: LOGIN "
               + "2: SIGN UP");
      
      return userInput.nextInt();


   }
    
    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();
        
   
        
    }
    
        public static void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o novo nome de usuário: ");
        String newUsername = scanner.nextLine();

        System.out.print("Digite a nova senha: ");
        String newPassword = scanner.nextLine();

        }
}
    
    
    

