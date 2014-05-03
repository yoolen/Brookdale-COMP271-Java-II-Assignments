package db;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
//
// A simple user interface that consists of radio buttons for the type of ice cream
// and check boxes for the toppings for the ice cream
//
public class IceCream extends JFrame

{
  private JRadioButton vanilla, choc, straw;
  private JTextField order;
  private ButtonGroup flavors;
 
  private JCheckBox whip, cherry, mms;
  private String icecream_picked = "Vanilla ";
  private String toppings_picked = "";
  private JButton submit;
  private JTextField phone;
public IceCream()
{  
    super("Ice Cream");
    
    setLayout(new FlowLayout());

    Color dark = new Color(63,29,10);          // brownish
    order = new JTextField("Vanilla ",20);  // to match default flavor
    order.setEditable(false); // The user can not populate

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

// a handler for the flavors
	FlavorHandler fh = new FlavorHandler();
    vanilla.addActionListener(fh);
    choc.addActionListener(fh);
    straw.addActionListener(fh);
    
  // Now do the toppings as check boxes, since we can pick more than one
    
    whip = new JCheckBox("Whipped Cream");  
    cherry = new JCheckBox("Cherry");  
    mms = new JCheckBox("M&Ms");    

// Now place the stuff on the screen

    add(vanilla); // the radio buttons
    add(choc);
    add(straw);
    add(order); // a text box to display the results

JPanel topps_panel = new JPanel();
topps_panel.setLayout( new GridLayout(1,3));
topps_panel.setBorder( new TitledBorder("Toppings"));
   
	topps_panel.add(whip);
   topps_panel.add(whip); // the check boxes
   topps_panel.add(cherry);
   topps_panel.add(mms);
	add( topps_panel);
    
	phone = new JTextField(10);
	submit = new JButton("Place Order");
	add(new JLabel("Phone"));
	add(phone);
	add(submit);

	OrderHandler oh = new OrderHandler();
	submit.addActionListener(oh);

	ToppingHandler th = new ToppingHandler();
    whip.addItemListener(th);
    cherry.addItemListener(th);
    mms.addItemListener(th);

    setSize(375, 175);
    setVisible(true);
  }


  public static void main(String args[])
  {
    IceCream ic = new IceCream();
 
    ic.addWindowListener(
       new WindowAdapter(){
          public void windowClosing(WindowEvent e)
          {
             System.exit(0);
          }
       } );
   }
   // To handle the flavors
class FlavorHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == vanilla ||
			e.getSource() == choc ||
			e.getSource() == straw)
		{
			icecream_picked = e.getActionCommand();
			order.setText(icecream_picked + toppings_picked);
		
		}	 
	}
} 
// To handle the toppings
class ToppingHandler implements  ItemListener
{
	public void itemStateChanged(ItemEvent e)
	{
		toppings_picked = "";
		if (whip.isSelected())
			toppings_picked += " Whipped cream ";
		if (cherry.isSelected())
			toppings_picked += " Cherry ";
		if (mms.isSelected())
			toppings_picked += " M&Ms ";
		order.setText(icecream_picked + toppings_picked);
	}
}
// To place the order on the data base
class OrderHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		// validate phone number
		String phone_number = phone.getText();
		if (!phone_number.matches("[0-9]{10}") )
		{
			// invalid phone number
			JOptionPane.showMessageDialog(null, "Invalid phone number, need 10 digits", "Error on Phone number",
				JOptionPane.ERROR_MESSAGE);
				return;
		}
		Date now = new Date();			
	try
	{
		// insert into db
		 Class.forName("com.mysql.jdbc.Driver");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver loaded");

		// Establish a connection

		Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost/project", "root", "");

		System.out.println("Database connected");

		// Create a statement
		Statement stmt = connection.createStatement();
		// Build a SQL INSERT statement
		String insertStmt =
		 "INSERT INTO iceorder(ordertime, flavor, toppings, phone) VALUES('" +
		now.toString() + "','" +
		icecream_picked + "','" +
		toppings_picked + "','" +  		
		 phone_number + "');";    

		stmt.executeUpdate(insertStmt);
		// Close the connection
		 connection.close();

	// display confirmation box
		JOptionPane.showMessageDialog(null, "Ice Cream order received", "Ice Cream",
				JOptionPane.INFORMATION_MESSAGE);

	}
	catch (ClassNotFoundException ex)
	{
		JOptionPane.showMessageDialog(null, "Class not found", "Error inserting order",
				JOptionPane.ERROR_MESSAGE);
	}
	catch (SQLException ex)
	{
		JOptionPane.showMessageDialog(null, "SQL exception", "Error inserting order",
				JOptionPane.ERROR_MESSAGE);
	}
		


		
		
	 
	}
} 
}