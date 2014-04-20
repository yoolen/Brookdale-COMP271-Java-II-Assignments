package classwork.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;

//
// A simple user interface that consists of radio buttons for the type of ice cream
// and check boxes for the toppings for the ice cream
//
public class IceCream extends JApplet implements ActionListener, ItemListener{ // used to Extend JFrame
	private JRadioButton vanilla, choc, straw;
	private JTextField order;
	private ButtonGroup flavors;
	private JLabel tops;
	private JCheckBox whip, cherry, mms;
	private String icecream_picked = "Vanilla ";
	private String toppings_picked = "";

	public IceCream(){
	//   super("Ice Cream"); // only worked for JFrame
    
		setLayout(new FlowLayout());
		Color dark = new Color(63,29,10);          // brownish
		order = new JTextField("Vanilla ",20);  // to match default flavor
		order.setEditable(false); // The user can not populate

		URL urlForImage = getClass().getResource("icecream.jpg"); // These files go into the bin folder
		add(new JLabel(new ImageIcon(urlForImage)));

		//URL urlForAudio = getClass().getResource("scream.aiff");
		//AudioClip audioClip = Applet.newAudioClip(urlForAudio);
		//audioClip.play();

		// Do the flavors as radio buttons since we can pick only one
		vanilla = new JRadioButton("Vanilla", true);
		vanilla.setForeground(Color.white);
		vanilla.setBackground(Color.black);
    
		choc = new JRadioButton("Chocolate", false);
		choc.setForeground(dark);
   
		straw = new JRadioButton("Strawberry", false);
		straw.setForeground(Color.red);
     
		flavors = new ButtonGroup();
		flavors.add(vanilla);
		flavors.add(choc);
		flavors.add(straw);
    
		// add ActionListeners
		vanilla.addActionListener(this); // These are actions because you are
		choc.addActionListener(this);    // you make a selection in the radio buttons
		straw.addActionListener(this);   // so it is action driven
    
		// Now do the toppings as check boxes, since we can pick more than one
		tops = new JLabel("Toppings");
		whip = new JCheckBox("Whipped Cream");
  		cherry = new JCheckBox("Cherry");
  		mms = new JCheckBox("M&Ms");
    
  		// Now place the stuff on the screen

  		add(vanilla); // the radio buttons
  		add(choc);
  		add(straw);
  		add(order); // a text box to display the results
  		add(tops); // a label
  		add(whip); // the check boxes
  		add(cherry);
  		add(mms);
  		whip.addItemListener(this);   // We use ItemListeners here because we are
  		cherry.addItemListener(this); // looking at the state of each checkbox
  		mms.addItemListener(this);    // rather than the action of checking or unchecking
  		// setSize(275, 150); // work for JFrame
  		//  setVisible(true); // unnecessary for JApplet
	}
	
	public void itemStateChanged(ItemEvent e){
	// ItemListener used to see if state of an item changes.
		toppings_picked = "";
		if (whip.isSelected())
			toppings_picked += " Whipped cream ";
		if (cherry.isSelected())
			toppings_picked += " Cherry ";
		if (mms.isSelected())
			toppings_picked += " M&Ms ";
		order.setText(icecream_picked + toppings_picked);
	}

	public void actionPerformed(ActionEvent e){
	// ActionListener used when we switch from one flavor to another
		if (e.getSource() == vanilla ||	e.getSource() == choc || e.getSource() == straw){
			icecream_picked = e.getActionCommand();
			order.setText(icecream_picked + toppings_picked);
			/*mms.setSelected(false);
			cherry.setSelected(false);
			whip.setSelected(false); */
		}
	}
	
	public void init(){
		//JFrame iceframe = new JFrame("Ice Cream");
		//IceCream ic = new IceCream(); // JApplet
		// adding the JApplet to the JFrame
		/*iceframe.add( ic ); 
		iceframe.setSize(275, 150); // work for JFrame
		iceframe.setVisible(true);

		iceframe.addWindowListener(new WindowAdapter(){ // was ic
			public void windowClosing(WindowEvent e){
				System.exit(0); } 
		} );*/
	} 
}
