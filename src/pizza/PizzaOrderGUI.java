package pizza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class PizzaOrderGUI extends JFrame{
	private Pizza myPizza;
	private JPanel toppingsPanel;
	
	public PizzaOrderGUI(){
		setTitle("Terry's Pizza Ordering System");
		setLayout(new FlowLayout());
				
		// Title Panel
		
		// Customer Panel
		JPanel customerPanel = new JPanel();
		java.net.URL url = this.getClass().getResource("pizza.png");
		Image image = new ImageIcon(url).getImage();
		customerPanel.add(new JLabel(new ImageIcon(image)));
		CustomerInfo customerInfo = new CustomerInfo();
		customerPanel.add(customerInfo);
		
		// Size Panel
		JPanel sizePanel = new SizePanel();
		
		// Toppings Panel
		toppingsPanel = new ToppingsPanel();
				
		add(customerPanel);
		add(sizePanel);
		add(toppingsPanel);
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(580,600); // Need to set the size before centering
	    setLocationRelativeTo(null); // Center the frame
		setResizable(false); // prevent the user from resizing the window
		setVisible(true);

	}
	
	private class SizePanel extends JPanel implements ActionListener{
	// Panel for selecting the size of the pizza. Selecting a size will instantiate
	// a pizza of that size.
		private JRadioButton rdbtnSmall = new JRadioButton("Small");
		private JRadioButton rdbtnMedium = new JRadioButton("Medium");
		private JRadioButton rdbtnLarge = new JRadioButton("Large");
		private JRadioButton rdbtnXLarge = new JRadioButton("X-Large");
			
		public SizePanel(){
			rdbtnSmall = new JRadioButton("Small");
			rdbtnSmall.setMnemonic(KeyEvent.VK_S);
			rdbtnSmall.addActionListener(this);
			
			rdbtnMedium = new JRadioButton("Medium");
			rdbtnMedium.setMnemonic(KeyEvent.VK_M);
			rdbtnMedium.addActionListener(this);
			
			rdbtnLarge = new JRadioButton("Large");
			rdbtnLarge.setMnemonic(KeyEvent.VK_L);
			rdbtnLarge.addActionListener(this);
			
			rdbtnXLarge = new JRadioButton("X-Large");
			rdbtnXLarge.setMnemonic(KeyEvent.VK_X);
			rdbtnXLarge.addActionListener(this);
			
			setBorder(BorderFactory.createTitledBorder("Size"));
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnSmall);
			group.add(rdbtnMedium);
			group.add(rdbtnLarge);
			group.add(rdbtnXLarge);
			add(rdbtnSmall);
			add(rdbtnMedium);
			add(rdbtnLarge);
			add(rdbtnXLarge);
		}
		
		@Override
		public void actionPerformed(ActionEvent ae){
		// Case statement used to instantiate a Pizza of the correct size.
		switch(ae.getActionCommand()){
			case "Small":
				myPizza = new SmallPizza();
				break;
			case "Medium":
				myPizza = new MediumPizza();
				break;
			case "Large":
				myPizza = new LargePizza();
				break;
			case "XLarge":
				myPizza = new XLargePizza();
				break;
			default:
		}
		((ToppingsPanel)toppingsPanel).reset();
		// Changing pizza sizes resets all selections.
	}
}
	
	private class ToppingsPanel extends JPanel implements ItemListener{
		private JCheckBox anchovies = new JCheckBox("Anchovies");
		private JCheckBox bacon = new JCheckBox("Bacon");
		private JCheckBox ham = new JCheckBox("Ham");
		private JCheckBox pepperoni = new JCheckBox("Pepperoni");
		private JCheckBox sausage = new JCheckBox("Sausage");
		private JCheckBox bellPeppers = new JCheckBox("Bell Peppers");
		private JCheckBox onions = new JCheckBox("Onions");
		private JCheckBox eggplant = new JCheckBox("Eggplant");
		private JCheckBox garlic = new JCheckBox("Garlic");
		private JCheckBox mushrooms = new JCheckBox("Mushrooms");
		private JCheckBox spinach = new JCheckBox("Spinach");
		private JCheckBox olives = new JCheckBox("Olives");
		private JCheckBox pineapple = new JCheckBox("Pineapple");
		private JCheckBox xCheese = new JCheckBox("Extra Cheese");
		
		public ToppingsPanel(){
			JPanel toppingPanel = new JPanel(new GridLayout(1,3));
			
			JPanel meat = new JPanel(new GridLayout(5,1));
			meat.setBorder(BorderFactory.createTitledBorder("Meat"));
			meat.add(anchovies);
			meat.add(bacon);
			meat.add(ham);
			meat.add(pepperoni);
			meat.add(sausage);
			
			JPanel veg = new JPanel();
			veg.setBorder(BorderFactory.createTitledBorder("Vegetables"));
			
			JPanel veg1 = new JPanel(new GridLayout(5,1));
			veg1.add(bellPeppers);
			veg1.add(spinach);
			veg1.add(onions);
			veg1.add(eggplant);
			veg1.add(olives);
			
			JPanel veg2 = new JPanel(new GridLayout(5,1));
			veg2.add(pineapple);
			veg2.add(garlic);
			veg2.add(mushrooms);
			veg2.add(xCheese);

			veg.add(veg1);
			veg.add(veg2);
			
			add(meat);
			add(veg);
		}
		
		public void reset(){
			anchovies.setSelected(false);
			bacon.setSelected(false);
			ham.setSelected(false);
			pepperoni.setSelected(false);
			sausage.setSelected(false);
			bellPeppers.setSelected(false);
			onions.setSelected(false);
			eggplant.setSelected(false);
			garlic.setSelected(false);
			mushrooms.setSelected(false);
			olives.setSelected(false);
			pineapple.setSelected(false);
			xCheese.setSelected(false);
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			
			
		}
		
	}
	
	private double calculatePrice(){
	// Uses Pizza's getPrice method and checks if user wants delivery
		double price = 0;
		return price;
	}
	
	public static void main(String[] args){
		PizzaOrderGUI pizzaOrder = new PizzaOrderGUI();
	}
}
