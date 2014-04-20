package pizza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class PizzaOrderGUI extends JFrame{
	private Pizza myPizza;
	
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
		JPanel toppingsPanel = new ToppingsPanel();
				
		add(customerPanel);
		add(sizePanel);
		add(toppingsPanel);
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(580,600);
	    setLocationRelativeTo(null); // Center the frame
		setResizable(false);
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

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private double calculatePrice(){
		double price = 0;
		return price;
	}
	
	public static void main(String[] args){
		PizzaOrderGUI pizzaOrder = new PizzaOrderGUI();
	}
}
