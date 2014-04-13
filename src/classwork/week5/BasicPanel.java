package classwork.week5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BasicPanel extends JFrame
{

	public BasicPanel()
	{
		setTitle("Creating Panels");
		setLayout(new BorderLayout());
		
		// create top panel
		JPanel topPanel = new JPanel();

		// set panel size
		topPanel.setSize(100,50);

		//set color of the top panel
		topPanel.setBackground(Color.gray);

		// create buttons
	 	JButton redButton = new JButton("R");
		JButton blueButton = new JButton("B");
		JButton greenButton = new JButton("G");

		// set color of the buttons
		redButton.setBackground(Color.red);
		blueButton.setBackground(Color.blue);
		greenButton.setBackground(Color.green);

		// add button to top panel
		topPanel.add(redButton);
		topPanel.add(blueButton);
		topPanel.add(greenButton);

		// add top panel to frame
		add("North",topPanel);

		// create bottom panel
		JPanel bottomPanel = new JPanel();

		// set panel size
		bottomPanel.setSize(100,50);

		//set color of the bottom panel
		bottomPanel.setBackground(Color.gray);

		// create buttons
		JButton redButton1 = new JButton("Rd");
		JButton blueButton1 = new JButton("Blu");
		JButton greenButton1 = new JButton("Gren");

		// set color of the buttons
		redButton1.setBackground(Color.red);
		blueButton1.setBackground(Color.blue);
		greenButton1.setBackground(Color.green);

		// add button to bottom panel
		bottomPanel.add(redButton1);
		bottomPanel.add(blueButton1);
		bottomPanel.add(greenButton1);

		// add bottom panel to frame	 
		add("South",bottomPanel);
	}
	public static void main(String[] args)
	{
		JFrame f = new BasicPanel();
		f.setSize(600, 300);
		f.setVisible(true);

		f.addWindowListener(
			 new WindowAdapter(){
				public void windowClosing(WindowEvent e)
				{
				System.exit(0);
				}
			} );
	}
}