import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cart {
    public int number;

    // Constructor to initialize the cart number
    public Cart(int number) {
        this.number = number;
    }

    // Method to read the contents of the cart.txt file
    public static void readCartFile() {
        // Use try-with-resources to ensure the BufferedReader is closed
        try (BufferedReader br = new BufferedReader(new FileReader("cart.txt"))) {
            String line;
            
            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Split the line into words (using regex \\s+ to handle multiple spaces)
                String[] words = line.split("\\s+");
                
                // Print each word
                for (String word : words) {
                    System.out.println(word);  // Prints each word on a new line
                }
                
                // Optionally, print the entire line after processing the words
                System.out.println("Processed line: " + line);
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
