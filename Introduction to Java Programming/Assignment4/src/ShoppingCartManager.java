import java.util.Scanner;

public class ShoppingCartManager{
public static void main(String[] args){
	Scanner scnr = new Scanner(System.in);
	String custName = "none";
	String date = "February 1, 2016";
	String choice = "";
	boolean mainLoop = true;

	System.out.println("Enter Customer's Name:");
	custName = scnr.nextLine();
	System.out.println("Enter Today's Date:");
	date = scnr.nextLine();
	System.out.println("");
	ShoppingCart customer = new ShoppingCart(custName, date);
	ShoppingCart tempItem = new addItem(tempName, tempDescription, tempPrice, tempQuantity);
	System.out.println("Customer Name: " + custName);
	System.out.println("Today's Date: " + date);

	
	
	customer.printMenu();
		while(true){

		choice = scnr.nextLine();

			switch(choice){

			
				case "q":
					System.exit(0);
					break;

				case "a":
					System.out.println("ADD ITEM TO CART");
					System.out.println("Enter the item name:");
					String tempName = scnr.nextLine();
					System.out.println("Enter the item description:");
					String tempDescription = scnr.nextLine();
					System.out.println("Enter the item price:");
					int tempPrice = scnr.nextInt();
					System.out.println("Enter the item quantity:");
					int tempQuantity = scnr.nextInt();
					customer.addItem(tempName, tempDescription, tempPrice, tempQuantity);
					customer.printMenu();

					break;		

				case "d":
					System.out.println("REMOVE ITEM FROM CART");
					System.out.println("Enter name of item to remove:");
					String item = scnr.nextLine();
					customer.removeItem(item);
					customer.printMenu();
					break;

				case "c":
					System.out.println("CHANGE ITEM QUANTITY");
					System.out.println("Enter the item name:");
					String name = scnr.nextLine();
					System.out.println("Enter the new quantity:");
					int quantity = scnr.nextInt();
					customer.modifyItem(name, quantity);
					customer.printMenu();				
					break;

				case "i":
					System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
					customer.printDescriptions();
					customer.printMenu();
					break;

				case "o":
					System.out.println("OUTPUT SHOPPING CART");
					customer.printTotal();
					customer.printMenu();
					break;


				default:
					System.out.println("Choose an option:");
			}
		}

	}
}