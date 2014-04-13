package classwork.week6;

// Drawing some lines, rectangles or ovals 

import java.awt.*;
import javax.swing.*;

public class SwitchTest extends JFrame {
   int choice;   

   public SwitchTest()
   {
      String input;

      input = JOptionPane.showInputDialog( 
                 "Enter 1 to draw lines\n" +
                 "Enter 2 to draw rectangles\n" +
                 "Enter 3 to draw ovals\n" );

      choice = Integer.parseInt( input );
	
		setSize(250,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void paint( Graphics g )
   {
      String mess;
      int red, green, blue;
	  super.paint(g);
	  Graphics2D g2d = (Graphics2D)g; // this is needed to draw filled rectangles
           switch( choice ) {
            case 1:
				for(int xEnd = 50, yEnd = 50, lines = 0; lines < 10; lines++){
					 g.drawLine(120, 120, xEnd, yEnd);
					xEnd +=2;
					yEnd -=10;
				}
				break;
            case 2:
				for(int count = 0, width = 150, height = 150; count < 10; count++, width -=10, height-=10){
					red = (int)(Math.random()*256);
	            	green = (int)(Math.random()*256);
	            	blue = (int)(Math.random()*256);
	            	Color myColor = new Color(red, green, blue);
	            	g2d.setPaint(myColor);
					g2d.fillRect(25, 25, width, height);
					
				}
				break;
            case 3:
				
					g.drawOval( 20 , 20 ,
                           50 , 50  );
               break;
            default:
               mess = "Bad choice - " + choice;
               JOptionPane.showMessageDialog(
                  null, mess );
         } // end switch
      
   } // end paint()
	public static void main (String args[])
	{
		SwitchTest app = new SwitchTest();
		
	} 

} // end class SwitchTest
