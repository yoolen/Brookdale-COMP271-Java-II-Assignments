package gui;

import javax.swing.*;
import java.awt.*;

public class MyFlowLayout extends JFrame{
	
	public MyFlowLayout(String name){ // This is a GUI element
		super(name);
		setLayout(new FlowLayout());
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(new JButton("'kay"));
		
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JFrame myFrame = new MyFlowLayout("My Frame");
		// Creating an instance of this GUI element creates a new frame
		// MyFlowLayout ISA JFrame so it fits in myFrame.
		MyFlowLayout myOtherFrame = new MyFlowLayout("My Other Frame");
		// This creates a new frame; however, when one frame is closed
		// all other frames of the same type are closed.
		
		// What if we reassign myFrame?
		myFrame = new MyFlowLayout("My New Frame");
		// We get yet another frame! The old one still exists, but what
		// happens to the variables and other stuff in it? Does the object
		// still actually exist, or just the frame?
		
	}

}
