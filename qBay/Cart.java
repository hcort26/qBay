package qBay;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;



public class Cart {
    public int number;

    // Constructor to initialize the cart number
    public Cart(int number) {
        this.number = number;
    }

    // Method to read the contents of the cart.txt file
    public static void readCartFile() {
        // Use try-with-resources to ensure the BufferedReader is closed

        List<String> cartItems = new ArrayList<>();
        double totalPrice = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader("qBay/cart.txt"))) {
            String line;
            
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line into words (using regex \\s+ to handle multiple spaces)
                String[] words = line.split("\\s+");

                cartItems.add(line.trim());

                // Extract price using regex to find numbers before $
            try {
                String[] parts = line.split("-");
                if (parts.length >= 2) {
                    String pricePart = parts[1].trim().replace("$", "").replace("#", "");
                    totalPrice += Double.parseDouble(pricePart);
                }
            } catch (NumberFormatException e) {
                System.err.println("Could not parse price from item: " + line);
            }
                
                // Print each word
                for (String word : words) {
                    System.out.print(word);  // Prints each word on a new line                    
                }
                
                System.out.printf("Total: $%.2f\n", totalPrice);
                Scanner scan = new Scanner(System.in);
                System.out.println("Would you like to purchase the items in your cart? (Y/N)");
                String response = scan.nextLine();

                if (response.equalsIgnoreCase("Y")) {
                    try (FileWriter writer = new FileWriter("qBay/purchased.txt", true)) {
                        for (String item : cartItems) {
                            writer.write(item + "\n");
                        }
                        System.out.println("Thank you for your purchase!");
                        // Clears the cart
                        new PrintWriter("qBay/cart.txt").close();
                    } catch (IOException e) {
                        System.out.println("Error saving purchase: " + e.getMessage());
                    }
                } else {
                    System.out.println("Returning to main menu...");
                }
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Call the method to read the file
        readCartFile();
    }
}
