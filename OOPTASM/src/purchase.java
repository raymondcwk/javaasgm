import java.util.ArrayList;
import java.util.List;

public class purchase {
    public static double total;
    private static List<PurchasedPhone> purchasedPhones = new ArrayList<>();
    private int itemCounter = 1;

    public void addPhone(Phone phone, int quantity) {
        PurchasedPhone purchasedPhone = new PurchasedPhone(phone, quantity, itemCounter);
        purchasedPhones.add(purchasedPhone);
        itemCounter++;
    }

    public void removePhone(PurchasedPhone purchasedPhone) {
        purchasedPhones.remove(purchasedPhone);
        Phone phone = purchasedPhone.getPhone();
        phone.setQuantity(phone.getQuantity() + purchasedPhone.getQuantity());
    }


    public void updateQuantity(Phone phone, int newQuantity) {
        for (PurchasedPhone purchasedPhone : purchasedPhones) {
            if (purchasedPhone.getPhone().equals(phone)) {
                purchasedPhone.setQuantity(newQuantity);
                break;
            }
        }
    }

    public static void printReceipt(double total) {
        total = 0.0;
        System.out.println("\n\u001B[35m                    Receipt\u001B[0m");
        System.out.println("        _________________________________________________________________________");
        System.out.printf("        | %-5s | %-20s | %-10s | %-10s | %-10s |%n", "Item", "Model", "Price(RM)", "Quantity", "Subtotal(RM)");
        System.out.println("        _________________________________________________________________________");

        // Iterate over purchased phones and print them with updated item numbers
        int itemNumber = 1;
        for (PurchasedPhone purchasedPhone : purchasedPhones) {
            Phone phone = purchasedPhone.getPhone();
            double subtotal = phone.getPrice() * purchasedPhone.getQuantity();
            total += subtotal;
            System.out.printf("        | %-5d | %-20s | %-10.2f | %-10d | %-10.2f   |%n", itemNumber, phone.getModel(), phone.getPrice(), purchasedPhone.getQuantity(), subtotal);
            System.out.println("        _________________________________________________________________________");
            itemNumber++;
        }

        System.out.printf("\n\u001B[32m        Total: RM %.2f%n\u001B[0m\n", total);
    }

    public static double getTotal() {
        double total = 0.0;
        for (PurchasedPhone purchasedPhone : purchasedPhones) {
            Phone phone = purchasedPhone.getPhone();
            double subtotal = phone.getPrice() * purchasedPhone.getQuantity();
            total += subtotal;
        }
        return total;
    }
        private static boolean isPaid = false; // Initialize as not paid

        // Your other purchase-related methods and fields here

        public static void setTotal(double newTotal) {
            total = newTotal;
        }



        public static void setPaid(boolean paid) {
            isPaid = paid;
        }



    public static void deleteReceipt() {
        // Clear the purchasedPhones list to remove items from the old receipt
        purchasedPhones.clear();

        // Reset the total to zero to start a new receipt
        setTotal(0.0);

        // Mark the receipt as not paid
        setPaid(false);
    }




    public PurchasedPhone[] getPurchasedPhones() {
        return purchasedPhones.toArray(new PurchasedPhone[0]);
    }


}
