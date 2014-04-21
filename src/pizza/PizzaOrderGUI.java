package pizza;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class PizzaOrderGUI extends JFrame{
	private Pizza myPizza;
	private JPanel toppingsPanel;
	protected JPanel detailsPanel;
	
	public PizzaOrderGUI(){
		setTitle("Terry's Pizza Ordering System");
		setLayout(new FlowLayout());
				
		// Title Panel
		add(new JLabel(new ImageIcon(this.getClass().getResource("Banner.jpg"))));

		// Size Panel
		JPanel sizePanel = new SizePanel();
		
		// Details Panel
		detailsPanel = new DetailsPanel();
		
		// Customer Panel
		JPanel customerPanel = new JPanel();
		java.net.URL url = this.getClass().getResource("pizza.png");
		Image image = new ImageIcon(url).getImage();
		customerPanel.add(new JLabel(new ImageIcon(image)));
		CustomerInfo customerInfo = new CustomerInfo();
		customerPanel.add(customerInfo);
		customerPanel.setBorder(BorderFactory.createEmptyBorder());
		
		// Toppings Panel
		toppingsPanel = new ToppingsPanel();
		toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings ($0.75 each)"));
		// initialized to synchronize with the default Large pizza size!
				
		// Choice Panel
		JPanel choicePanel = new JPanel(new BorderLayout());
		choicePanel.add(sizePanel,BorderLayout.WEST);
		choicePanel.add(toppingsPanel,BorderLayout.CENTER);
		
		// Build the Final GUI
		add(customerPanel);
		add(choicePanel);
		add(detailsPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(580,680); // Need to set the size before centering
	    setLocationRelativeTo(null); // Center the frame
		setResizable(false); // prevent the user from resizing the window
		setVisible(true);
	}
	
	private class CustomerInfo extends JPanel implements ActionListener{
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;

		// This Panel generated using WindowBuilder
		public CustomerInfo() {
			setBorder(BorderFactory.createTitledBorder("Customer Info"));
			
			ButtonGroup group = new ButtonGroup();
			JLabel lblName = new JLabel("Name");
			
			textField = new JTextField();
			textField.setColumns(10);
			
			JLabel lblStreeAddress = new JLabel("Street Address");
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			
			JLabel lblCity = new JLabel("City");
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			
			JLabel lblState = new JLabel("State");
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			
			JLabel lblZipCode = new JLabel("Zip Code");
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			
			JRadioButton rdbtnDelivery = new JRadioButton("Delivery");
			rdbtnDelivery.addActionListener(this);		
			group.add(rdbtnDelivery);
			
			JRadioButton rdbtnPickup = new JRadioButton("Pickup");
			rdbtnPickup.addActionListener(this);
			group.add(rdbtnPickup);
			rdbtnPickup.setSelected(true);
			
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblName)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblStreeAddress)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblCity)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblState)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblZipCode)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblPhoneNumber)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(rdbtnDelivery)
										.addGap(18)
										.addComponent(rdbtnPickup)
										.addContainerGap())
									.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblName)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblStreeAddress))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblState)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblZipCode)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCity)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPhoneNumber))
						.addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnDelivery)
							.addComponent(rdbtnPickup)))
			);
			setLayout(groupLayout);
		}

		@Override
		public void actionPerformed(ActionEvent ie) {
			switch(ie.getActionCommand()){
				case "Delivery":
					((DetailsPanel)detailsPanel).delivery.setText(String.format("%.2f",Pizza.DELIVERY_CHARGE));
					break;
				case "Pickup":
					((DetailsPanel)detailsPanel).delivery.setText("0.00");
					break;
				default:
			}
		}
	}
	
	private class SizePanel extends JPanel implements ActionListener{
	// Panel for selecting the size of the pizza. Selecting a size will instantiate
	// a pizza of that size.
		private JRadioButton rdbtnSmall;
		private JRadioButton rdbtnMedium;
		private JRadioButton rdbtnLarge;
		private JRadioButton rdbtnXLarge;
			
		public SizePanel(){
			// basic formatting
			setLayout(new GridLayout(5,1));
			setBorder(BorderFactory.createTitledBorder("Size"));
			
			// instantiate buttons
			rdbtnSmall = new JRadioButton("Small");
			rdbtnMedium = new JRadioButton("Medium");
			rdbtnLarge = new JRadioButton("Large");
			rdbtnXLarge = new JRadioButton("X-Large");
			
			// add mnemonics
			rdbtnSmall.setMnemonic(KeyEvent.VK_S);
			rdbtnMedium.setMnemonic(KeyEvent.VK_M);
			rdbtnLarge.setMnemonic(KeyEvent.VK_L);
			rdbtnXLarge.setMnemonic(KeyEvent.VK_X);
			
			// register listeners
			rdbtnSmall.addActionListener(this);
			rdbtnMedium.addActionListener(this);
			rdbtnLarge.addActionListener(this);
			rdbtnXLarge.addActionListener(this);
			
			// group radio buttons
			ButtonGroup group = new ButtonGroup();
			group.add(rdbtnSmall);
			group.add(rdbtnMedium);
			group.add(rdbtnLarge);
			group.add(rdbtnXLarge);
			
			// place radio buttons
			add(rdbtnSmall);
			add(rdbtnMedium);
			add(rdbtnLarge);
			add(rdbtnXLarge);
			
			// initializations
			rdbtnLarge.setSelected(true); // Initialize to large pie!
			myPizza = new LargePizza(); // Instantiate a large pie!			
		}
		
		@Override
		public void actionPerformed(ActionEvent ae){
		// Case statement used to instantiate a Pizza of the correct size.
		// Further modify the border of the toppings to reflect price changes.
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
			((ToppingsPanel)toppingsPanel).reset();	// Changing pizza sizes resets all selections.
			((DetailsPanel)detailsPanel).price.setText(String.format("%.2f",myPizza.getCost())); // update the price of the cost calculator
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
			
			// Initialize checkboxes and set names
			anchovies = new JCheckBox("Anchovies");
			anchovies.setName("Anchovies");
			bacon = new JCheckBox("Bacon");
			bacon.setName("Bacon");
			ham = new JCheckBox("Ham");
			ham.setName("Ham");
			pepperoni = new JCheckBox("Pepperoni");
			pepperoni.setName("Pepperoni");
			sausage = new JCheckBox("Sausage");
			sausage.setName("Sausage");
			bellPeppers = new JCheckBox("Bell Peppers");
			bellPeppers.setName("Bell Peppers");
			onions = new JCheckBox("Onions");
			onions.setName("Onions");
			eggplant = new JCheckBox("Eggplant");
			eggplant.setName("Eggplant");
			garlic = new JCheckBox("Garlic");
			garlic.setName("Garlic");
			mushrooms = new JCheckBox("Mushrooms");
			mushrooms.setName("Mushrooms");
			spinach = new JCheckBox("Spinach");
			spinach.setName("Spinach");
			olives = new JCheckBox("Olives");
			olives.setName("Olives");
			pineapple = new JCheckBox("Pineapple");
			pineapple.setName("Pineapple");
			xCheese = new JCheckBox("Extra Cheese");
			xCheese.setName("Extra Cheese");
						
			// add listeners
			anchovies.addItemListener(this);
			bacon.addItemListener(this);
			ham.addItemListener(this);
			pepperoni.addItemListener(this);
			sausage.addItemListener(this);
			bellPeppers.addItemListener(this);
			onions.addItemListener(this);
			eggplant.addItemListener(this);
			garlic.addItemListener(this);
			mushrooms.addItemListener(this);
			spinach.addItemListener(this);
			olives.addItemListener(this);
			pineapple.addItemListener(this);
			xCheese.addItemListener(this);
			
			// Format the panels
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
			((DetailsPanel)detailsPanel).price.setText(String.format("%.2f",myPizza.getCost())); // update the price of the cost calculator
		}
	}
	
	private class DetailsPanel extends JPanel implements DocumentListener, ActionListener{// implements DocumentListener{
	// Uses DocumentListener to check for when the cost of the pie is updated
	// by changing size, choosing delivery, or adding toppings. This panel formatted
	// using WindowBuilder
		JTextField price;
		JTextField delivery;
		JTextField total;

		public DetailsPanel(){	
			setBorder(BorderFactory.createTitledBorder("Summary"));
		
			// Instantiate JTextFields
			price = new JTextField(10);
			delivery = new JTextField(10);
			total = new JTextField(10);
			
			// set defaults
			price.setText(String.format("%.2f", myPizza.getCost())); // default to large pizza
			delivery.setText("0.00"); //default is pickup so no cost
			total.setText(String.format("%.2f", myPizza.getCost())); // default is pickup so just pizza cost
			
			// register listeners
			delivery.getDocument().addDocumentListener(this);
			price.getDocument().addDocumentListener(this);
		
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{14, 86, 8, 86, 8, 86, 0, 0};
			gridBagLayout.rowHeights = new int[]{14, 20, 0, 23, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel lblPrice = new JLabel("Price");
			GridBagConstraints gbc_lblPrice = new GridBagConstraints();
			gbc_lblPrice.anchor = GridBagConstraints.NORTH;
			gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrice.gridx = 1;
			gbc_lblPrice.gridy = 0;
			add(lblPrice, gbc_lblPrice);
			
			JLabel lblDeliveryFee = new JLabel("Delivery Fee");
			GridBagConstraints gbc_lblDeliveryFee = new GridBagConstraints();
			gbc_lblDeliveryFee.anchor = GridBagConstraints.NORTH;
			gbc_lblDeliveryFee.insets = new Insets(0, 0, 5, 5);
			gbc_lblDeliveryFee.gridx = 3;
			gbc_lblDeliveryFee.gridy = 0;
			add(lblDeliveryFee, gbc_lblDeliveryFee);
			
			JLabel lblTotal = new JLabel("Total");
			GridBagConstraints gbc_lblTotal = new GridBagConstraints();
			gbc_lblTotal.anchor = GridBagConstraints.NORTH;
			gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
			gbc_lblTotal.gridx = 5;
			gbc_lblTotal.gridy = 0;
			add(lblTotal, gbc_lblTotal);
			
			GridBagConstraints gbc_price = new GridBagConstraints();
			gbc_price.insets = new Insets(0, 0, 5, 5);
			gbc_price.fill = GridBagConstraints.HORIZONTAL;
			gbc_price.gridx = 1;
			gbc_price.gridy = 1;
			add(price, gbc_price);
							
			JLabel label = new JLabel("+");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 2;
			gbc_label.gridy = 1;
			add(label, gbc_label);
				
			GridBagConstraints gbc_delivery = new GridBagConstraints();
			gbc_delivery.insets = new Insets(0, 0, 5, 5);
			gbc_delivery.fill = GridBagConstraints.HORIZONTAL;
			gbc_delivery.gridx = 3;
			gbc_delivery.gridy = 1;
			add(delivery, gbc_delivery);
						
			JLabel label_1 = new JLabel("=");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.EAST;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 4;
			gbc_label_1.gridy = 1;
			add(label_1, gbc_label_1);
				
			GridBagConstraints gbc_total = new GridBagConstraints();
			gbc_total.insets = new Insets(0, 0, 5, 5);
			gbc_total.fill = GridBagConstraints.HORIZONTAL;
			gbc_total.gridx = 5;
			gbc_total.gridy = 1;
			add(total, gbc_total);
							
			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
			gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut_1.gridx = 6;
			gbc_horizontalStrut_1.gridy = 2;
			add(horizontalStrut_1, gbc_horizontalStrut_1);
				
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 0;
			gbc_horizontalStrut.gridy = 3;
			add(horizontalStrut, gbc_horizontalStrut);
				
			JButton btnSubmitOrder = new JButton("Submit Order");
			btnSubmitOrder.addActionListener(this);
			GridBagConstraints gbc_btnSubmitOrder = new GridBagConstraints();
			gbc_btnSubmitOrder.gridwidth = 2;
			gbc_btnSubmitOrder.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnSubmitOrder.gridx = 4;
			gbc_btnSubmitOrder.gridy = 4;
			add(btnSubmitOrder, gbc_btnSubmitOrder);

		}

		// DocumentListener methods (only need insertUpdate)
		@Override
		public void insertUpdate(DocumentEvent de) {
			total.setText(String.format("%.2f",	Double.parseDouble(price.getText()) + Double.parseDouble(delivery.getText())));
		}
		@Override
		public void changedUpdate(DocumentEvent de) {};
		@Override
		public void removeUpdate(DocumentEvent de) {}
		
		// ActionListener for the submit button
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame summary = new SummaryFrame();	
		}
	}
	
	class SummaryFrame extends JFrame{
		public SummaryFrame(){
			super("Order Summary");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(100,100); // Need to set the size before centering
			setLocationRelativeTo(null); // Center the frame
			setResizable(false); // prevent the user from resizing the window
			setVisible(true);
		}
	}
	
	public static void main(String[] args){
		PizzaOrderGUI pizzaOrder = new PizzaOrderGUI();
	}
}
