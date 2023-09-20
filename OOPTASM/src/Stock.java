import java.util.Scanner;

public class Stock {
    public static staff PhoneList;

    public static void main(String[] args) {
        PhoneList phoneList = new PhoneList();
        Scanner scanner = new Scanner(System.in);

        Phone phone1 = new Phone("iPhone X", "999 USD", "10");
        Phone phone2 = new Phone("Samsung Galaxy S21", "899 USD", "8");
        Phone phone3 = new Phone("Google Pixel 6", "799 USD", "12");


        phoneList.addPhone(phone1);
        phoneList.addPhone(phone2);
        phoneList.addPhone(phone3);

        while (true) {
            System.out.println("Phone Inventory Management:");
            System.out.println("1. Add Phone");
            System.out.println("2. Delete Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Display Phone Inventory");
            System.out.println("5. Exit");
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
                    phoneList.displayPhoneInventory();
                    break;
                case 5:
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
        System.out.print("Enter price: ");
        String price = scanner.next();
        System.out.print("Enter quantity: ");
        String quantity = scanner.next();

        Phone newPhone = new Phone(model, price, quantity);
        phoneList.addPhone(newPhone);
    }
}
