package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/* Terry Chern
 * Comp 271-001RL
 * 27 March 2014
 * Lab 7 - P666#17.6: Miles/Kilometers Converter
 * Problem: Write a program that converts miles and kilometers. If you
 * enter a value in the Mile text field and press the <Enter> key, the
 * corresponding kilometer measurement is displayed in the Kilometer
 * text field. Likewise, if you enter a value in the Kilometer text
 * field and press the <Enter> key, the corresponding miles is displayed
 * in the Mile text field.
 * Method: The conversion factor for miles to kilometres is
 *  1 mile = 1.60934 kilometers
 */

public class DistConverter extends JFrame implements ActionListener{
	public static final double MI2KM = 1.60934; // conversion factor for miles to kilometres
	private JTextField miles; // text field for miles
	private JTextField kilos; // test field for kilometres

	
	public DistConverter(String name){
		super(name); // Create a frame with heading 'name'
		setLayout(new FlowLayout()); 
		
	// Make sub-panels
		// Panel for descriptions, using GridLayout to stack them
		JPanel description = new JPanel();
		description.setLayout(new GridLayout(2,1));
		description.add(new JLabel("Mile(s)"));
		description.add(new JLabel("Kilometer(s)"));
		
		// Panel for input fields
		miles = new JTextField(10);
		miles.setActionCommand("miles");// give the text field the name "miles"
		miles.addActionListener(this); 	// register ActionListener
		
		kilos = new JTextField(10);
		kilos.setActionCommand("kilos");// give the text field the name "kilos"
		kilos.addActionListener(this);	// register ActionListener
		
		JPanel input = new JPanel(); 	// insert 2 data fields into input panel
		input.setLayout(new GridLayout(2,1));		
		input.add(miles);
		input.add(kilos);
		
		// Panel for aligning the description panel with the input fields panel
		JPanel window = new JPanel();
		window.setLayout(new BorderLayout());
		window.add(description,BorderLayout.WEST);
		window.add(input,BorderLayout.CENTER);
		
		// Add the panel to the frame, set the size and display
		add(window);
		setSize(250,90);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	// Single ActionListener used to detect which calculation 
	// to make and where to display the result.
		if(ae.getActionCommand()=="miles"){ // Source from miles, print to kilos
			this.kilos.setText(String.format("%.5f",Double.parseDouble(miles.getText())*MI2KM));
		}
		else // Source from kilos, print to miles
			this.miles.setText(String.format("%.5f",Double.parseDouble(kilos.getText())/MI2KM));
	}	

	public static void main(String[] args) {
		DistConverter myConverter = new DistConverter("Distance Calculator");
		myConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
