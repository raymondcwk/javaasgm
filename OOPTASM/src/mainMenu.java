import java.util.Scanner;

public class mainMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("+=====================+");
            System.out.println("|      Main Menu      |");
            System.out.println("+=====================+");
            System.out.println("|1. Phone List        |");
            System.out.println("|2. Billing           |");
            System.out.println("|3. Stock             |");
            System.out.println("|4. Exit              |");
            System.out.println("+=====================+");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected 'Phone List'.");
                    // Add your purchase code here
                    purchaseMenu.main(null);
                    break;
                case 2:
                    System.out.println("You selected 'Billing'.");
                    // Add your billing code here
                    billing.main(null);
                    break;
                case 3:
                    System.out.println("You selected 'Stock'.");
                    // Add your stock code here
                    Stock.main(null);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
