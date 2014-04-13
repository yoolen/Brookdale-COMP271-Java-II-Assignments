package gui;

import javax.swing.*;

import java.awt.*;

public class MyGridLayout extends JFrame{
	
	public MyGridLayout(String name){ // This is a GUI element
		super(name);
		setLayout(new GridLayout(3,3));
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	
		add(new JButton("'kay")); // By itself, this takes up the WHOLE frame, buttons are always centered
		add(new JTextField(10)); // This splits the frame into more columns
		add(new JLabel("Boop")); // This continues to split into more columns because rows=1, this becomes the determining factor
		add(new JButton("nop'"));
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		JFrame myFrame = new MyGridLayout("My Frame");
		// Creating an instance of this GUI element creates a new frame
		// MyFlowLayout ISA JFrame so it fits in myFrame.
		MyGrid2 myGrid = new MyGrid2("Phone Pad");
		
	}

}

class MyGrid2 extends JFrame{
	public MyGrid2(String name){
		super(name);
		setLayout(new GridLayout(4,3));		
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new JTextField()); // this doesn't give us the right format (need to use Panels for formatting). We can have different layouts within different panels
		for(int i = 1; i < 10; i++){
			add(new JButton(""+i)); //JButton only accepts strings
		}
		add(new JButton("*"));
		add(new JButton("0"));
		add(new JButton("#"));
		setVisible(true);
	}
}