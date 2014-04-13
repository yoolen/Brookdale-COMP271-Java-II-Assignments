package classwork.events;


// The code places 10 buttons on the screen in a panel within a gridlayout
// The code also places a text field at the top of the screen
// The code uses border layout to place the panel and text field on the screen
// J.S. Mensing

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class TestPanels extends JFrame 
  
{
  //declare a text field
  private JTextField tfNum; 
  
  //create an array of buttons
  private JButton btNum[] = new JButton[12]; 

  public TestPanels()
  {
    setTitle("TestPanels");

    //set BorderLayout for the frame
    setLayout(new BorderLayout());

    //create panel pn for the buttons and set GridLayout
    JPanel pn = new JPanel();
    pn.setLayout(new GridLayout(0,3));

    //add buttons to p
    for (int i=1; i<=9; i++)
    {
      pn.add(btNum[i] = new JButton(""+i));
      
    }
    
 	// last row
	pn.add(btNum[10] = new JButton("*"));
	pn.add(btNum[0] = new JButton("0"));
	
	pn.add(btNum[11] = new JButton("#"));

	// attach listeners
	ButtonHandler bh = new ButtonHandler();
	
	for(int i=0; i<btNum.length; i++){
	    	
	}
	
    //create a new text field
    tfNum = new JTextField();
    tfNum.addActionListener(bh);

    //add the data to the frame
    add("Center", pn); // buttons in the center
    add("North", tfNum); // text field at the top
  }

  public static void main(String[] args)
  {
    JFrame f = new TestPanels();
    f.setSize(200,250);
    f.setVisible(true);
    f.addWindowListener( new WindowAdapter() {
           public void windowClosing (WindowEvent e)
           {
                System.exit(0);
           }
       }
    );
  }
  
  class ButtonHandler implements ActionListener{
	  public void actionPerforme(ActionEvent e){
		  String result;
		  
	  }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
  }
}
