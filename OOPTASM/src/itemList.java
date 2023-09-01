
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class itemList {
    public static void main(String[] args) {
        List<List<String>> phoneList = new ArrayList<>();
        phoneList.add(null); // Add a null element at index 0 to skip it.

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Add Phone");
            System.out.println("2. Delete Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Display Phone Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Phone
                    addPhone(phoneList, scanner);
                    break;
                case 2:
                    // Delete Phone
                    deletePhone(phoneList, scanner);
                    break;
                case 3:
                    // Update Phone
                    updatePhone(phoneList, scanner);
                    break;
                case 4:
                    // Display Phone Inventory
                    displayPhoneInventory(phoneList);
                    break;
                case 5:
                    // Exit the program
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        }
    }

    public static void addPhone(List<List<String>> phoneList, Scanner scanner) {
        List<String> phoneInfo = new ArrayList<>();

        System.out.print("Enter model: ");
        String model = scanner.next();
        System.out.print("Enter price: ");
        String price = scanner.next();
        System.out.print("Enter quantity: ");
        String quantity = scanner.next();

        phoneInfo.add(model);
        phoneInfo.add(price);
        phoneInfo.add(quantity);

        phoneList.add(phoneInfo);
        System.out.println("Phone added successfully.");
    }

    public static void deletePhone(List<List<String>> phoneList, Scanner scanner) {
        System.out.print("Enter model index: ");
        int modelIndex = scanner.nextInt();

        if (modelIndex >= 1 && modelIndex < phoneList.size()) {
            phoneList.remove(modelIndex);
            System.out.println("Phone deleted successfully.");
        } else {
            System.out.println("Invalid model index.");
        }
    }

    public static void updatePhone(List<List<String>> phoneList, Scanner scanner) {
        System.out.print("Enter model index: ");
        int modelIndex = scanner.nextInt();

        if (modelIndex >= 1 && modelIndex < phoneList.size()) {
            List<String> phoneInfo = phoneList.get(modelIndex);

            System.out.print("Enter new model: ");
            String newModel = scanner.next();
            System.out.print("Enter new price: ");
            String newPrice = scanner.next();
            System.out.print("Enter new quantity: ");
            String newQuantity = scanner.next();

            phoneInfo.set(0, newModel);
            phoneInfo.set(1, newPrice);
            phoneInfo.set(2, newQuantity);

            System.out.println("Phone updated successfully.");
        } else {
            System.out.println("Invalid model index.");
        }
    }

    public static void displayPhoneInventory(List<List<String>> phoneList) {
        System.out.println("Phone Inventory:");
        for (int i = 1; i < phoneList.size(); i++) {
            List<String> phoneInfo = phoneList.get(i);
            System.out.println("Model: " + phoneInfo.get(0));
            System.out.println("Price: " + phoneInfo.get(1));
            System.out.println("Quantity: " + phoneInfo.get(2));
            System.out.println();
        }
    }
}
