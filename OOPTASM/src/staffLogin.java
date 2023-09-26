import java.util.Scanner;

public class staffLogin {

    public static void main(String[] args) {

        // Define the correct username and password
        String adminUsername = "admin";
        String adminPassword = "12345";

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
                mainMenu.main();
            } else {
                System.out.println("Access denied. Incorrect username or password.");
            }
        }

        // Close the scanner
        scanner.close();

    }
}
