package gui;

import javax.swing.*;

import java.awt.*;

public class MyBorderLayout extends JFrame{
	
	public MyBorderLayout(String name){ // This is a GUI element
		super(name);
		//setLayout(new BorderLayout());
		/* Using an anonymous layout manager prevents us from modifying
		 * the layout afterwards. To dynamically modify layouts after they
		 * have been created we must explicitly declare a layout and then
		 * directly reference it to modify the properties using the appropriate
		 * mutators.
		 */		
		BorderLayout bdLay = new BorderLayout(); // Create a new layout manager
		setLayout(bdLay);
		bdLay.setHgap(10); // Dynamically set layout properties
		
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		add(new JButton("'kay"));
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JFrame myFrame = new MyBorderLayout("My Frame");
		// Creating an instance of this GUI element creates a new frame
		// MyFlowLayout ISA JFrame so it fits in myFrame.
	}

}
