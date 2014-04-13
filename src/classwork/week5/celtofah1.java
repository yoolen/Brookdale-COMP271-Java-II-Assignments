package classwork.week5;

// Simple application to convert Celsius to Fahrenheit

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;

public class celtofah1 extends JFrame
	implements ChangeListener

 {
	private JSlider jsldHort; 
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
		jsldHort = new JSlider(JSlider.HORIZONTAL,-10,110,0);
         // Set properties for sliders
    //jsldHort.setMaximum(110);
    jsldHort.setPaintLabels(true);
    jsldHort.setPaintTicks(true);
    jsldHort.setMajorTickSpacing(20);
    jsldHort.setMinorTickSpacing(5);
    jsldHort.setPaintTrack(false);       
		ans = new JTextField(10);
        ans.setEditable(false);

		pn1.add(lab_cel);
		pn1.add(jsldHort);
        pn2.add(ans);

		jsldHort.addChangeListener(this);

		add(pn1,BorderLayout.NORTH);
		add(pn2,BorderLayout.SOUTH);
  			
		setSize(450,150);
		setVisible(true);
}
	public void stateChanged(ChangeEvent e)
	{
		   DecimalFormat twodig = new DecimalFormat("0.0");
           double cel =  jsldHort.getValue() ;
           double fah = 9.0/5 * cel + 32;
		   if (fah < 35)
		   	   ans.setForeground(Color.blue);
		   else if (fah > 85)
		   	  ans.setForeground(Color.red);
		   else
			   ans.setForeground(Color.black);
			
            ans.setText(twodig.format(fah) + " fahrenheit");
        
	}

	public static void main( String args[])
	{
		celtofah1 app = new celtofah1();

		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
