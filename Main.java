package com.mycompany.messageapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageManager manager = new MessageManager();
        manager.loadTestData(); 
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.println("4. Stored Messages"); 
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "4": 
                    System.out.println("\n--- Stored Messages ---");
                    System.out.println("b. Longest: " + manager.getLongestMessage());
                    System.out.println("c. Search ID 0838884567: \n" + manager.searchByMessageID("0838884567"));
                    System.out.println("d. Search Recipient +27838884567: \n" + manager.searchByRecipient("+27838884567"));
                    System.out.println("f. Report:\n" + manager.displayReport());
                    break;
                case "3": 
                    running = false; 
                    System.out.println("Exiting..."); 
                    break;
                default: 
                    System.out.println("Option not implemented."); 
                    break;
            }
        }
        scanner.close();
    }
}