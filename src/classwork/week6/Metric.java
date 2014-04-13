package classwork.week6;

// Font Metrics example
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Metric extends JFrame 
{
	public Metric()
	{
		super("Font Metrics");
		setSize (510, 610);
		setVisible(true);
	}

	public void paint (Graphics g)
	{
		String message = "Java is Great";
		super.paint(g); // what happens if you forget to invoke super.paint() ?

		g.setFont ( new Font ("Monospaced", Font.BOLD, 20 ) );
		FontMetrics fm = g.getFontMetrics();

		// find the center
		int w = fm.stringWidth(message);
		int h = fm.getAscent();

		int x = (getSize().width - w) / 2;
		int y = (getSize().height + h) / 2;

		g.drawString( message, x, y);

	}
	public static void main(String[] args) 
	{
		Metric app = new Metric();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}