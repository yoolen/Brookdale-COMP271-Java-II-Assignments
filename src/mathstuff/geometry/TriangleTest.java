package mathstuff.geometry;

/* Terry Chern
 * Comp 271-001RL
 * 6 February 2014
 * John Mensing
 * Lab 3a: P.442#11.1 - The Triangle Class
 * Problem: Design a class named Triangle that extends GeometricObject. The class contains:
 * + Three double data fields named side1, side2, and side3 with default values 1.0 to denote
 * 	 three sides of a triangle.
 * + A no-arg constructor that creates a default triangle.
 * + A constructor that creates a triangle with the specified side1, side2, and side3.
 * + The accessor methods for all three data fields.
 * + A method named getArea() that returns the area of this triangle.
 * + A method named getPerimeter() that returns the perimeter of this triangle.
 * + A method named toString() that returns a string description for the triangle.
 * Method: GeometricObject is a general class that is defined by the text as follows:
 * 	GeometricObject
 *  ---------------
 * 	-color:String
 * 	-filled:boolean
 * 	-dateCreated:java.util.Date
 *  ---------------
 *  +GeometricObject()
 *  +GeometricObject(color:String, filled:boolean)
 *  +getColor():String
 *  +setColor(color:String):void
 *  +isFilled():boolean
 *  +setFilled(filled:boolean):void
 *  +getDateCreated():java.util.Date
 *  +toString():String
 *  
 *  The perimeter of a triangle is the sum of the length of its three sides.
 *  The semiperimeter(S) is the perimeter divided by 2 (this is used in solving for area)
 *  The area of a triangle given the length of its three sides can be found using Heron's formula:
 *  	Area = sqrt(s*(s-side1)*(s-side2)*(s-side3))
 */


public class TriangleTest {
// Driver Class
	public static void main(String[] args) {
		Triangle tri1 = new Triangle();
		System.out.println(tri1);
	}
}

// Subclass Triangle
class Triangle extends GeometricObject{
	private double side1, side2, side3;
	
// Constructors
	public Triangle() {
	// Default generates 1x1x1 triangle
		this(1.0, 1.0, 1.0);
	}

	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
// Accessors (No mutators defined by class)
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}

// Data methods
	public double getPerimeter(){
	// Perimeter is sum of all sides
		return side1+side2+side3;
	}
	
	public double getArea(){
	// Area calculated using Heron's Rule
		double semiPer = this.getPerimeter()/2;
		return Math.sqrt(semiPer*(semiPer-side1)*(semiPer-side2)*(semiPer-side3));
	}
	
	
// Output
	@Override
	public String toString(){
		return String.format("Triangle with sides %.2f, %.2f, %.2f has a perimeter of %.2f, and an area of %.3f units.",side1,side2,side3,this.getPerimeter(),this.getArea());
	}
}