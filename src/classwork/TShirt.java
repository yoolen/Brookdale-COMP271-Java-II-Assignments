package classwork;

/* Terry Chern
 * Comp 271-001RL
 * 14 February 2014
 * Snow Day Assignment
 * Problem: Create a T_Shirt class which has a size, and get_price() and toString() methods. 
 * The get_price() method returns 10 and the toString() method returns the size of the T_Shirt 
 * and price of the T_Shirt as a string. All T_Shirts are made in the USA. Create a Small_T_Shirt 
 * class, Medium_T_Shirt class and Large_T_shirt class all which inherit from T_Shirt. The 
 * Large_T_Shirt's get_price() method returns 12.
 */
public class TShirt {
	protected String size;
	protected double price;
	public static final String madeIn = "USA";

// Constructors
	public TShirt(String size){
		this.size = size;
	}
	
// Methods
	public double getPrice(){
		return 10;
	}
	
	public String getSize(){
		return this.size;
	}
	
// Output
	@Override
	public String toString(){
		return String.format("This %s-sized T-shirt costs $%.2f.", this.getSize(), this.getPrice());
	}
	
// Driver
	public static void main(String[] args){
		Small_TShirt small = new Small_TShirt();
		Medium_TShirt med = new Medium_TShirt();
		Large_TShirt large = new Large_TShirt();
		System.out.println(small);
		System.out.println(med);
		System.out.println(large);
	}
}

class Small_TShirt extends TShirt{
	public Small_TShirt(){
		super("Small");
	}
}

class Medium_TShirt extends TShirt{
	public Medium_TShirt(){
		super("Medium");
	}
}

class Large_TShirt extends TShirt{
	public Large_TShirt(){
		super("Large");
	}
	
	@Override
	public double getPrice(){
		return 12;
	}
}

