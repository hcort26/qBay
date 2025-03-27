package qBay;
import java.util.Scanner;

public class buyQbay {
    public static void start(Scanner scanner) {
        String[] products = new String[5];

        products[0] = "HS101 Textbook";
        products[1] = "Wooden Desk";
        products[2] = "MA101 Textbook";
        products[3] = "Leather Couch";
        products[4] = "Quinnipiac Sweatshirt";

        boolean shopping = true;

        while(shopping) {

            System.out.println("These are the following items for sale:");

            for(int i = 0; i < products.length; i++) {

                System.out.println("Product at index " + (i + 1) + ": " + products[i]);

            }

            System.out.println("Enter the number of the index for more product information.\n");
            int productid = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch(productid) {
                case 1: 
                System.out.println("Product Name: HS101 Textbook");
                System.out.println("Category: Textbook");
                System.out.println("Seller: John Doe");
                System.out.println("Email: johndoe@quinnipiac.edu");
                System.out.println("Price: 25$");
                break;

                case 2: 
                System.out.println("Product Name: Wooden Desk");
                System.out.println("Category: Furniture");
                System.out.println("Seller: Jane Doe");
                System.out.println("Email: janedoe@quinnipiac.edu");
                System.out.println("Price: 75$");
                break;

                case 3: 
                System.out.println("Product Name: MA101 Textbook");
                System.out.println("Category: Textbook");
                System.out.println("Seller: Noel Kirby");
                System.out.println("Email: noelkirby@quinnipiac.edu");
                System.out.println("Price: 30$");
                break;

                case 4: 
                System.out.println("Product Name: Leather Couch");
                System.out.println("Category: Furniture");
                System.out.println("Seller: Emre Barrera");
                System.out.println("Email: emrebarrera@quinnipiac.edu");
                System.out.println("Price: 250$");
                break;

                case 5: 
                System.out.println("Product Name: Quinnipiac Sweatshirt");
                System.out.println("Category: Clothing");
                System.out.println("Seller: Jake Schultz");
                System.out.println("Email: jakeschultz@quinnipiac.edu");
                System.out.println("Price: 40$");
                break;

                default:
                    System.out.println("Invalid index. Try again.");
                    continue; // skip back to start of loop
            }

            System.out.println("Would you like to add this product to cart? Enter Y/N");

            String addtoCart = scanner.nextLine();

            if(addtoCart.equalsIgnoreCase("Y")) {
                System.out.println("Product added to cart.");
                System.out.println("Would you like to view more items or return to the menu? Enter 'more' or 'menu' ");
                String itemsorMenu = scanner.nextLine();
                
                if(itemsorMenu.equalsIgnoreCase("more")){
                    System.out.println("Returning to product list...");
                } else if(itemsorMenu.equalsIgnoreCase("menu")) {
                    shopping = false; // end loop if they add to cart
                    return; // ends the method and brings you back to the main menu
                }
                
            } else if(addtoCart.equalsIgnoreCase("N")) {
                System.out.println("Returning to product list...");
            } else{
                System.out.println("Incorrect letter, please re-enter your choice.");
            }
        }
    }
}

