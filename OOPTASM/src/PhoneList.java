import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneList {
    private static final List<Phone> phoneList = new ArrayList<>();
    private static final List<Phone> addedItems = new ArrayList<>(); // Maintain a list of added items
    public PhoneList() {
        if (phoneList.isEmpty()) {
            Phone phone1 = new Phone("iPhone X", 999, 10);
            Phone phone2 = new Phone("Samsung Galaxy S21", 899, 8);
            Phone phone3 = new Phone("Google Pixel 6", 799, 12);

            phoneList.add(phone1);
            phoneList.add(phone2);
            phoneList.add(phone3);

            // Add these items to the addedItems list to mark them as added
            addedItems.addAll(phoneList);
        }
    }


    public void addPhone(Phone phone) {
        if (!addedItems.contains(phone)) { // Check if the phone is not already added
            phoneList.add(phone);
            addedItems.add(phone); // Add the phone to the added items list
            System.out.println("\n\u001B[32m               Phone added successfully!\u001B[0m");
        } else {
            System.out.println("\n\u001B[31m               Phone is already added!\u001B[0m");
        }
    }

    public void deletePhone(Scanner scanner) {
        scanner.nextLine();

        System.out.print("\u001B[33m             Enter model to delete: \u001B[0m");
        String modelToDelete = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < phoneList.size(); i++) {
            Phone phone = phoneList.get(i);

            if (phone.getModel().equals(modelToDelete)) {
                phoneList.remove(i);
                System.out.println("\u001B[32m          Phone with model '" + modelToDelete + "' deleted successfully!\u001B[0m");
                found = true;
                break; // Exit the loop once the phone is found and deleted
            }
        }

        if (!found) {
            System.out.println("\u001B[31m            Phone with model '" + modelToDelete + "' not found!\u001B[0m");
        }
    }

    public void updatePhone(Scanner scanner) {
        scanner.nextLine();

        System.out.print("\u001B[33m               Enter model to update: \u001B[0m");
        String modelToUpdate = scanner.nextLine();

        boolean found = false;

        for (Phone phone : phoneList) {
            if (phone.getModel().equals(modelToUpdate)) {
                System.out.print("\u001B[33m               Enter new model   : \u001B[0m");
                String newModel = scanner.nextLine();
                System.out.print("\u001B[33m               Enter new price   : \u001B[0m");
                double newPrice = scanner.nextDouble();
                System.out.print("\u001B[33m               Enter new quantity: \u001B[0m");
                int newQuantity = scanner.nextInt();

                phone.setModel(newModel);
                phone.setPrice(newPrice);
                phone.setQuantity(newQuantity);

                System.out.println("\u001B[32m               Phone with model '" + modelToUpdate + "' updated successfully!\u001B[0m");
                found = true;
                break; // Exit the loop once the phone is found and updated
            }
        }

        if (!found) {
            System.out.println("\u001B[31m               Phone with model '" + modelToUpdate + "' not found!\u001B[0m");
        }
    }

    public static void displayPhoneInventory() {
        if (phoneList.isEmpty()) {
            System.out.println("\n\u001B[31m          Phone inventory is empty!\u001B[0m\n");
        } else {
            System.out.println("\n\u001B[35m                               Phone Inventory\u001B[0m\n");
            System.out.println("        ______________________________________________________________________________");
            System.out.printf("        | %-5s | %-20s | %-20s | %-20s |%n", "Item", "Model", "Price(RM)", "Quantity");
            System.out.println("        ______________________________________________________________________________");
            for (int i = 0; i < phoneList.size(); i++) {
                // Increment the item number by 1 (starting from 1)
                int itemNumber = i + 1;
                displayPhone(phoneList.get(i), itemNumber);
                System.out.println();
            }
        }
    }

    public Phone get(int index) {
        if (index >= 0 && index < phoneList.size()) {
            return phoneList.get(index);
        } else {
            return null; // Return null if the index is out of bounds
        }
    }

    public static void displayPhone(Phone phone, int itemNumber) {
        System.out.printf("        | %-5d | %-20s | %-20s | %-20s |", itemNumber, phone.getModel(), phone.getPrice(), phone.getQuantity());
        System.out.println("\n        ______________________________________________________________________________");
    }
    public int size() {
        return phoneList.size();
    }
}
