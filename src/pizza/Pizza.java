package pizza;

import java.util.Date;

abstract public class Pizza {
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