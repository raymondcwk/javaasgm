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

        // For printing the Payment Method
        System.out.println("+--------------------------+");
        System.out.println("| 1 - Cash                 |");
        System.out.println("| 2 - Online Bank Transfer |");
        System.out.println("+--------------------------+" + "\n");;
        System.out.println("Select a payment method --> ");

        int paymentMethod = scanner.nextInt();

        // To check the payment method


    }
}