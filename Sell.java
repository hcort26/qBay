import java.util.ArrayList;
import java.util.Scanner;


public class Sell {
    
    private static ArrayList<String> itemsForSale = new ArrayList<>();

    public static void viewItems() {
        if (itemsForSale.isEmpty()) {
            System.out.println("\nYou have no items listed for sale.");
        } else {
            System.out.println("\nYour Items for Sale:");
            for (int i = 0; i < itemsForSale.size(); i++) {
                System.out.println((i + 1) + ". " + itemsForSale.get(i));
            }
        }
    }

    public static void addItem(Scanner scanner) {
        System.out.print("\nEnter item name: ");
        String name = scanner.nextLine().trim();

        itemsForSale.add(name);
        System.out.println("\n " + name + " has been added for sale!");
    }

    public static void sellMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Sell Menu ---");
            System.out.println("1. View Items");
            System.out.println("2. Add Item");
            System.out.println("3. Return to Main Menu");
            System.out.println("Enter your choice: ");
            
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    viewItems();
                    break;
                case "2":
                    addItem(scanner);
                    break;
                case "3":
                    System.out.println("\nReturning to Main Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Enter 1, 2, or 3.");
            }
        }
    }
}
