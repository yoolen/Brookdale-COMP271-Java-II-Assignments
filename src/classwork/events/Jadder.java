package classwork.events;

// A simple user interface used to add two numbers
// No error checking is done!!!!

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Jadder extends JFrame implements ActionListener
   //  implement action listener so we can respond to the user
{
	JTextField text1, text2, answertext;
	JLabel pluslabel, info;
	JButton button1;
	
	public Jadder()
	{
		super("Adder");
		// Set up an area to work on
		
		setLayout(new FlowLayout()); // One component after another from left to right

		// Now create some items to display to the user

		info = new JLabel("              Enter two numbers to add, then press the = button                        ");
		add(info);
		text1 = new JTextField(10);
		add(text1);

		pluslabel = new JLabel("+");
		add(pluslabel);
	
		text2 = new JTextField(10);
		add(text2);
		
		button1 = new JButton("=");
		add(button1);
	
		answertext = new JTextField(10);
		answertext.setEditable(false);
		add(answertext);

	    // Subscribe for when the user clicks the button
		button1.addActionListener(this); // Need to listen for button
		//text2.addActionListener(this); // This allows user to hit enter on 2nd text field
		//text1.addActionListener(this); // This allows user to hit enter on 1st text field
		
		setSize(350, 150);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// Listen for when the user presses the button
		this.answertext.setText("" + (Integer.parseInt(text1.getText()) + Integer.parseInt(text2.getText())));
	}

	

	public static void main( String args[])
	{
		Jadder app = new Jadder();

		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}



}