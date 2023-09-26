import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneList {
    private static final List<Phone> phoneList = new ArrayList<>();
    public PhoneList() {
        Phone phone1 = new Phone("iPhone X", 999, 10);
        Phone phone2 = new Phone("Samsung Galaxy S21", 899, 8);
        Phone phone3 = new Phone("Google Pixel 6", 799, 12);

        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);
    }

    public void addPhone(Phone phone) {
        phoneList.add(phone);
        System.out.println("Phone added successfully.");
    }

    public void deletePhone(Scanner scanner) {
        System.out.print("Enter model to delete: ");
        String modelToDelete = scanner.next();

        boolean found = false;

        for (int i = 0; i < phoneList.size(); i++) {
            Phone phone = phoneList.get(i);

            if (phone.getModel().equals(modelToDelete)) {
                phoneList.remove(i);
                System.out.println("Phone with model '" + modelToDelete + "' deleted successfully.");
                found = true;
                break; // Exit the loop once the phone is found and deleted
            }
        }

        if (!found) {
            System.out.println("Phone with model '" + modelToDelete + "' not found.");
        }
    }

    public void updatePhone(Scanner scanner) {
        System.out.print("Enter model to update: ");
        String modelToUpdate = scanner.next();

        boolean found = false;

        for (Phone phone : phoneList) {
            if (phone.getModel().equals(modelToUpdate)) {
                System.out.print("Enter new model: ");
                String newModel = scanner.next();
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();

                phone.setModel(newModel);
                phone.setPrice(newPrice);
                phone.setQuantity(newQuantity);

                System.out.println("Phone with model '" + modelToUpdate + "' updated successfully.");
                found = true;
                break; // Exit the loop once the phone is found and updated
            }
        }

        if (!found) {
            System.out.println("Phone with model '" + modelToUpdate + "' not found.");
        }
    }

    public static void displayPhoneInventory() {
        if (phoneList.isEmpty()) {
            System.out.println("Phone inventory is empty.");
        } else {
            System.out.println("Phone Inventory:");
            System.out.printf("%-5s %-20s %-20s %-20s%n", "Item", "Model", "Price(RM)", "Quantity");
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
        System.out.printf("%-5d %-20s %-20s %-20s%n", itemNumber, phone.getModel(), phone.getPrice(), phone.getQuantity());
    }
    public int size() {
        return phoneList.size();
    }
}
