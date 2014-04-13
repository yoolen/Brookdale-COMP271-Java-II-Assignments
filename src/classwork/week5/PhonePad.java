package classwork.week5;

import java.awt.*;
import javax.swing.*;

public class PhonePad extends JFrame{
	
	public PhonePad(){
		setTitle("Phone Pad");
		setLayout(new BorderLayout());
		setSize(200,300);
		
		JPanel topPanel = new JPanel(); // Make top panel
		topPanel.setBackground(Color.gray); // set color to gray
		topPanel.add(new JTextField(15)); // add button to top panel (text field)
		
		add("North",topPanel);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(0,3,5,5));
		
		for(int i = 1; i < 10; i++){
			bottomPanel.add(new JButton(""+i));
		}
		bottomPanel.add(new JButton("*"));
		bottomPanel.add(new JButton("0"));
		bottomPanel.add(new JButton("#"));
		
		add("Center",bottomPanel);
	}

	
	public static void main(String[] arg){
		PhonePad pp1 = new PhonePad();
		pp1.setVisible(true);
	}
}
