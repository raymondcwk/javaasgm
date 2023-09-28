import java.util.Scanner;

public class VirtualBank {
    public static void main() {

        Scanner scanner = new Scanner(System.in);

        purchase Purchase = new purchase();

        // Define the bank account
        String BankAcc = "123456789";
        String BankPin = "0000";
        double BankFund = 1_000_000.00;

        // Display the menu
        System.out.println("\u001B[36m          VIRTUAL BANK SYSTEM\u001B[0m");
        System.out.println("       +----------------------------------+");
        System.out.println("       | Selection |   Payment            |");
        System.out.println("       +----------------------------------+");
        System.out.println("       |     1     |   Bank               |");
        System.out.println("       |     2     |   Exit               |");
        System.out.println("       +----------------------------------+\n");
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

                System.out.print("\n\n");

                System.out.print("The total price to be paid is RM" + purchase.getTotal() + "\n");

                System.out.print("Are you sure you want to proceed this payment? (Y/N) --> ");
                String paymentProceed = scanner.nextLine();

                if (paymentProceed.equalsIgnoreCase("Y")) {

                    // Calculate the balance bank fund
                    BankFund = BankFund - purchase.getTotal();

                    System.out.print("\n");
                    System.out.println("Thank You For Choosing our Bank !!!");
                    System.out.print("Your Bank Balance Fund is RM" + BankFund);
                    purchase.deleteReceipt();
                    System.out.print("\n\n");
                }

                else {

                    billing.main(null);

                }
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

        mainMenu.main(null);

    }
}