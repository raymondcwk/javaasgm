import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class billing {
    public static void main() {
        // Define the payment methods
        Map<String, String> paymentMethods = new HashMap<>();
        paymentMethods.put("1", "Cash");
        paymentMethods.put("2", "Online Bank Transfer");

        // Define the items in the receipt
        Item[] items = new Item[]{
                new Item("Item 1", 10.0),
                new Item("Item 2", 20.0),
                new Item("Item 3", 30.0)
        };

        // Calculate the total price of the items
        double totalPrice = 0.0;

        for (Item item : items) {
            totalPrice += item.getPrice();
        }

        // Print the receipt
        System.out.println("Receipt:");

        for (Item item : items) {
            System.out.println(item.getName() + " - RM " + String.format("%.2f", item.getPrice()));
        }

        System.out.println("Total: RM" + String.format("%.2f", totalPrice));

        // Ask the user to select a payment method
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a payment method:");

        for (Map.Entry<String, String> entry : paymentMethods.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }

        String selection = scanner.nextLine();

        // Process the payment
        if (selection.equals("2")) {
            // Create an instance of the Item class for the virtual banking code
            Item item = new Item("Virtual Banking Code", totalPrice);

            // Pass the item to the virtual banking code
            VirtualBank.main(new String[]{item.getName(), String.valueOf(item.getPrice())});

            System.out.println("Payment processed - Online Bank Transfer");
        } else if (paymentMethods.containsKey(selection)) {
            System.out.println("Payment processed - " + paymentMethods.get(selection));
        } else {
            System.out.println("Invalid selection");
        }
    }
}


class Item {
    private final String name;
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
