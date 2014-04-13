package mathstuff.geometry;

import java.text.DecimalFormat;


public class Cylinder extends Circle{
	private double height;
	
	public Cylinder(){
		this(1.0,1.0);
	}
	
	public Cylinder(double radius, double height) {
		super(radius); // invokes constructor for circle
		this.height = height;
	}

	public void setHeight(double height){
		this.height = height;
	}
	
	public double getHeight(){
		return this.height;
	}

	public double findVolume(){
		return this.height * super.findArea();
	}
	
	public double findSA(){
		return (super.findArea()*2) + (2*Math.PI*super.getRadius()*this.height); 
	}
	
	public String toString(){
		DecimalFormat df = new DecimalFormat("#.00");
		return ("Cylinder's radius is " + df.format(super.getRadius()) + " and height is " + df.format(this.getHeight()) + " and surface area is " + df.format(this.findSA()) + " and volume is " + df.format(this.findVolume()));
	}
	
	public static void main(String args[]){
		Cylinder cyl1 = new Cylinder(2,2);
		System.out.print(cyl1);
	}
}
