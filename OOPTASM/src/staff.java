import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class staff {

    public static void main(String[] args) {
        // Define the correct username and password
        String adminUsername = "admin";
        String adminPassword = "password123";

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the admin for their username
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        // Prompt the admin for their password
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the entered username and password match the correct credentials
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Access granted. Welcome to the admin main page!");
            // Add your admin main page code here, run everything inside here I guess, IDFK
        } else {
            System.out.println("Access denied. Incorrect username or password.");
        }

        // Close the scanner
        scanner.close();
    }

}
