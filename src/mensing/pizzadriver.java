package mensing;

import java.util.Date;


public class pizzadriver {
	public static void main(String[] args) {
		Small_Pizza sm = new Small_Pizza();
		sm.add_topping("Mushrooms");
		
		Medium_Pizza med = new Medium_Pizza();
		
		Large_Pizza larg = new Large_Pizza();
		larg.add_topping("Peppers");
		larg.add_topping("Onions");
		
		// Display some information
		System.out.println(sm.get_order());
		System.out.println(med.get_order());
		System.out.println(larg.get_order());
	}
}

abstract class Pizza implements Comparable{
	private String size;
	protected String toppings;
	private Date time_order;
	protected double cost;
	public static final double delivery_charge = 5;
	
	abstract public void add_topping(String topping); //subclass must implement this method
	
	public Pizza(String sz) {
		size = sz;
		time_order = new Date();
		toppings = "";
	}
	
	public String get_order() {
		String result;
		if (toppings.isEmpty()){
			result = String.format("At %s a %s pizza was ordered. The total is $%.2f", time_order, this.size, this.cost);
		}
		else{
			result = String.format("At %s a %s pizza with these toppings %s was ordered. The total is $%.2f", time_order, this.size, this.toppings, this.cost);	
		}
		return result;
	}
	
	@Override
	public int compareTo(Object obj){ // This should probably be implemented multiple times (for different pizza sizes at this level, then different prices at subclass level)
		if (obj instanceof Pizza){
			if (size.equals(((Pizza)obj).size)){
				if (cost < ((Pizza)obj).cost){
					return -1;
				}
				else if (cost > ((Pizza)obj).cost){
					return 1;
				}
				else 
					return 0;
			}
		}
	return 1;	
	}
}
class Small_Pizza extends Pizza {
	public Small_Pizza(){
		super("Small");
		super.cost = 8;
	}
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += .25;
	}
}

class Medium_Pizza extends Pizza {
	public Medium_Pizza(){
		super("Medium");
		super.cost = 10;
	}
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += .50;
	}
}

class Large_Pizza extends Pizza {
	public Large_Pizza(){
		super("Large");
		super.cost = 12;
	}
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += .75;
	}
}
