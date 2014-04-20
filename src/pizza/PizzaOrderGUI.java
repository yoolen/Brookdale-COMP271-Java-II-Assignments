package pizza;

import java.awt.*;

import javax.swing.*;

public class PizzaOrderGUI extends JFrame{
	public PizzaOrderGUI(){
		setLayout(new FlowLayout());
		setSize(new Dimension(500,500));
		
		add(new CustomerInfoPanel());
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		PizzaOrderGUI pizzaOrder = new PizzaOrderGUI();
	}
}

class CustomerInfoPanel extends JPanel{
	public CustomerInfoPanel(){
		setBorder(BorderFactory.createTitledBorder("Customer Info"));
		setLayout(new GridLayout(5,1));
		add(new LabeledField("Name"));
		add(new LabeledField("Address"));
		add(new CSTField());
		add(new LabeledField("Phone Number"));
		add(new DeliveryField());
	}
	
	class LabeledField extends JPanel{
		public LabeledField(String fieldName){
			setLayout(new FlowLayout());
			add(new JLabel(fieldName));
			add(new JTextField(10));
		}
	}
	
	class CSTField extends JPanel{
		public CSTField(){
			setLayout(new FlowLayout());
			add(new LabeledField("City"));
			add(new LabeledField("State"));
			add(new LabeledField("Zip Code"));
		}
	}
	
	class DeliveryField extends JPanel{
		public DeliveryField(){
			setLayout(new FlowLayout());
			JRadioButton delivery = new JRadioButton("Delivery");
			JRadioButton pickup = new JRadioButton("Pickup");
			ButtonGroup group = new ButtonGroup(); 
			// Create a grouping of buttons to auto-deselect
			group.add(delivery);
			group.add(pickup);
			add(delivery);
			add(pickup);
		}
	}
}