import java.util.Scanner;

public class purchaseMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneList phoneList = new PhoneList(); // Create a PhoneList object here
        purchase purchase = new purchase();

        while (true) {
            System.out.println( "\u001B[32m         __         __   __             __   __\n" +
                                "        |__) |   | |__) /   |__|  /_\\  /__  |__\n" +
                                "        |     \\_/  | \\  \\__ |  | /   \\ __/  |__\u001B[0m\n");
            System.out.println("       +------------------------------------------+");
            System.out.println("       | Selection |   Function                   |");
            System.out.println("       +------------------------------------------+");
            System.out.println("       |     1     |   Add Phone to Cart          |");
            System.out.println("       |     2     |   Remove Phone from Cart     |");
            System.out.println("       |     3     |   Update Quantity from Cart  |");
            System.out.println("       |     4     |   Print Receipt              |");
            System.out.println("       |     5     |   Back                       |");
            System.out.println("       +------------------------------------------+\n");
            System.out.print("\u001B[33m               Enter your choice: \u001B[0m");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPhoneToPurchase(phoneList, purchase, scanner);
                    break;
                case 2:
                    removePhone(purchase, scanner);
                    break;
                case 3:
                    updateQuantity(purchase, phoneList, scanner);
                    break;
                case 4:
                    purchase.printReceipt(purchase.total);
                    break;
                case 5:
                    mainMenu.main(null);
                default:
                    System.out.println("\u001B[31m        Invalid choice. Please select a valid operation!\u001B[0m\n");
            }
        }
    }

    private static void addPhoneToPurchase(PhoneList phoneList, purchase purchase, Scanner scanner) {
        phoneList.displayPhoneInventory();
        System.out.print("\u001B[33m        Enter the item number of the phone you want to purchase: \u001B[0m");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= phoneList.size()) {
            Phone selectedPhone = phoneList.get(itemNumber - 1); // Adjust for 0-based indexing

            // Check if the selected phone model already exists in the purchase
            boolean found = false;
            for (PurchasedPhone purchasedPhone : purchase.getPurchasedPhones()) {
                if (purchasedPhone.getPhone().getModel().equals(selectedPhone.getModel())) {
                    // If found, update the quantity in both purchase and inventory
                    System.out.print("\n\u001B[33m        Enter the quantity you want to purchase: \u001B[0m");
                    int quantity = scanner.nextInt();
                    if (quantity > 0 && quantity <= selectedPhone.getQuantity()) {
                        purchase.updateQuantity(purchasedPhone.getPhone(), purchasedPhone.getQuantity() + quantity);
                        selectedPhone.setQuantity(selectedPhone.getQuantity() - quantity); // Decrement inventory
                        System.out.println("\n\u001B[32m        Phone added to the purchase!\u001B[0m");
                    } else {
                        System.out.println("\n\u001B[31m        Invalid quantity. Quantity must be greater than 0 and not exceed available stock!\u001B[0m");
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                // If not found, add it as a new item in the purchase
                int quantity;
                do {
                    System.out.print("\u001B[33m        Enter the quantity you want to purchase: \u001B[0m");
                    quantity = scanner.nextInt();
                    if (quantity <= 0) {
                        System.out.println("\n\u001B[31m        Quantity must be greater than 0!\u001B[0m");
                    } else if (quantity > selectedPhone.getQuantity()) {
                        System.out.println("\n\u001B[31m           Not enough stock available!\u001B[0m");
                    }
                } while (quantity <= 0 || quantity > selectedPhone.getQuantity());

                purchase.addPhone(selectedPhone, quantity);
                selectedPhone.setQuantity(selectedPhone.getQuantity() - quantity); // Decrement inventory
                System.out.println("\n\u001B[32m        Phone added to the purchase!\u001B[0m");
            }
        } else {
            System.out.println("\n\u001B[31m        Invalid item number!\u001B[0m");
        }

    }



    private static void removePhone(purchase purchase, Scanner scanner) {
        // Display the receipt with item numbers
        purchase.printReceipt(purchase.total);

        System.out.print("\u001B[33m        Enter the item number of the phone you want to remove: \u001B[0m");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= purchase.getPurchasedPhones().length) {
            PurchasedPhone selectedPurchasedPhone = purchase.getPurchasedPhones()[itemNumber - 1]; // Adjust for 0-based indexing

            // Remove the selected phone from the purchase
            purchase.removePhone(selectedPurchasedPhone);
            System.out.println("\n\u001B[32m        Phone removed from the purchase!\u001B[0m");
        } else {
            System.out.println("\n\u001B[31m        Invalid item number!\u001B[0m");
        }
    }




    private static void updateQuantity(purchase purchase, PhoneList phoneList, Scanner scanner) {
        // Display the receipt with item numbers;
        purchase.printReceipt(purchase.total);

        System.out.print("\u001B[33m        Enter the item number of the phone you want to update: \u001B[0m");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= purchase.getPurchasedPhones().length) {
            PurchasedPhone selectedPurchasedPhone = purchase.getPurchasedPhones()[itemNumber - 1]; // Adjust for 0-based indexing

            System.out.print("\u001B[33m        Enter new quantity: \u001B[0m");
            int newQuantity = scanner.nextInt();

            // Get the phone object from the selected purchased phone
            Phone selectedPhone = selectedPurchasedPhone.getPhone();

            // Calculate the difference between the new and old quantities
            int quantityDifference = newQuantity - selectedPurchasedPhone.getQuantity();

            // Check if the new quantity is valid
            if (newQuantity >= 0 && selectedPhone.getQuantity() >= quantityDifference) {
                // Update the quantity of the selected purchased phone
                purchase.updateQuantity(selectedPhone, newQuantity);

                // Update the available stock quantity
                selectedPhone.setQuantity(selectedPhone.getQuantity() - quantityDifference);

                System.out.println("\u001B[32m        Quantity updated successfully!\u001B[0m");
            } else {
                System.out.println("\u001B[31m        Invalid quantity! Please enter a valid quantity within the available stock.\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31m        Invalid item number!\u001B[0m");
        }
    }




}

