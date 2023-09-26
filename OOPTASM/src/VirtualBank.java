import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualBank {
    public static void main() {
        // Define the accounts and their balances
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("1", 1000.0);
        accounts.put("2", 2000.0);
        accounts.put("3", 3000.0);

        // Define the scanner object
        Scanner scanner = new Scanner(System.in);

        // Loop until the user chooses to exit
        while (true) {
            // Print the menu
            System.out.println("Virtual Banking System");
            System.out.println("1. Check balance");
            System.out.println("2. Transfer money");
            System.out.println("3. Exit");

            // Ask the user to select an option
            System.out.print("Enter your selection: ");
            String selection = scanner.nextLine();

            // Process the user's selection
            switch (selection) {

                case "1":
                    // Check the balance of the selected account
                    System.out.print("Enter the account number: ");
                    String accountNumber = scanner.nextLine();

                    if (accounts.containsKey(accountNumber)) {
                        System.out.println("Balance: $" + accounts.get(accountNumber));
                    }

                    else {
                        System.out.println("Account not found");
                    }

                    break;

                case "2":
                    // Transfer money from one account to another
                    System.out.print("Enter the account number to transfer from: ");
                    String fromAccountNumber = scanner.nextLine();

                    System.out.print("Enter the account number to transfer to: ");
                    String toAccountNumber = scanner.nextLine();

                    System.out.print("Enter the amount to transfer: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {

                        double fromBalance = accounts.get(fromAccountNumber);
                        double toBalance = accounts.get(toAccountNumber);

                        if (fromBalance >= amount) {

                            fromBalance -= amount;
                            toBalance += amount;
                            accounts.put(fromAccountNumber, fromBalance);
                            accounts.put(toAccountNumber, toBalance);
                            System.out.println("Transfer successful");
                        }

                        else {
                            System.out.println("Insufficient funds");
                        }

                    }

                    else {
                        System.out.println("Account not found");
                    }

                    break;

                case "3":
                    // Exit the program
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    // Invalid selection
                    System.out.println("Invalid selection");
            }
        }
    }
}
