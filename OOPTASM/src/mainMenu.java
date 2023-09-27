import java.util.Scanner;

public class mainMenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\u001B[36m          |\\  /|   /\\   | |\\  |   |\\  /| |--- |\\  | |    |");
            System.out.println("          | \\/ |  /__\\  | | \\ |   | \\/ | |--  | \\ | |    |");
            System.out.println("          |    | /    \\ | |  \\|   |    | |--- |  \\|  \\__/ \u001B[0m\n");
            System.out.println("            +------------------------------------------+");
            System.out.println("            | Selection |   Function                   |");
            System.out.println("            +------------------------------------------+");
            System.out.println("            |     1     |   Purchase                   |");
            System.out.println("            |     2     |   Billing                    |");
            System.out.println("            |     3     |   Report                     |");
            System.out.println("            |     4     |   Exit                       |");
            System.out.println("            +------------------------------------------+\n");
            System.out.print("\u001B[33m                     Enter your choice: \u001B[0m");

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
                    System.out.println("Thanks for using :)");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
