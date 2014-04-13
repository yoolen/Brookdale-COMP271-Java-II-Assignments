package gui;
/* Terry Chern
 * Comp 271--001RL
 * 1 March 2014
 * Lab 5 - P.476 #12.1, 12.2, 12.3, 12.4 - Layout Managers
 * Problem:
 * 12.1 - Using the FlowLayout manager, write a program that:
 * -Creates a frame and sets its layout to FlowLayout
 * -Creates two panels and adds them to the frame
 * -Each panel contains 3 buttons, in a FlowLayout
 * 12.2 - Using the BorderLayout manage, write a program that:
 * -Uses BorderLayout instead of FlowLayout for the frame
 * -Conatins one panel in the SOUTH frame and the other in the CENTER
 * 12.3 - Using the GridLayout manage, write a program that:
 * -Uses a GridLayout to create two rows and 3 columns
 * -Populates these cells with 6 buttons
 * 12.4 - Define a class that extends JPanel
 * -Place 3 buttons in the panel class
 * -Create two panels from the user-defined panel class
 */

import javax.swing.*;

import java.awt.*;

public class MyFrame {

	public static void main(String[] args) {
		// Some of these frames may be hidden under the others.
		JFrame myFlowFrame = new MyFlowLO("Flow Frame");
		JFrame myBorderFrame = new MyBorderLO("Border Frame");
		JFrame myGridFrame = new MyGridLO("Grid Frame");
		JFrame myPanelFrame = new MyPanelLO("Panel Frame");
	}

}

// 12.1
class MyFlowLO extends JFrame{
	public MyFlowLO(String name){
		super(name); // Create a frame with appropriate name
		setLayout(new FlowLayout()); // Using FlowLayout for all these components
		setSize(560,80); // This is the size that closest matches Figure in book
		
		JPanel p1 = new JPanel(new FlowLayout()); // Create first panel
		p1.add(new JButton("Button 1")); // And populate it
		p1.add(new JButton("Button 2"));
		p1.add(new JButton("Button 3"));
		add(p1); // Insert panel into Frame
		
		JPanel p2 = new JPanel(new FlowLayout()); // Create second panel
		p2.add(new JButton("Button 4")); // And populate it
		p2.add(new JButton("Button 5"));
		p2.add(new JButton("Button 6"));
		add(p2); // Insert panel into Frame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // Show frame
	}
}

// 12.2
class MyBorderLO extends JFrame{
	public MyBorderLO(String name){
		super(name);	// Create new frame
		setLayout(new BorderLayout()); // Set layout to BorderLayout
		setSize(280,110);
		JPanel p1 = new JPanel(new FlowLayout()); // Create first panel
		p1.add(new JButton("Button 1")); // And populate it
		p1.add(new JButton("Button 2"));
		p1.add(new JButton("Button 3"));
		add(p1,BorderLayout.CENTER); // Insert panel into Frame's center
		
		JPanel p2 = new JPanel(new FlowLayout()); // Create second panel
		p2.add(new JButton("Button 4")); // And populate it
		p2.add(new JButton("Button 5"));
		p2.add(new JButton("Button 6"));
		add(p2,BorderLayout.SOUTH); // Insert panel into Frame's south
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // show the frame
	}	
}

// 12.3
class MyGridLO extends JFrame{
	public MyGridLO(String name){
		super(name);
		setLayout(new GridLayout(2,3)); // make a 2x3 grid
		setSize(280,110); // sized same as the BorderLayout
		
		// populate it with buttons
		add(new JButton("Button 1")); 
		add(new JButton("Button 2"));
		add(new JButton("Button 3"));
		add(new JButton("Button 4")); 
		add(new JButton("Button 5"));
		add(new JButton("Button 6"));
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // show the frame
	}
	
}

// 12.4 - Panel Class and PanelFrame Class to use the panels
class MyPanel extends JPanel{
	public MyPanel(int i){ // Pass in number of first button
		setLayout(new FlowLayout());
		add(new JButton("Button " + i));
		add(new JButton("Button " + (i+1)));
		add(new JButton("Button " + (i+2)));
	}
}

class MyPanelLO extends JFrame{ // Based off of 12.1 FlowLayout implementation
	public MyPanelLO(String name){
		super(name); // Create a frame with appropriate name
		setLayout(new FlowLayout()); // Using FlowLayout for all these components
		setSize(560,80); // This is the size that closest matches Figure in book
		
		add(new MyPanel(1)); // Insert panel into Frame
		add(new MyPanel(4)); // using anonymous classes!
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // Show frame
	}
}