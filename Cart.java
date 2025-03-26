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
            StringBuilder sb = new StringBuilder();
            String line;
            
            // Read each line from the file and append it to the StringBuilder
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");  // Append line with newline
            }

            // Print the file contents (optional)
            System.out.println(sb.toString());
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
