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
        System.out.println( "\u001B[34m           __                  __ \n" +
                            "          |__) | |  |  | |\\ | / __\n" +
                            "          |__) | |_ |_ | | \\| \\__/\u001B[0m\n");

        // For printing the Payment Method
        System.out.println("         +--------------------------+");
        System.out.println("         | 1 - Cash                 |");
        System.out.println("         | 2 - Online Bank Transfer |");
        System.out.println("         | 3 - Back                 |");
        System.out.println("         +--------------------------+" + "\n");

        int paymentMethod;

        do {
            System.out.print("\u001B[33m       Select a payment method --> \u001B[0m");
            paymentMethod = scanner.nextInt();

            switch (paymentMethod) {
                case 1:
                    CashMethod();
                    break;

                case 2:
                    VirtualBank.main();
                    break;

                case 3:
                    mainMenu.main(null);
                    break;

                default:
                    System.out.print("\n\u001B[31mInvalid Option. Please Select Again\u001B[0m\n\n");
            }
        } while (paymentMethod < 1 || paymentMethod > 3);
    }

    public static void CashMethod() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\u001B[32m          CASH PAYMENT METHOD\u001B[0m");
        System.out.println("          -------------------");
        System.out.print("\u001B[32m      The total price to be paid is RM \u001B[0m" + purchase.getTotal() + "\n");
        System.out.print("\n\n");

        while (true) {
            System.out.print("\u001B[33m          Enter the Payment --> RM \u001B[0m");
            double cashPayment = scanner.nextDouble();

            if (cashPayment < purchase.getTotal()) {

                System.out.print("\u001B[31m       Invalid Amount. Please Enter a amount that is more than \u001B[0m" + purchase.getTotal());
                System.out.print("\n");

            }

            else {

                double cashBalance = cashPayment - purchase.getTotal();

                System.out.println("\n\u001B[32m               Thank You !!!\u001B[0m");
                System.out.print("\u001B[32m         Your Balance Fund is RM \u001B[0m" + cashBalance);
                System.out.print("\n");
                purchase.deleteReceipt();

                break;

            }
        }


    }


}