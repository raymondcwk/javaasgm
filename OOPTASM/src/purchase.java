import java.util.ArrayList;
import java.util.List;

public class purchase {
    private List<PurchasedPhone> purchasedPhones = new ArrayList<>();
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

    public void printReceipt() {
        double total = 0.0;
        System.out.println("Receipt:");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s%n", "Item", "Model", "Price(RM)", "Quantity", "Subtotal(RM)");

        // Iterate over purchased phones and print them with updated item numbers
        int itemNumber = 1;
        for (PurchasedPhone purchasedPhone : purchasedPhones) {
            Phone phone = purchasedPhone.getPhone();
            double subtotal = phone.getPrice() * purchasedPhone.getQuantity();
            total += subtotal;
            System.out.printf("%-5d %-20s %-10.2f %-10d %-10.2f%n", itemNumber, phone.getModel(), phone.getPrice(), purchasedPhone.getQuantity(), subtotal);
            itemNumber++;
        }

        System.out.printf("Total: RM %.2f%n", total);
    }


    public PurchasedPhone[] getPurchasedPhones() {
        return purchasedPhones.toArray(new PurchasedPhone[0]);
    }


}
