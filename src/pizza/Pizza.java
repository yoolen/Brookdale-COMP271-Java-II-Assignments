package pizza;

import java.util.Date;

abstract public class Pizza {
	protected String size;
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
	
	public String getSize(){
		return this.size;
	}
}

class SmallPizza extends Pizza {
	public SmallPizza(){
		super("Small");
		super.cost = 8;
	}
	
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += .25;
	}
}

class MediumPizza extends Pizza {
	public MediumPizza(){
		super("Medium");
		super.cost = 10;
	}
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += .50;
	}
}

class LargePizza extends Pizza {
	public LargePizza(){
		super("Large");
		super.cost = 12;
	}
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += .75;
	}
}

class XLargePizza extends Pizza {
	public XLargePizza(){
		super("X-Large");
		super.cost = 14;
	}
	public void add_topping(String topping){
		super.toppings += topping + " ";
		cost += 1;
	}
}