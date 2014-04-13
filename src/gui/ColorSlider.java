package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* Terry Chern
 * Comp 271-001RL
 * 27 March 2014
 * Lab 8 - P669#17.16: Colors
 * Problem: Write a program that uses sliders to select the foreground
 * color for a label, as shown in Figure 17.29. Three horizontal sliders
 * are used for selecting the color’s red, green, and blue components. 
 * Use a title border on the panel that holds the sliders.
 */

public class ColorSlider extends JFrame implements ChangeListener{
	private JPanel colorDisplay; 
	private	JSlider red, green, blue;
	private JLabel redLabel, greenLabel, blueLabel;
	// create display space for color, needs to be outside of constructor
	// to be accessible to the class methods
	
	public ColorSlider(String name){
		super(name); // instantiate a JFrame
		setLayout(new GridLayout(2,1));
		
		// instantiate and set initial values of the display panel
		colorDisplay = new JPanel(new FlowLayout());
		colorDisplay.setSize(200,40);
		colorDisplay.setBackground(Color.black);
		
		//TitledBorder title = BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"Output");
		//title.setTitleJustification(TitledBorder.CENTER);
		//title.setTitlePosition(TitledBorder.CENTER);
		//colorDisplay.setBorder(title);
		
		// instantiate and set bounds and default values of the sliders
		red = new JSlider(JSlider.HORIZONTAL,0,255,0);
		green = new JSlider(JSlider.HORIZONTAL,0,255,0);
		blue = new JSlider(JSlider.HORIZONTAL,0,255,0);
		
		// create a formatting panel for the sliders and their labels
		JPanel inputPanel = new JPanel(new BorderLayout());
		inputPanel.setBorder(BorderFactory.createTitledBorder("Choose colors"));
		
		// create a panel to label the sliders
		JPanel rbgLabels = new JPanel(new GridLayout(3,1));
		rbgLabels.add(new JLabel("Red"));
		rbgLabels.add(new JLabel("Green"));
		rbgLabels.add(new JLabel("Blue"));
		
		// create a panel holding just the sliders
		JPanel rbgSliders = new JPanel(new GridLayout(3,1));
		rbgSliders.add(red);
		rbgSliders.add(green);
		rbgSliders.add(blue);
		
		// add the ChangeListeners
		red.addChangeListener(this);
		green.addChangeListener(this);
		blue.addChangeListener(this);
		
		// make a panel holding the current values of the RBG sliders
		JPanel rbgValues = new JPanel(new GridLayout(3,1));
		redLabel = new JLabel("0");
		greenLabel = new JLabel("0");
		blueLabel = new JLabel("0");
		rbgValues.add(redLabel);
		rbgValues.add(greenLabel);
		rbgValues.add(blueLabel);
		
		// put everything together for the input panel!
		inputPanel.add(rbgLabels,BorderLayout.WEST);
		inputPanel.add(rbgSliders,BorderLayout.CENTER);
		inputPanel.add(rbgValues,BorderLayout.EAST);
		
		// put everything together for the whole window!
		add(colorDisplay);
		add(inputPanel);

		// set size and make visible!
		setSize(400,200);
		setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent ce) {
	// ChangeListener used to detect when a slider is moved
		colorDisplay.setBackground(new Color(red.getValue(),green.getValue(),blue.getValue()));
		redLabel.setText(Integer.toString(red.getValue()));
		greenLabel.setText(Integer.toString(green.getValue()));
		blueLabel.setText(Integer.toString(blue.getValue()));
	}
	
	public static void main(String[] args) {
	// instantiate a colorSlider object to play around with
		ColorSlider colorSlider = new ColorSlider("Color Selector");
		colorSlider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
