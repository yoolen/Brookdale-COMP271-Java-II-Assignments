package classwork.week8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
//
// Another user interface for IceCream. Now there is a combo box for the flavors
// and a list box to select the toppings
//
public class IceCream2 extends JFrame 
implements ActionListener
{
  private JComboBox flavors;
  private JTextField ms;
  private JLabel tops;
  private JList toppings;
  private String toppings_picked = "";
  private String flavor[] = { "Vanilla", "Chocolate",
                                "Strawberry", "Coffee",
                                "Swiss Almond", "Choc&Vanilla" };
  private String tps[] = {"Whipped Cream", "Nuts", "Cherry", "M&Ms"};
 
 public void actionPerformed(ActionEvent e)
	{
	ms.setText(flavors.getSelectedItem() + toppings_picked);	
	}
public IceCream2()
{    
    super("Ice Cream");

    setLayout(new FlowLayout());

    ms = new JTextField(25); 
    ms.setEditable(false); 

    // Do the flavors as combo box since we can pick only one
    flavors = new JComboBox(flavor);
    flavors.setMaximumRowCount(4);  // how many to see at once
    flavors.addActionListener(this);
    // flavors.setEditable(true); // to allow a user to add an item
     
  // Now do the toppings as List box, since we can pick more than one
    tops = new JLabel("Toppings");
    
    toppings = new JList(tps);
    toppings.setVisibleRowCount(3);
    toppings.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

  toppings.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        Object[] selected = toppings.getSelectedValues();
		toppings_picked = "";
		for (int k = 0;k < selected.length ; k++ )
		{
			toppings_picked += selected[k].toString() + " ";
		}
		ms.setText(flavors.getSelectedItem() + toppings_picked);
      }
    });

    add(flavors);
    add(ms);
    add(tops);

    add(new JScrollPane(toppings)); // need to put a scroll bar on the toppings
    
    setSize(330, 150);
  
   setVisible(true);
  }
  public static void main(String args[])
  {
    IceCream2 ic = new IceCream2();
 
    ic.addWindowListener(
       new WindowAdapter(){
          public void windowClosing(WindowEvent e)
          {
             System.exit(0);
          }
       } );
   }
    
}