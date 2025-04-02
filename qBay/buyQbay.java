package qBay;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class buyQbay {
    public static void main() {

        Scanner scan = new Scanner(System.in);

        String[] allProducts = {
            "HS101 Textbook - 25$",
            "Wooden Desk - 75$",
            "MA101 Textbook - 30$",
            "Leather Couch - 250$",
            "Quinnipiac Sweatshirt - 40$"
        };

        Set<String> purchasedItems = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("qBay/purchased.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                purchasedItems.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Cannot access purchased.txt: " + e.getMessage());
        }

        boolean shopping = true;

        while(shopping) {

            System.out.println("These are the following items for sale:");

            int displayCount = 0;
            for (int i = 0; i < allProducts.length; i++) {
                if (!purchasedItems.contains(allProducts[i])) {
                    System.out.println((i + 1) + ": " + allProducts[i]);
                    displayCount++;
                }
            }

            if (displayCount == 0) {
                System.out.println("No available items. Everything has been purchased.");
                return;
            }

            System.out.println("Enter the number of the index for more product information.\n");
            int productid = scan.nextInt();
            scan.nextLine(); 

            if (productid < 1 || productid > allProducts.length || purchasedItems.contains(allProducts[productid - 1])) {
                System.out.println("Invalid or unavailable product. Try again.");
                continue;
            }

            String selectedProduct = allProducts[productid - 1];

            if (selectedProduct.contains("HS101")) {
                System.out.println("Product Name: HS101 Textbook\nCategory: Textbook\nSeller: John Doe\nEmail: johndoe@quinnipiac.edu\nPrice: 25$");
            } else if (selectedProduct.contains("Wooden Desk")) {
                System.out.println("Product Name: Wooden Desk\nCategory: Furniture\nSeller: Jane Doe\nEmail: janedoe@quinnipiac.edu\nPrice: 75$");
            } else if (selectedProduct.contains("MA101")) {
                System.out.println("Product Name: MA101 Textbook\nCategory: Textbook\nSeller: Noel Kirby\nEmail: noelkirby@quinnipiac.edu\nPrice: 30$");
            } else if (selectedProduct.contains("Leather Couch")) {
                System.out.println("Product Name: Leather Couch\nCategory: Furniture\nSeller: Emre Barrera\nEmail: emrebarrera@quinnipiac.edu\nPrice: 250$");
            } else if (selectedProduct.contains("Sweatshirt")) {
                System.out.println("Product Name: Quinnipiac Sweatshirt\nCategory: Clothing\nSeller: Jake Schultz\nEmail: jakeschultz@quinnipiac.edu\nPrice: 40$");
            }

            System.out.println("Would you like to add this product to cart? Enter Y/N");
            String addtoCart = scan.nextLine();

            if(addtoCart.equalsIgnoreCase("Y")) {

                try (FileWriter writer = new FileWriter("qBay/cart.txt", true)) {
                    writer.write(allProducts[productid - 1] + "\n");
                    System.out.println("Product added to cart.");
                    
                } catch (IOException e) {
                    System.out.println("Error writing to cart: " + e.getMessage());
                }

                System.out.println("Would you like to view more items or return to the menu? Enter 'more' or 'menu' ");
                String itemsorMenu = scan.nextLine();
                
                if(itemsorMenu.equalsIgnoreCase("more")){
                    System.out.println("Returning to product list...");
                } else if(itemsorMenu.equalsIgnoreCase("menu")) {
                    shopping = false; 
                    return;
                }
                
            } else if(addtoCart.equalsIgnoreCase("N")) {
                System.out.println("Returning to product list...");
            } else{
                System.out.println("Incorrect letter, please re-enter your choice.");
            }
        }
    }
}

