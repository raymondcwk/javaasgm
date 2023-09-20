import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class staff {

    public static void main(String[] args) {
        // Define the correct username and password
        String adminUsername = "admin";
        String adminPassword = "password123";

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false; // Flag to track login status

        while (!loggedIn) {
            // Prompt the admin for their username
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // Prompt the admin for their password
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // Check if the entered username and password match the correct credentials
            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                loggedIn = true; // Set the flag to true for successful login
                System.out.println("Access granted. Welcome to the admin main page!");
                // Call the main menu function here
                displayMainMenu();
            } else {
                System.out.println("Access denied. Incorrect username or password.");
            }
        }

        // Close the scanner
        scanner.close();
    }

    // Function to display the main menu
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Purchase");
            System.out.println("2. Billing");
            System.out.println("3. Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected 'Purchase'.");
                    // Add your purchase code here
                    purchase.purchase();
                    break;
                case 2:
                    System.out.println("You selected 'Billing'.");
                    // Add your billing code here
                    break;
                case 3:
                    System.out.println("You selected 'Stock'.");
                    // Add your stock code here
                    itemList.main();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

