# qBay 

**qBay** is a command-line marketplace application built in Java, simulating a mini e-commerce platform. Users can browse items, add them to their cart, list their own items for sale, and complete purchases — all from the terminal.

---

## Features

- **Buy Items**  
  Browse available products and view detailed information before purchasing.

- **Cart System**  
  Add items to your cart, view cart contents, calculate total cost, and complete purchases.

- **Sell Items**  
  Add your own listings with name, price, and category. View items you've listed.

- **Persistent Files**  
  Purchases and cart contents are tracked using local text files (`cart.txt`, `purchased.txt`).


## How to Run

Make sure you're in the root of the project directory and run:

javac qBay/*.java
java qBay.login

When prompted with the **login** option

Enter "john.do@quinnipiac.edu" into the email prompt

&

Enter "pass123" into the password prompt

## Example

Main Menu:
1. Buy
2. Sell
3. Cart
4. Logout
Please choose an option (1-4): 1

You selected 'Buy'.
Items available for sale:
1. HS101 Textbook - 25$
2. Wooden Desk - 75$
...
Would you like to add this product to cart? (Y/N)
