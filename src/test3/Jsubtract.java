package test3;

// A simple user interface used to subtract two numbers
// No error checking is done!!!!
// Responds to the enter key on the text2 field or the button

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jsubtract extends JApplet
  implements ActionListener 
{
	JTextField text1, text2, answertext;
	JLabel pluslabel, info;
	JButton button1;

	public Jsubtract()
	{
		// Set up an area to work on
		
		setLayout(new FlowLayout()); // One component after another from left to right

		// Now create some items to display to the user

		info = new JLabel("              Enter two numbers to subtract, then press the = button                        ");
		add(info);
		text1 = new JTextField(10);
		add(text1);

		pluslabel = new JLabel("-");
		add(pluslabel);
	
		text2 = new JTextField(10);
		add(text2);
		
		text2.addActionListener(this);

		button1 = new JButton("=");
		add(button1);
	
	    // Subscribe for when the user clicks this
		button1.addActionListener(this);

		answertext = new JTextField(10);
		answertext.setEditable(false);
		add(answertext);

		setSize(500,200);
		setVisible(true);
	}

	// Listen for when the user presses the button
	public void actionPerformed(ActionEvent e)
	{
		
		// convert from text to integer and add
		int diff = Integer.parseInt(text1.getText()) -
			Integer.parseInt(text2.getText());

		// convert the answer to a string and display
		answertext.setText(String.valueOf(diff));
	}
	
	public void init(){
		setSize(450,100);
	}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Subtract");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 100);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Jsubtract ad = new Jsubtract();
		ad.init();
		ad.start();
		frame.add(ad);
		frame.setVisible(true);
	}
}
