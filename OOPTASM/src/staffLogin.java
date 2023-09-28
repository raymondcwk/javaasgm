import java.util.Scanner;

class person {
    private String username;
    private String password;

    public person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public void login() {
        System.out.println("Logging in as " + username);
    }

    public void showAccessDeniedMessage() {
        System.out.println("\u001B[31m\n               <<Access denied. Incorrect username or password!>>\u001B[0m\n");
    }
}

class Admin extends person {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login() {
        System.out.println("\u001B[32m\n              <<Access granted. Welcome to the admin main page!>>\u001B[0m\n");
        // Call the main menu function here
        mainMenu.main(null);
    }
}

public class staffLogin {

    public static void main(String[] args) {
        // Define the correct admin username and password
        String adminUsername = "admin";
        String adminPassword = "12345";

        // Create an Admin instance
        Admin admin = new Admin(adminUsername, adminPassword);

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Variable for attempts on login
        int maxAttempts = 3; // Maximum allowed login attempts
        int attempts = 0;    // Counter for login attempts

        while (true) {
            // Print logo
            System.out.println("\n\u001B[32m              /\\\\\\\\\\/\\\\    /\\\\\\             /\\\\\\          /\\\\\\\\\\/\\\\");
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
            // Prompt the user for their username
            System.out.print("                          \u001B[33mEnter your username: ");
            String username = scanner.nextLine();

            // Prompt the admin for their password
            System.out.print("                          Enter your password: \u001B[0m");
            String password = scanner.nextLine();

            // Authenticate the user
            if (admin.authenticate(username, password)) {
                admin.login(); // Successful login
                break;
            } else {
                admin.showAccessDeniedMessage();
                attempts++;
                if (attempts < maxAttempts) {
                    System.out.println("\u001B[34m                     You have " + (maxAttempts - attempts) + " login attempts left!\u001B[0m \n");
                } else {
                    System.out.println("\u001B[35m              Maximum login attempts reached. Exiting the program!\u001B[0m");
                    System.exit(0);
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}
