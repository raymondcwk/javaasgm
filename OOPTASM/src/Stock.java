import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        PhoneList phoneList = new PhoneList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            phoneList.displayPhoneInventory();
            System.out.println( "\u001B[34m                Phone Inventory Management\u001B[0m\n");
            System.out.println("       +------------------------------------------+");
            System.out.println("       | Selection |   Function                   |");
            System.out.println("       +------------------------------------------+");
            System.out.println("       |     1     |   Add Phone                  |");
            System.out.println("       |     2     |   Delete Phone               |");
            System.out.println("       |     3     |   Update Phone               |");
            System.out.println("       |     4     |   Back                       |");
            System.out.println("       +------------------------------------------+\n");
            System.out.print("\u001B[33m               Enter your choice: \u001B[0m");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPhone(phoneList, scanner);
                    break;
                case 2:
                    phoneList.deletePhone(scanner);
                    break;
                case 3:
                    phoneList.updatePhone(scanner);
                    break;
                case 4:
                    mainMenu.main(null);
                default:
                    System.out.println("\u001B[31m               Invalid choice. Please select a valid operation!\u001B[0m");
            }
        }
    }

    private static void addPhone(PhoneList phoneList, Scanner scanner) {
        scanner.nextLine(); // Consume the newline character from the previous input

        System.out.print("\n\u001B[33m               Enter model   : \u001B[0m");
        String model = scanner.nextLine(); // Read the model with spaces

        double price = 0.0; // Initialize price as a double
        int quantity = 0;  // Initialize quantity as an int

        // Handling price input as a double
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("\u001B[33m               Enter price   : \u001B[0m");
            String priceStr = scanner.next();
            try {
                price = Double.parseDouble(priceStr);
                validPrice = true; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("\n\u001B[31m               Invalid price. Please enter a valid numeric value!\u001B[0m");
            }
        }

        // Handling quantity input as an int
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("\u001B[33m               Enter quantity: \u001B[0m");
            String quantityStr = scanner.next();
            try {
                quantity = Integer.parseInt(quantityStr);
                validQuantity = true; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("\n\u001B[31m               Invalid quantity. Please enter a valid numeric value!\u001B[0m");
            }
        }

        Phone newPhone = new Phone(model, price, quantity);
        phoneList.addPhone(newPhone);
    }
}
