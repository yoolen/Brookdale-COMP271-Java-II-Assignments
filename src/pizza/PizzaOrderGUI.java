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
		add(new JLabel(new ImageIcon(this.getClass().getResource("Banner.jpg"))));
		
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
		toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings ($0.75 each)"));
		// initialized to synchronize with the default Large pizza size!
				
		// Choice Panel
		JPanel choicePanel = new JPanel();
		choicePanel.add(sizePanel);
		choicePanel.add(toppingsPanel);
		
		// Build the Final GUI
		add(customerPanel);
		add(choicePanel);		
		
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
			setLayout(new GridLayout(5,1));
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
			rdbtnLarge.setSelected(true); // Initialize to large pie!
			myPizza = new LargePizza(); // Instantiate a large pie!			
		}
		
		@Override
		public void actionPerformed(ActionEvent ae){
		// Case statement used to instantiate a Pizza of the correct size.
		switch(ae.getActionCommand()){
			case "Small":
				myPizza = new SmallPizza();
				toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings ($0.25 each)"));
				break;
			case "Medium":
				myPizza = new MediumPizza();
				toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings ($0.50 each)"));
				break;
			case "Large":
				myPizza = new LargePizza();
				toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings ($0.75 each)"));
				break;
			case "X-Large":
				myPizza = new XLargePizza();
				toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings ($1.00 each)"));
				break;
			default:
		}
		System.out.println(myPizza);
		((ToppingsPanel)toppingsPanel).reset();
		// Changing pizza sizes resets all selections.
	}
}
	
	private class ToppingsPanel extends JPanel implements ItemListener{
		private JCheckBox anchovies;
		private JCheckBox bacon;
		private JCheckBox ham;
		private JCheckBox pepperoni;
		private JCheckBox sausage;
		private JCheckBox bellPeppers;
		private JCheckBox onions;
		private JCheckBox eggplant;
		private JCheckBox garlic;
		private JCheckBox mushrooms;
		private JCheckBox spinach;
		private JCheckBox olives;
		private JCheckBox pineapple;
		private JCheckBox xCheese;
		
		public ToppingsPanel(){
			JPanel toppingsPanel = new JPanel();
			
			// Initialize checkboxes and attach listeners
			anchovies = new JCheckBox("Anchovies");
			anchovies.setName("Anchovies");
			anchovies.addItemListener(this);
			bacon = new JCheckBox("Bacon");
			bacon.setName("Bacon");
			bacon.addItemListener(this);
			ham = new JCheckBox("Ham");
			ham.setName("Ham");
			ham.addItemListener(this);
			pepperoni = new JCheckBox("Pepperoni");
			pepperoni.setName("Pepperoni");
			pepperoni.addItemListener(this);
			sausage = new JCheckBox("Sausage");
			sausage.setName("Sausage");
			sausage.addItemListener(this);
			bellPeppers = new JCheckBox("Bell Peppers");
			bellPeppers.setName("Bell Peppers");
			bellPeppers.addItemListener(this);
			onions = new JCheckBox("Onions");
			onions.setName("Onions");
			onions.addItemListener(this);
			eggplant = new JCheckBox("Eggplant");
			eggplant.setName("Eggplant");
			eggplant.addItemListener(this);
			garlic = new JCheckBox("Garlic");
			garlic.setName("Garlic");
			garlic.addItemListener(this);
			mushrooms = new JCheckBox("Mushrooms");
			mushrooms.setName("Mushrooms");
			mushrooms.addItemListener(this);
			spinach = new JCheckBox("Spinach");
			spinach.setName("Spinach");
			spinach.addItemListener(this);
			olives = new JCheckBox("Olives");
			olives.setName("Olives");
			olives.addItemListener(this);
			pineapple = new JCheckBox("Pineapple");
			pineapple.setName("Pineapple");
			pineapple.addItemListener(this);
			xCheese = new JCheckBox("Extra Cheese");
			xCheese.setName("Extra Cheese");
			xCheese.addItemListener(this);
			
			// Meats
			JPanel meat = new JPanel(new GridLayout(5,1));
			meat.setBorder(BorderFactory.createTitledBorder("Meat"));
			meat.add(anchovies);
			meat.add(bacon);
			meat.add(ham);
			meat.add(pepperoni);
			meat.add(sausage);
			
			// Vegetables
			JPanel veg = new JPanel(new GridLayout(5,2));
			veg.setBorder(BorderFactory.createTitledBorder("Vegetables"));
			veg.add(bellPeppers);
			veg.add(spinach);
			veg.add(onions);
			veg.add(eggplant);
			veg.add(olives);
			veg.add(pineapple);
			veg.add(garlic);
			veg.add(mushrooms);
			veg.add(xCheese);

			// Add both subpanels into the toppings panel
			toppingsPanel.add(meat);
			toppingsPanel.add(veg);
			add(toppingsPanel);
		}
		
 		public void reset(){
		// Reset all selections
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
			spinach.setSelected(false);
			olives.setSelected(false);
			pineapple.setSelected(false);
			xCheese.setSelected(false);
		}

		@Override
		public void itemStateChanged(ItemEvent ie) {
		// Each time a topping is added or removed from the pizza
		// we use the built in methods from Pizza to change the list
		// of toppings and change the price!
			if(ie.getStateChange()==1){
				myPizza.addTopping(((Component)ie.getSource()).getName());
			}
			else{//(ie.getStateChange()==0){
				myPizza.removeTopping(((Component)ie.getSource()).getName());
			}
		}
	}
	
	private double checkout(){
	// Uses Pizza's getPrice method and checks if user wants delivery
		double price = 0;
		return price;
	}
	
	public static void main(String[] args){
		PizzaOrderGUI pizzaOrder = new PizzaOrderGUI();
	}
}
