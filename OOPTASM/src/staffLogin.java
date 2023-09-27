import java.util.Scanner;

public class staffLogin {

    public static void main(String[] args) {

        // Define the correct username and password
        String adminUsername = "admin";
        String adminPassword = "12345";

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // ANSI escape code for setting text color to black
        String blackColor = "\u001B[30m";
        // ANSI escape code for setting text color to red
        String redColor = "\u001B[31m";
        // ANSI escape code for setting text color to green
        String greenColor = "\u001B[32m";
        // ANSI escape code for setting text color to yellow
        String yellowColor = "\u001B[33m";
        // ANSI escape code for setting text color to blue
        String blueColor = "\u001B[34m";
        // ANSI escape code for setting text color to magenta
        String magentaColor = "\u001B[35m";
        // ANSI escape code for setting text color to cyan
        String cyanColor = "\u001B[36m";
        // ANSI escape code for setting text color to white
        String whiteColor = "\u001B[37m";
        // ANSI escape code for resetting text color to default
        String resetColor = "\u001B[0m";

        boolean loggedIn = false; // Flag to track login status

        while (!loggedIn) {
            // Print logo
            System.out.println("\u001B[32m              /\\\\\\\\\\/\\\\    /\\\\\\             /\\\\\\          /\\\\\\\\\\/\\\\");
            System.out.println("         /\\\\\\\\\\/    \\///// \\/\\\\\\            \\/\\\\\\    /\\\\\\\\\\/    \\/////");
            System.out.println("        /\\\\\\/               \\/\\\\\\            \\/\\\\\\  /\\\\\\/ ");
            System.out.println("        \\///\\\\               \\/\\\\\\            \\/\\\\\\ \\///\\\\");
            System.out.println("         \\/\\/\\\\\\\\\\\\\\\\         \\/\\\\\\            \\/\\\\\\ \\/\\/\\\\\\\\\\\\\\\\");
            System.out.println("            \\/\\\\\\\\\\\\\\\\\\\\\\      \\/\\\\\\            \\/\\\\\\   \\/\\\\\\\\\\\\\\\\\\\\\\\\ ");
            System.out.println("                  \\\\\\\\\\\\\\\\\\\\/\\  \\/\\\\\\            \\/\\\\\\         \\\\\\\\\\\\\\\\\\/\\ ");
            System.out.println("           /\\\\\\\\      \\\\\\\\\\\\\\/\\  \\/\\\\\\            \\/\\\\\\  /\\\\\\\\      \\\\\\\\\\/\\");
            System.out.println("           \\/\\\\\\\\\\      \\\\\\\\\\\\/   \\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\/\\\\\\ \\/\\\\\\\\\\\\     \\\\\\\\/");
            System.out.println("            \\/////////////////     \\////////////////\\///  \\/////////////// \u001B[0m");
            System.out.println("  ");
            System.out.println("                        \u001B[31m!ONLY FOR AUTHORIZED USER ONLY! \u001B[0m");
            System.out.println("  ");
            // Prompt the admin for their username
            System.out.print("                          \u001B[33mEnter your username: ");
            String username = scanner.nextLine();

            // Prompt the admin for their password
            System.out.print("                          Enter your password: \u001B[0m");
            String password = scanner.nextLine();

            // Check if the entered username and password match the correct credentials
            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                loggedIn = true; // Set the flag to true for successful login
                System.out.println("\u001B[32m\n              <<Access granted. Welcome to the admin main page!>>\u001B[0m\n");
                // Call the main menu function here
                mainMenu.main(null);
            } else {
                System.out.println("\u001B[31m\n               <<Access denied. Incorrect username or password!>>\u001B[0m\n");
            }
        }

        // Close the scanner
        scanner.close();

    }
}
