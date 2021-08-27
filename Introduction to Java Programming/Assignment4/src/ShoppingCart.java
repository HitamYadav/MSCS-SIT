import java.util.ArrayList;

public class ShoppingCart{
	private String customerName;
	private String currentDate;
	private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

	public ShoppingCart(){
		customerName = "none";
		currentDate = "January 1, 2016";
	}

	public ShoppingCart(String customName, String currenDate){
		customerName = customName;
		currentDate = currenDate;
	}

	public String getCustomerName(){
		return customerName;
	}
	public String getDate(){
		return currentDate;
	}
	public void addItem(String itemName, String itemDescription, int itemPrice, int itemQuantity) {
		ItemToPurchase tempItem = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
		cartItems.add(tempItem);
	}
	public void removeItem(String itemName){
		boolean remove = false;
			for (int i = 0; i < cartItems.size(); ++i){
            	ItemToPurchase item = cartItems.get(i);       
            	if (itemName.equals(item.getName())){
                		cartItems.remove(i);
                		remove = true;
            	}            	            
			}
		if (!remove){
			System.out.println("Item not found in cart. Nothing removed.");
		}
	}
	public void modifyItem(String itemName,int itemQuantity){
		boolean modify = false;
			for (int i = 0; i < cartItems.size(); ++i){
            	ItemToPurchase item = cartItems.get(i);       
            	if (itemName.equals(item.getName())){
                		item.setQuantity(itemQuantity);
                		modify = true;
            	}            	            
			}
		if (!modify){
			System.out.println("Item not found in cart. Nothing modified.");
		}
	}
	public int getNumItemsInCart(){
		int numItems = 0;
		for (int i = 0; i < cartItems.size(); ++i){
			ItemToPurchase item = cartItems.get(i);
			int quantity = item.getQuantity();
			numItems += quantity;			
		}
		
		return numItems;
	}
	public int getCostOfCart(){
		int totalCost = 0;
		for (int i = 0; i < cartItems.size(); ++i){
			ItemToPurchase item = cartItems.get(i);
			totalCost += (item.getPrice() * item.getQuantity());
		}
		return totalCost;
	}
	public void printTotal(){
		int numItems = getNumItemsInCart();
		int cost = getCostOfCart();
		System.out.printf("%s's Shopping Cart - %s\n",getCustomerName(), getDate());
		System.out.println("Number of Items: " + numItems);
		System.out.println();
		if (numItems > 0){
			for (int i = 0; i < cartItems.size(); ++i){
				ItemToPurchase item = cartItems.get(i);
				item.printItemCost();
			}
			
		}
		else{
			System.out.println("SHOPPING CART IS EMPTY");
		}
		System.out.println();
		System.out.println("Total: $" + cost );
		

	}
	public void printDescriptions(){
		System.out.printf("%s's Shopping Cart - %s\n",getCustomerName(), getDate());
		System.out.println();
		System.out.println("Item Descriptions");

		for (int i = 0; i < cartItems.size(); ++i){
			ItemToPurchase item = cartItems.get(i);
			item.printItemDescription();
		}		
	}
	public void printMenu(){
	  System.out.println();
	  System.out.println("MENU");
      System.out.println("a - Add item to cart");
      System.out.println("d - Remove item from cart");
      System.out.println("c - Change item quantity");
      System.out.println("i - Output items' descriptions");
      System.out.println("o - Output shopping cart");
      System.out.println("q - Quit");
      System.out.println("");
      System.out.println("Choose an option:");
	}
	
}