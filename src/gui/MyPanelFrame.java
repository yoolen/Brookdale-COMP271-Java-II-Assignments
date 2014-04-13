package gui;

import javax.swing.*;

import java.awt.*;

public class MyPanelFrame extends JFrame{
	
	public MyPanelFrame(String name){ // This is a GUI element
		super(name);
		JPanel topPanel = new JPanel(new GridLayout());
		JPanel bottomPanel = new JPanel(new GridLayout(4,3));
		
		setLayout(new BorderLayout());
		
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		topPanel.add(new JTextField());
		
		for(int i = 1; i < 10; i++){
			bottomPanel.add(new JButton(""+i));
		}
		bottomPanel.add(new JButton("*"));
		bottomPanel.add(new JButton("0"));
		bottomPanel.add(new JButton("#"));
		
		this.add(topPanel,BorderLayout.NORTH);
		this.add(bottomPanel,BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JFrame myFrame = new MyPanelFrame("Phone Pad");
		// Creating an instance of this GUI element creates a new frame
		// MyFlowLayout ISA JFrame so it fits in myFrame.	
	}
}