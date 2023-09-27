import java.util.Scanner;

public class VirtualBank {
    public static void main() {

        Scanner scanner = new Scanner(System.in);

        // Define the bank account
        String BankAcc = "123456789";
        String BankPin = "0000";
        double BankFund = 1_000_000.00;

        // Display the menu
        System.out.println("VIRTUAL BANK SYSTEM");
        System.out.println("-------------------");
        System.out.println("1 - Bank");
        System.out.println("2 - Exit");
        System.out.println("-------------------");
        System.out.print("Enter choice --> ");
        String BankChoice = scanner.nextLine();

        while (!BankChoice.equals("2")) {

            if (BankChoice.equals("1")) {
                // Ask user to enter bank account number
                System.out.print("Enter Bank Account --> ");
                String inputBankAcc = scanner.nextLine();

                // Check if the input matches the defined bank account
                while (!inputBankAcc.equals(BankAcc)) {
                    System.out.println("Invalid account number...");
                    System.out.print("Enter Bank Account --> ");
                    inputBankAcc = scanner.nextLine();
                }

                // Ask user to enter PIN
                System.out.print("Enter PIN --> ");
                String inputPIN = scanner.nextLine();

                // Validation
                while (!inputPIN.equals(BankPin)) {
                    System.out.println("Invalid PIN...");
                    System.out.print("Enter PIN --> ");
                    inputPIN = scanner.nextLine();
                }

                // PIN is correct, display the receipt and ask for payment
                purchase.printReceipt(purchase.total);

                System.out.print("The total price to be paid is " + purchase.total);

            }

            else {
                System.out.println("Invalid option. Please enter a valid choice.");
            }

            // Display the menu again
            System.out.println("VIRTUAL BANK SYSTEM");
            System.out.println("-------------------");
            System.out.println("1 - Bank");
            System.out.println("2 - Exit");
            System.out.println("-------------------");
            System.out.print("Enter choice --> ");
            BankChoice = scanner.nextLine();
        }

        // End the program
        System.out.println("Thank you for using the Virtual Bank System!");

    }
}