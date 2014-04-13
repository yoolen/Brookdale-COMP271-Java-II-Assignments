package mathstuff.geometry;

import java.util.Arrays;

/* Terry Chern
 * Comp 271-001RL
 * 13 February 2014
 * Lab 4 - P.593 #15.11 - Enable Circle Comparable
 * Problem: Rewrite the Circle class in listing 15.2 to extend GeometricObject and
 * implement the Comparable interface. Override the equals method in the Object class.
 * Two Circle objects are equal if their radii are the same. Draw the UML diagram that
 * involves Circle, GeometricObject, and Comparable
 * 
 * Method: Use the GeometricObject class previously built as a superclass. 
 * Circles are defined by a single attribute: radius.
 * The Comparable interface is defined as such:
 * 	public interface Comparable<E>{
 * 		public int compareTo(E o);
 *  }
 * It is a generic interface; the generic type E is replaced by a concrete type (the
 * name of the class it is being implemented in) when it is implemented. The compareTo()
 * method compares the current object with the object o and returns an integer value:
 * Comparison | Return Value
 *  this < o  |     -1
 *  this == o |      0
 *  this > o  |      1
 */

public class Circle extends GeometricObject implements Comparable<Circle>{
	private double radius;

// Constructors
	public Circle(){
	// Default constructor makes a 0 radius circle (a point)
		this(0);
	}
	
	public Circle(double radius){
	// Create a circle of radius "radius"
		this.radius = radius;
	}

// Accessors and mutators
	public void setRadius(double newRadius){
	// Set a new radius
		this.radius = newRadius;
	}
	
	public double getRadius(){
	// Get the radius of a circle
		return this.radius;
	}
	
// Methods
	public static double findArea(double radius){
	// Find the area of a circle with radius "radius"
		return radius * radius * Math.PI;
	}
	
	public double findArea(){
	// Find the area of a Circle object
		return findArea(this.getRadius());
	}
	
	@Override
	public int compareTo(Circle o){
	// Compares THIS circle with circle o (checks radii)
		if(this.getRadius() > o.getRadius()){
			return 1;
		}
		else if(this.getRadius() < o.getRadius()){
			return -1;
		}
		else
			return 0;
	}
	
	public boolean equals(Circle o){
	// overrides implementation of equals() method from object, check radii not address space (for objects)
		if(this.getRadius() == o.getRadius()){
			return true;
		}
		else{
			return false;
		}
	}

// Output
	@Override
	public String toString()
	{
		return String.format("%s's radius is %.2f and has an area of %.3f units squared.",
				this.getClass().getName(),this.radius, this.findArea());
	}
	
// Driver
	public static void main(String args[]){
		Circle[] circles = new Circle[10]; // Create an array of 10 circles
		for(int i=0; i < circles.length; i++){ // Populate the array with 10 random circles
			circles[i] = new Circle(Math.random()*10);
		}
	
		System.out.println("Unsorted"); // Print array of circles before sorting
		for(Circle circle:circles){
			System.out.println(circle + " ");
		}
		Arrays.sort(circles); // Can be sorted because we implemented Comparable interface
		System.out.println("Sorted"); // Print sorted array
		for(Circle circle:circles){
			System.out.println(circle + " ");
		}
		
		Circle circle1 = new Circle(1);
		Circle circle2 = new Circle(2);
		Circle circle3 = new Circle(1);
		
		// Testing equals() method
		System.out.println("\nTesting equals method:");
		System.out.println("1." + circle1);
		System.out.println("2." + circle2);
		System.out.println("3." + circle3);
		System.out.println("circle1 is equal to circle2? " + circle1.equals(circle2));
		System.out.println("circle1 is equal to circle3? " + circle1.equals(circle3));
	}
}
