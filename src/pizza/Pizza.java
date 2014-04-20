package pizza;

import java.util.Date;

abstract public class Pizza {
	protected String size;
	protected String toppings;
	private Date time_order;
	protected double cost;
	public static final double DELIVERY_CHARGE = 5;
	
	protected Pizza(String sz) { // only allow sub-classes to instantiate
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
			result = String.format("At %s a %s pizza was ordered with: %s . The total is $%.2f", time_order, this.size, this.toppings, this.cost);	
		}
		return result;
	}
	
	public String getSize(){
		return this.size;
	}
	
	public Double getCost(){
		return cost;
	}
	
	public abstract void addTopping(String topping);  //subclass must implement this method
	public abstract void removeTopping(String topping);  //subclass must implement this method
}

class SmallPizza extends Pizza {
	public SmallPizza(){
		super("Small");
		super.cost = 8;
	}
	
	@Override
	public void addTopping(String topping){
	// Adds a topping and increments price accordingly
		super.toppings += topping + " ";
		cost += .25;
	}

	@Override
	public void removeTopping(String topping) {
	// Remove a topping and decrements price accordingly
		toppings = toppings.replace(topping + " ",""); // remove the topping
		if(cost > 8){ // use this to block ItemStateListener from reducing price below base price
			cost -= .25;
		}
	}
}

class MediumPizza extends Pizza {
	public MediumPizza(){
		super("Medium");
		super.cost = 10;
	}

	@Override
	public void addTopping(String topping) {
	// Adds a topping and increments price accordingly
		super.toppings += topping + " ";
		cost += .50;
		
	}
	@Override
	public void removeTopping(String topping) {
	// Remove a topping and decrements price accordingly
		toppings = toppings.replace(topping,""); // remove the topping
		if(cost > 10){ // use this to block ItemStateListener from reducing price below base price
			cost -= .50;
		}
	}
}

class LargePizza extends Pizza {
	public LargePizza(){
		super("Large");
		super.cost = 12;
	}

	@Override
	public void addTopping(String topping) {
	// Adds a topping and increments price accordingly
		super.toppings += topping + " ";
		cost += .75;		
	}
	
	@Override
	public void removeTopping(String topping) {
	// Remove a topping and decrements price accordingly
		toppings = toppings.replace(topping,""); // remove the topping
		if(cost > 12){ // use this to block ItemStateListener from reducing price below base price
			cost -= .75;
		}
	}
}

class XLargePizza extends Pizza {
	public XLargePizza(){
		super("X-Large");
		super.cost = 14;
	}
	
	@Override
	public void addTopping(String topping) {
	// Adds a topping and increments price accordingly
		super.toppings += topping + " ";
		cost += 1;		
	}
	@Override
	public void removeTopping(String topping) {
	// Remove a topping and decrements price accordingly
		toppings = toppings.replace(topping,""); // remove the topping
		if(cost > 14){  // use this to block ItemStateListener from reducing price below base price
			cost -= 1;
		}
	}

}