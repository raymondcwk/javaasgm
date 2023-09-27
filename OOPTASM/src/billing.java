import java.util.Scanner;

public class billing {

    public static void main(String[] args) {

        // Ask the user to select a payment method
        Scanner scanner = new Scanner(System.in);

        // Print the receipt
        purchase.printReceipt(purchase.total);

        // For printing new line
        System.out.print("\n");

        // For printing the Billing Title
        System.out.println("BILLING" + "\n");

        // For printing the Payment Method
        System.out.println("+--------------------------+");
        System.out.println("| 1 - Cash                 |");
        System.out.println("| 2 - Online Bank Transfer |");
        System.out.println("+--------------------------+" + "\n");;
        System.out.print("Select a payment method --> ");

        int paymentMethod = scanner.nextInt();

        while (paymentMethod == 1 || paymentMethod == 2) {

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

            // For printing the Payment Method
            System.out.println("+--------------------------+");
            System.out.println("| 1 - Cash                 |");
            System.out.println("| 2 - Online Bank Transfer |");
            System.out.println("| 3 - Exit                 |");
            System.out.println("+--------------------------+" + "\n");;
            System.out.print("Select a payment method --> ");

            paymentMethod = scanner.nextInt();

        }
    }

    public static void CashMethod() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("CASH PAYMENT METHOD");
        System.out.println("-------------------");
        System.out.print("The total price to be paid is RM" + purchase.getTotal() + "\n");
        System.out.print("\n\n");

        while (true) {
            System.out.print("Enter the Payment --> RM ");
            double cashPayment = scanner.nextDouble();

            if (cashPayment < purchase.getTotal()) {

                System.out.print("Invalid Amount. Please Enter a amount that is more than " + purchase.getTotal());
                System.out.print("\n");

            }

            else {

                double cashBalance = cashPayment - purchase.getTotal();

                System.out.println("Thank You !!!");
                System.out.print("Your Balance Fund is RM" + cashBalance);
                System.out.print("\n");

                break;

            }
        }


    }
}