import java.util.Scanner;

public class billing {

    public static void main(String[] args) {

        new PhoneList();

        // Printing the phone list
        PhoneList.displayPhoneInventory();

        // Ask the user to select a payment method
        Scanner scanner = new Scanner(System.in);

        // For printing the Billing Title
        System.out.println("BILLING" + "\n");

        while (true) {
            // For printing the Payment Method
            System.out.println("+--------------------------+");
            System.out.println("| 1 - Cash                 |");
            System.out.println("| 2 - Online Bank Transfer |");
            System.out.println("+--------------------------+" + "\n");;
            System.out.print("Select a payment method --> ");

            int paymentMethod = scanner.nextInt();

            // To check the payment method
            switch(paymentMethod)
            {
                case 1:
                    CashMethod();
                    break;

                case 2:
                    VirtualBank.main();
                    break;

                default:
                    System.out.print("Invalid Option. Please Select Again");
            }
        }
    }

    public static void CashMethod() {
        System.out.print("Welcome to Cash Method Payment");
    }
}