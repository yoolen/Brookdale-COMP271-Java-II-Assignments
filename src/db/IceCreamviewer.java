package db;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

//
// A simple user interface to display ice cream orders from a database
//
public class IceCreamviewer extends JFrame
{
  
  private JTextArea orders;  
  private JButton submit, clear;
 
public IceCreamviewer()
{  
    super("Ice Cream");
    
    setLayout(new BorderLayout());   

	JPanel mid_panel = new JPanel();
	orders = new JTextArea(8, 50);
	orders.setEditable(false);
	mid_panel.add( new JScrollPane (orders) );
	mid_panel.setBorder( new TitledBorder("Orders received"));   
	
	add( mid_panel, BorderLayout.CENTER); 
	
	JPanel bot_panel = new JPanel();
	submit = new JButton("View Orders");
	clear = new JButton("Clear Orders");
	bot_panel.add( submit );
	bot_panel.add( clear );
	add(bot_panel,BorderLayout.SOUTH);

	OrderHandler oh = new OrderHandler();
	ClearHandler ch = new ClearHandler();
	submit.addActionListener(oh);
	clear.addActionListener(ch);
	
    setSize(595, 295);
    setVisible(true);
  }


  public static void main(String args[])
  {
    IceCreamviewer ic = new IceCreamviewer();
 
    ic.addWindowListener(
       new WindowAdapter(){
          public void windowClosing(WindowEvent e)
          {
             System.exit(0);
          }
       } );
   }
 

// To view the orders on the data base
class OrderHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
				
	try
	{
		// query db
		 Class.forName("com.mysql.jdbc.Driver");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		System.out.println("Driver loaded");

		// Establish a connection

		Connection connection = DriverManager.getConnection
			("jdbc:mysql://localhost/project", "root", "");

		System.out.println("Database connected");

		// Create a statement
		Statement stmt = connection.createStatement();
		  // Execute a statement
    ResultSet resultSet = stmt.executeQuery
      ("select ordertime, flavor, toppings, phone from iceorder ");

    // Iterate through the result and display the orders
    while (resultSet.next())
		{
      orders.append(resultSet.getString(1) + " " +
        resultSet.getString(2) + " " + resultSet.getString(3) +
		" " + resultSet.getString(4) + "\n");
		}

		// Close the connection
		 connection.close();
	

	}
	catch (ClassNotFoundException ex)
	{
		JOptionPane.showMessageDialog(null, "Class not found", "Error viewing order",
				JOptionPane.ERROR_MESSAGE);
	}
	catch (SQLException ex)
	{
		JOptionPane.showMessageDialog(null, "SQL exception", "Error viewing order",
				JOptionPane.ERROR_MESSAGE);
	}
				
	 
	}
}

class ClearHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
				
		orders.setText("");				
	 
	}
} 

}