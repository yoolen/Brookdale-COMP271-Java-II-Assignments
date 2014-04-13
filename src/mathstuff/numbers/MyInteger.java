package mathstuff.numbers;
/* Terry Chern
 * Comp 271-001RL
 * 2 February 2014
 * Lab 1 - P.400 #10.3 - MyInteger Class
 * Problem: Design a class named MyInteger. The class contains:
 * + An int data field named value that stores the int value represented by this object
 * + A constructor that creates a MyInteger object for the specified int value.
 * + A get method that returns the int value.
 * + The methods isEven(), isOdd(), and isPrime() that return true if the value in this
 * 	 object even, odd, or prime, respectively.
 * + The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the
 *   specified value is even, odd, or prime, respectively.
 * + The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that
 *   return true if the specified value is even, odd, or prime, respectively.
 * + The methods equals(int) and equals(MyInteger) that return true if the value in this
 *   object is equal to the specified value.
 * + A static method parseInt(char[]) that converts an array of numeric characters to an
 *   int value.
 * + A static method parseInt(String) that converts a string into an int value.
 * 
 * Method: An even number is divisible by 2 with no remainder; to test for evenness (and 
 * its opposite, oddness) we use the modulus operator (%); if a number modulus 2 is equal 
 * to zero, then that number is even, otherwise it is odd.
 * 
 * A prime number is defined as a number greater than 1 with no other factors besides 1
 * and itself. A simple method for testing for primeness is through trial division. An
 * examination of the factors of a known non-prime will show that the largest potential
 * factor that needs to be tested is the square root of that number (as the square root
 * is the pivot point from which the factors will be flipped and repeated):
 * ex: 16
 * 1	x	16
 * 2	x	8
 * 4	x	4	; the square root is the pivot point from which the factors are flipped
 * 8	x	2
 * 16	x	1   
 * It is not necessary to test any even factors (as any factor divisible by two would
 * already be accounted for upon the first division by 2) other than 2. While it is
 * possible to remove other factors by multiplying through discovered primes, such a
 * process would be useful for generating a list of primes (a device called the Sieve of
 * Eratosthenes), this is not as useful in testing for primality unless we were to create 
 * a list of primes to compare against. 
 * 
 * As such, a test for primeness using trial division for the number N would require a
 * loop of factors starting with 2, then all the odd numbers from 3 to sqrt(N). 
 */

public class MyInteger {
	private int value;
	
// Constructors
	public MyInteger() {
	// no-arg constructor creates a MyInteger with the default value of 0
		this(0);
	}
	
	public MyInteger(int value) {
		this.value = value;
	}

	
// Accessors and Mutators
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
// Testing Methods for Evenness/Oddness
	public static boolean isEven(int value){
	// We will use this static method as the basis for testing for even and oddness
		return (value%2==0); // returns the boolean result of the test based on value passed in
	}
	
	public static boolean isEven(MyInteger value){
	// Static method used to test MyInteger object instance
		return isEven(value.getValue());
	}
	
	public static boolean isOdd(int value){
	// Odd is the opposite of even, so we return the opposite value of the evenness test.
		return !isEven(value);
	}
	
	public static boolean isOdd(MyInteger value){
	// Class method used to test MyInteger object instance
		return !isEven(value.getValue());
	}
	
	public boolean isEven(){
	// Return evenness of value in object instance (Is this an Object/Instance method? or some other name?)
		return isEven(this.value);
	}
	
	public boolean isOdd(){
	// Return oddness of value in object instance
		return isOdd(this.value);
	}
	
	
// Testing Methods for Primality
	public static boolean isPrime(int value){
	// Static method that will be called by the class
		if (value < 2)
			return false;	// By definition negative numbers are not prime (int is +/- so must test).
		else if (value == 2)
			return true; 	// 2 is the first prime number
		else if (isEven(value) == true)	
			return false;	// numbers divisible by 2 (and not 2) are not primes
		else
			for (int factor = 3; factor <= (int)Math.sqrt(value); factor += 2){
				if (value % factor == 0)
					return false;	// if a factor is found number is not a prime
			}
			return true;	// the number is prime if no factors were found
	}
	
	public boolean isPrime(){
	// Object method
		return isPrime(this.value);
	}
	
	
// Testing Methods for Equality
	public boolean equals(int value){
		return (this.value == value);
	}
	
	public boolean equals(MyInteger value){
		return equals(value.getValue());
	}
	
	
// ParseInt Methods
	public static int parseInt(char[] input){
	// Convert char array to string then parsed via parseInt
		return Integer.parseInt(input.toString());
	}
	
	public static int parseInt(String input){
	// Convert string to integer
		return Integer.parseInt(input);
	}
	
	
// Output & Testing
	public String toString(){
	// toString method to output information
		return ((this.isEven()==true)?(this.value + " is even and "):(this.value + " is odd and ")) + 
				((this.isPrime() == true)?("is prime."):("is not prime."));
	}
	
	public static void main(String[] args) {
	// Driver method
		MyInteger value1 = new MyInteger(2);
		System.out.println(value1);
		value1.setValue(3);
		System.out.println(value1);
		value1.setValue(15);
		System.out.println(value1);
		value1.setValue(24);
		System.out.println(value1);
		value1.setValue(parseInt("113"));
		System.out.println(value1);
		System.out.println(value1.equals(113));
	}

}
