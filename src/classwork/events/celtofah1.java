package classwork.events;

// Simple application to convert Celsius to Fahrenheit

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.text.DecimalFormat;

public class celtofah1 extends JFrame implements ActionListener
	// need to use an interface

 {
	private JTextField anslabel; 
    private JTextField ans;
	private JLabel lab_cel;
	
	
    private JPanel pn1, pn2;
		
	public celtofah1() 
	{
		super ("Celsius to Fahrenheit");
		
		BorderLayout bdLayout = new BorderLayout();
		setLayout(bdLayout);

        pn1 = new JPanel();
		pn2 = new JPanel();

		lab_cel = new JLabel("Enter Degrees in Celsius ");
		anslabel = new JTextField(10);
		
		anslabel.addActionListener(this);
		// add code to register for the event 
                
		ans = new JTextField(10);
        ans.setEditable(false);

		pn1.add(lab_cel);
		pn1.add(anslabel);
        pn2.add(ans);

		add(pn1,BorderLayout.NORTH);
		add(pn2,BorderLayout.SOUTH);
  			
		setSize(350,150);
		setVisible(true);
}
	public void actionPerformed(ActionEvent e)
	// Style 2: method within class
	// This is used to process the event
	{
		double cels = Double.parseDouble(anslabel.getText());
		double fah = 9/5.0 * cels + 32;
		this.ans.setText(String.format("%.1f",fah));
	}

	public static void main( String args[])
	{
		celtofah1 app = new celtofah1();

		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}