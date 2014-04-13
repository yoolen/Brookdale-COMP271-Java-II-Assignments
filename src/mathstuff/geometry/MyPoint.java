package mathstuff.geometry;
/* Terry Chern
 * Comp 271-001RL
 * 2 February 2014
 * Lab 2 - P.400 #10.4 - MyPoint Class
 * Problem: Design a class named MyPoint to represent a point with x and y coordinates. 
 * The class contains:
 * + The data fields x and y that represent the coordinates.
 * + A no-arg constructor that creates a point at the origin (0,0).
 * + A constructor that constructs a point with specified coordinates.
 * + Two get methods for the data fields x and y, respectively.
 * + A method named distance that returns the distance from this point to another point
 * 	 of the MyPoint type.
 * + A method named distance that returns the distance from this point to another point
 *   with specified x and y coordinates.
 *  Write a test program that creates two points (0,0) and (10,30.5) and displays the
 *  difference between them.
 *  
 *  Method: The distance between two points is defined as the square root of the sum of 
 *  the squares of the differences of the x and y components:
 *  D(P1(x1,y1),P2(x2,y2)) = sqrt((x2-x1)^2 + (y2-y1)^2) 
 */
public class MyPoint {
	private double x, y;
	
// Constructors
	public MyPoint(){
	// no-arg generates a MyPoint with origin as its coordinates
		this(0,0);
	}
	
	public MyPoint(double x, double y){
	// generates a MyPoint with coordinates (x,y)
		this.x = x;
		this.y = y;
	}
	
// Accessors
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
// Functions
	public double distance(double x, double y){
	// method to determine distance from current MyPoint object to a set of coordinates
		return Math.sqrt(Math.pow(x-this.x,2) + Math.pow(y-this.y,2));
	}
	
	public double distance(MyPoint point){
	// passing coordinates of a MyPoint object as parameters to find distance
		return distance(point.getX(), point.getY());
	}
	
// Output and Testing
	public String toString() {
		return "(x,y) = (" + x + "," + y + ")";
	}
	
	public static void main(String[] args) {
		MyPoint point1 = new MyPoint();
		MyPoint point2 = new MyPoint(10,30.5);
		System.out.println("Point1 " + point1);
		System.out.println("Point2 " + point2);
		System.out.printf("Distance between Point1 and Point2 is %.2f units.\n", point1.distance(point2));
	}



}
