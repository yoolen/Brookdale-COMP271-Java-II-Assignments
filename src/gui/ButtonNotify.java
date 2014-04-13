package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* Terry Chern
 * Comp 271-001RL
 * 3 March 2014
 * Lab 6 - P.630 #16.2 - Find which button has been clicked on the console
 * Problem - Add the code to programming exercise 12.1 that will display
 * a message on the console indicating which button has been clicked.
 */
public class ButtonNotify extends JFrame{
	public ButtonNotify(String name){
		super(name); // Create a frame with appropriate name
		setLayout(new FlowLayout()); // Using FlowLayout for all these components
		setSize(560,80); // This is the size that closest matches Figure in book
			
		JButton b1 = new JButton("Button 1"); // It is necessary to explicitly
		JButton b2 = new JButton("Button 2"); // declare all these buttons because
		JButton b3 = new JButton("Button 3"); // we must add action listeners to
		JButton b4 = new JButton("Button 4"); // each one, which anonymous buttons
		JButton b5 = new JButton("Button 5"); // would not allow us to do without
		JButton b6 = new JButton("Button 6"); // having to declare an anonymous
											  // ActionListener for each button.
		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(b1); 						  
		p1.add(b2);
		p1.add(b3);
		add(p1); // Insert panel into Frame
				
		JPanel p2 = new JPanel(new FlowLayout()); // Create second panel
		p2.add(b4); // And populate it
		p2.add(b5);
		p2.add(b6);
		add(p2); // Insert panel into Frame
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // Show frame
		
		// Register Listener
		Listener navi = new Listener();
		b1.addActionListener(navi);
		b2.addActionListener(navi);
		b3.addActionListener(navi);
		b4.addActionListener(navi);
		b5.addActionListener(navi);
		b6.addActionListener(navi);
	}


	class Listener implements ActionListener {
	// Listener class waits for an action (in this case a button click) and
	// then performs an actionPerformed() required by the ActionListener
	// interface.
		  public void actionPerformed(ActionEvent e) {
			  System.out.println(e.getActionCommand() + " clicked!");
			  // Use reflection to get info about button clicked
		  }
	}

	public static void main(String[] args) {
		ButtonNotify buttons = new ButtonNotify("Test");
	}
	
}
