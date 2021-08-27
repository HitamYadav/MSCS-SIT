public class ItemToPurchase {

	private String itemDescription;
	private String itemName;
	private int itemPrice;
	private int itemQuantity;

	public ItemToPurchase(){
		itemDescription = "none";
		itemName = "none";
		itemPrice = 0;
		itemQuantity = 0;
	}
	
	public ItemToPurchase(String description, String name, int price, int quantity){
		itemDescription = description;
		itemName = name;
		itemPrice = price;
		itemQuantity = quantity;
	}
	
	public void setDescription(String inputDescription){
		itemDescription = inputDescription;
	}
	public String getDescription(){
		return itemDescription;
	}
	
	
	public void setName(String inputName){
		itemName = inputName;
	}
	public String getName(){
		return itemName;
	}
	
	
	public void setPrice(int inputPrice){
		itemPrice = inputPrice;
	}
	public int getPrice(){
		return itemPrice;
	}
	
	
	public void setQuantity(int inputQuantity){
		itemQuantity = inputQuantity;
	}
	public int getQuantity(){
		return itemQuantity;
	}

	
	public void printItemCost(){
		System.out.printf("%s %d @ $%d = $%d\n",
                getName(),
                getQuantity(),
                getPrice(),
                getPrice() * getQuantity());
	}

	public void printItemDescription(){
		System.out.println(getName() + ": " + getDescription());
	}
}