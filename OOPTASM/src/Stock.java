import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        PhoneList phoneList = new PhoneList();
        Scanner scanner = new Scanner(System.in);





        while (true) {
            phoneList.displayPhoneInventory();
            System.out.println("Phone Inventory Management:");
            System.out.println("1. Add Phone");
            System.out.println("2. Delete Phone");
            System.out.println("3. Update Phone");

            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
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
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        }
    }

    private static void addPhone(PhoneList phoneList, Scanner scanner) {
        System.out.print("Enter model: ");
        String model = scanner.next();

        double price = 0.0; // Initialize price as a double
        int quantity = 0;  // Initialize quantity as an int

        // Handling price input as a double
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Enter price: ");
            String priceStr = scanner.next();
            try {
                price = Double.parseDouble(priceStr);
                validPrice = true; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid numeric value.");
            }
        }

        // Handling quantity input as an int
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.print("Enter quantity: ");
            String quantityStr = scanner.next();
            try {
                quantity = Integer.parseInt(quantityStr);
                validQuantity = true; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a valid numeric value.");
            }
        }

        Phone newPhone = new Phone(model, price, quantity);
        phoneList.addPhone(newPhone);
    }
}
