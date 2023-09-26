import java.util.Scanner;

public class purchaseMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneList phoneList = new PhoneList(); // Create a PhoneList object here
        purchase purchase = new purchase();

        while (true) {
            System.out.println("Purchase Menu:");
            System.out.println("1. Add Phone to cart");
            System.out.println("2. Remove Phone from cart");
            System.out.println("3. Update Quantity from cart");
            System.out.println("4. Print Receipt");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPhoneToPurchase(phoneList, purchase, scanner);
                    break;
                case 2:
                    removePhone(purchase, scanner);
                    break;
                case 3:
                    updateQuantity(purchase, scanner);
                    break;
                case 4:
                    purchase.printReceipt();
                    break;
                case 5:
                    mainMenu.main();
                default:
                    System.out.println("Invalid choice. Please select a valid operation.");
            }
        }
    }

    private static void addPhoneToPurchase(PhoneList phoneList, purchase purchase, Scanner scanner) {
        phoneList.displayPhoneInventory();
        System.out.print("Enter the item number of the phone you want to purchase: ");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= phoneList.size()) {
            Phone selectedPhone = phoneList.get(itemNumber - 1); // Adjust for 0-based indexing

            // Check if the selected phone model already exists in the purchase
            boolean found = false;
            for (PurchasedPhone purchasedPhone : purchase.getPurchasedPhones()) {
                if (purchasedPhone.getPhone().getModel().equals(selectedPhone.getModel())) {
                    // If found, update the quantity in both purchase and inventory
                    System.out.print("Enter the quantity you want to purchase: ");
                    int quantity = scanner.nextInt();
                    if (quantity > 0 && quantity <= selectedPhone.getQuantity()) {
                        purchase.updateQuantity(purchasedPhone.getPhone(), purchasedPhone.getQuantity() + quantity);
                        selectedPhone.setQuantity(selectedPhone.getQuantity() - quantity); // Decrement inventory
                        System.out.println("Phone added to the purchase.");
                    } else {
                        System.out.println("Invalid quantity. Quantity must be greater than 0 and not exceed available stock.");
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                // If not found, add it as a new item in the purchase
                int quantity;
                do {
                    System.out.print("Enter the quantity you want to purchase: ");
                    quantity = scanner.nextInt();
                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                    } else if (quantity > selectedPhone.getQuantity()) {
                        System.out.println("Not enough stock available.");
                    }
                } while (quantity <= 0 || quantity > selectedPhone.getQuantity());

                purchase.addPhone(selectedPhone, quantity);
                selectedPhone.setQuantity(selectedPhone.getQuantity() - quantity); // Decrement inventory
                System.out.println("Phone added to the purchase.");
            }
        } else {
            System.out.println("Invalid item number.");
        }

    }



    private static void removePhone(purchase purchase, Scanner scanner) {
        // Display the receipt with item numbers
        purchase.printReceipt();

        System.out.print("Enter the item number of the phone you want to remove: ");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= purchase.getPurchasedPhones().length) {
            PurchasedPhone selectedPurchasedPhone = purchase.getPurchasedPhones()[itemNumber - 1]; // Adjust for 0-based indexing

            // Remove the selected phone from the purchase
            purchase.removePhone(selectedPurchasedPhone);
            System.out.println("Phone removed from the purchase.");
        } else {
            System.out.println("Invalid item number.");
        }
    }




    private static void updateQuantity(purchase purchase, Scanner scanner) {
        // Display the receipt with item numbers;
        purchase.printReceipt();

        System.out.print("Enter the item number of the phone you want to update: ");
        int itemNumber = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= purchase.getPurchasedPhones().length) {
            PurchasedPhone selectedPurchasedPhone = purchase.getPurchasedPhones()[itemNumber - 1]; // Adjust for 0-based indexing

            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();

            // Update the quantity of the selected purchased phone
            purchase.updateQuantity(selectedPurchasedPhone.getPhone(), newQuantity);
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Invalid item number.");
        }
    }


}

