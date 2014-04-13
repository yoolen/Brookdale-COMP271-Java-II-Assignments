package mathstuff.geometry;

public class CircleOld 
	{
	protected double radius; // not private, inherited can directly access
	private static int howMany = 0;
	
	public CircleOld()
	{ 
		this(1.0);
	}

	public CircleOld (double radius)
	{
		this.radius = radius;
		howMany++;
	}

	public double findArea()
	{
		return radius * radius * Math.PI;
	}

	public String toString()
	{
		return ("Circle's radius is " + radius
				+ " and area is " + findArea() + " and there are " + CircleOld.getHowMany() + " circles.");
	}

	public static int getHowMany(){
		return howMany;
	}
	
	public static void main(String args[]){
		System.out.println(CircleOld.getHowMany());
		CircleOld circ1 = new CircleOld();
		System.out.println(circ1);
		CircleOld circ2 = new CircleOld(5);
		System.out.println(circ2);
	}
}