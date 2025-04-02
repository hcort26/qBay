package qBay;
import java.util.Scanner; 


public class login {
    private static final String email1 = "john.do@quinnipiac.edu"; 
    private static final String email2 = "jane.do@quinnipiac.edu";
    private static final String email3 = "noelkirby@quinnipiac.edu"; 
    private static final String password1 = "pass123"; 
    private static final String password2 = "pass123"; 
    private static final String password3 = "ilovemydog"; 

    public static void welcomeMessage(){

        

        System.out.println("  __      __       .__                               \n" + //
                        "/  \\    /  \\ ____ |  |   ____  ____   _____   ____  \n" + //
                        "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\ \n" + //
                        " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/ \n" + //
                        "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >\n" + //
                        "       \\/       \\/          \\/            \\/     \\/"); 
    } 

    public static boolean emailPassword() {
        Scanner scan = new Scanner(System.in);
        int attempts = 0; 

        while (attempts < 3){
        System.out.println("Please login with your QU Email and Password"); 
        
        System.out.println("Email: "); 
        String email = scan.nextLine(); 

        System.out.println("Password: "); 
        String password = scan.nextLine(); 

        if(email.equals(email1) && password.equals(password1) ||
        (email.equals(email2) && password.equals(password2)) ||
        (email.equals(email3) && password.equals(password3))) {
            System.out.println("Successful Login!!! ");
            return true; 
        }
        else{
            attempts++; 
            System.out.println("Incorrect email or password. you have " + (3 - attempts) + " attempt(s) left."); 
        }

        }
        System.out.println("You have attemted to log in too many times, you are locked out. "); 
        return false; 
    }

    public static void menu() {
        Scanner scan2 = new Scanner(System.in);

        while(true) {
            System.out.println(" Main Menu: \n1. Buy \n2. Sell \n3. Cart \n4. Logout");
            System.out.println("Please choose an option(1-4): "); 
            int choice = scan2.nextInt(); 

            if (choice == 1){
                System.out.println("you selected 'Buy'. ");
                buyQbay.main();
            }
            else if (choice == 2){
                System.out.println("you selected 'Sell'. ");
                Sell.sellMenu(scan2);
            }
            else if (choice == 3){
                System.out.println("you selected 'Cart'. ");
                Cart.main(null);
            }
            else if (choice == 4){
                System.out.println("Logging out...");
                logout.message();
            }
            else {
                System.out.println("Your choice was invalid, Please try again.  ");
            }
 
        }
    }

    public static void main(String[] args) {
        welcomeMessage(); 

        if (emailPassword()){
            menu(); 
        }
    }
}
