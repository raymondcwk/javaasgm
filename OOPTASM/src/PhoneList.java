import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneList {
    private final List<Phone> phoneList = new ArrayList<>();

    public void addPhone(Phone phone) {
        phoneList.add(phone);
        System.out.println("Phone added successfully.");
    }

    public void deletePhone(Scanner scanner) {
        System.out.print("Enter model index to delete: ");
        int modelIndex = scanner.nextInt();

        if (modelIndex >= 0 && modelIndex < phoneList.size()) {
            Phone deletedPhone = phoneList.remove(modelIndex);
            System.out.println("Phone deleted successfully:");
            displayPhone(deletedPhone);
        } else {
            System.out.println("Invalid model index.");
        }
    }

    public void updatePhone(Scanner scanner) {
        System.out.print("Enter model index to update: ");
        int modelIndex = scanner.nextInt();

        if (modelIndex >= 0 && modelIndex < phoneList.size()) {
            Phone phoneToUpdate = phoneList.get(modelIndex);

            System.out.print("Enter new model: ");
            String newModel = scanner.next();
            System.out.print("Enter new price: ");
            String newPrice = scanner.next();
            System.out.print("Enter new quantity: ");
            String newQuantity = scanner.next();

            phoneToUpdate.setModel(newModel);
            phoneToUpdate.setPrice(newPrice);
            phoneToUpdate.setQuantity(newQuantity);

            System.out.println("Phone updated successfully:");
            displayPhone(phoneToUpdate);
        } else {
            System.out.println("Invalid model index.");
        }
    }

    public void displayPhoneInventory() {
        if (phoneList.isEmpty()) {
            System.out.println("Phone inventory is empty.");
        } else {
            System.out.println("Phone Inventory:");
            System.out.printf("%-20s %-20s %-20s%n", "Model", "Price", "Quantity");
            for (int i = 0; i < phoneList.size(); i++) {
                displayPhone(phoneList.get(i));
                System.out.println();
            }
        }
    }

    public void displayPhone(Phone phone) {
       System.out.printf("%-20s %-20s %-20s%n", phone.getModel(), phone.getPrice(), phone.getQuantity());
    }
}
