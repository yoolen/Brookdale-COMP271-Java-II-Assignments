package iostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* Terry Chern
 * Comp 271-001RL
 * 14 April 2014
 * Lab 10 - P733#19.3: Binary I/O
 * Problem: Suppose a binary data file named Exercise19_03.dat has been created
 * and its data are created using writeInt(int) in DataOutputStream. The file
 * contains and unspecified number of integers. Write a program to find the sum
 * of the integers.
 * Method: We will first make a file called Exercise19_03.dat and fill it with
 * a random number of integers. We will track the sum of these integers separately
 * and then use the file as an input for the BinarySum class. We will then compare
 * the results to see if the program actually worked.
 */

public class BinarySum {

	public static void main(String[] args) throws IOException { 
	// throwing IOException optional, we're catching and dealing with any in this case
		int writeSum = 0, readSum = 0, randNum; 
		int maxNums = (int)(Math.ceil(Math.random()*100)); // generate 1-100 numbers
		
		// Create an output stream to the file
		try {
			DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise19_03.dat"));
			
			// Output values to the file
			for(int i = 0; i <= maxNums; i++){
				randNum = (int)(Math.ceil(Math.random()*100)); // generate a random number from 1-100
				writeSum += randNum; // track the sum for checking later
				output.writeInt(randNum); // write the number to the file			
			}
			
			// Close the output stream
			output.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		}
		

		try {
			// Create an input stream to get data
			DataInputStream input = new DataInputStream(new FileInputStream("Exercise19_03.dat"));
			
			// Read the values from the file
			while(true){ // read until EOF
				readSum += input.readInt();
			}
		} catch (EOFException ex){ // use EOF exception to denote end of file
			// do nothing, just drop to the end.	
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe.getMessage());
		}
		
		// Now test to see if the read and write worked!
		System.out.printf("The sum of the values written is %d and the "
				+ "sum of the values read is %d.",writeSum,readSum);
	}
}
