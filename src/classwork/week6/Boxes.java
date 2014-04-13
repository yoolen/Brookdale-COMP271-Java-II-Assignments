package classwork.week6;

// Demonstrates Graphics, Colors and paint
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;


public class Boxes extends JFrame 
{
	int box[] = new int[4];
	int  max = 500;

	public Boxes()
	{
		String box1_str;
		for (int k=0; k<box.length; k++)
		{
			box1_str = JOptionPane.showInputDialog
				("Enter 200 to 500 for box " + (k+1));

			box[k] = Integer.parseInt(box1_str);
		}

		setSize(500,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(Color.red);
		g2d.fill ( new Rectangle2D.Double(30, max - box[0], 30, max ));
		
		g2d.setPaint(Color.green);
		g2d.fill ( new Rectangle2D.Double(90, max - box[1], 30, max ));

		g2d.setPaint(Color.blue);
		g2d.fill ( new Rectangle2D.Double(150, max - box[2], 30, max ));

		g2d.setPaint(Color.yellow);
		g2d.fill ( new Rectangle2D.Double(210, max - box[3], 30, max ));
	}
	public static void main (String args[])
	{
		Boxes app = new Boxes();
		
	} 
}