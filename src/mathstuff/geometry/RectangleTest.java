package mathstuff.geometry;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10,20); 	// 200
		Rectangle r2 = new Rectangle(5,40);		// 200
		Rectangle r3 = new Rectangle(1,1);		// 1
		Rectangle r4 = new Rectangle(20,20);	// 400
		
		System.out.println(r1.compareTo(r1));	// Same thing so equal
		System.out.println(r1.compareTo(r2));	// Same size so equal
		System.out.println(r1.compareTo(r3));	// Larger so 1
		System.out.println(r1.compareTo(r4));	// Smaller so -1
	}

}
