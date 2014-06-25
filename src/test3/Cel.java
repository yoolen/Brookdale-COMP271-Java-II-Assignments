package test3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// Celsius to Fahrenheit conversion
//  fah = 9/5.0 * cel + 32;

// Subscribe to the event to convert celsius to fahrenheit 
// Add exception handling for invalid numbers

public class Cel extends JFrame implements ActionListener
{
	JTextField cel_text, fah_text;
	JLabel cel_label, fah_label;
	public static final double CEL2FAH = 9/5.0; 
	
	public Cel()
	{
		super("Celsius");
		// Set up an area to work on
		
		setLayout(new FlowLayout()); 

		cel_label = new JLabel("Celsius");
		add(cel_label);
		cel_text = new JTextField(10);
		cel_text.setActionCommand("Cel");
		add(cel_text);
		cel_text.addActionListener(this);

		fah_label = new JLabel("Fah");
		add(fah_label);
	
		fah_text = new JTextField(10);
		add(fah_text);	
		fah_text.addActionListener(this);
	   
	
		setSize(350, 150);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		// get the value from the cel_text field.
		// convert to a numeric - catch exceptions from invalid numbers.
		// convert celsius to fahrenheit using this formula, fahrenheit = 9/5.0 * celsius + 32
		// display the result in the fah_text field
		try{
			if(ae.getActionCommand()=="Cel"){ // Source from miles, print to kilos
				this.fah_text.setText(String.format("%.1f",Double.parseDouble(cel_text.getText())*CEL2FAH + 32));
			}
			else // Source from kilos, print to miles
				this.cel_text.setText(String.format("%.1f",(Double.parseDouble(fah_text.getText())-32) /CEL2FAH ));
		} catch (NumberFormatException nfe){
			this.fah_text.setText("Invalid value");
			this.cel_text.setText("Invalid value");
		}
	}

		public static void main( String args[])
	{
		Cel app = new Cel();

		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}