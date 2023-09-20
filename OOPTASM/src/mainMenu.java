import java.util.Scanner;

public class mainMenu {

    public static void main() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Purchase");
            System.out.println("2. Billing");
            System.out.println("3. Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected 'Purchase'.");
                    // Add your purchase code here
                    purchase.purchase();
                    break;
                case 2:
                    System.out.println("You selected 'Billing'.");
                    // Add your billing code here
                    break;
                case 3:
                    System.out.println("You selected 'Stock'.");
                    // Add your stock code here
                    itemList.main();
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
