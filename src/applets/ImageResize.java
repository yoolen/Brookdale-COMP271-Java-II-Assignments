package applets;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

/* Terry Chern
 * Comp 271
 * 17 April 2014
 * Lab 13 - Displaying Images
 * Problem: Write an applet that will display a sequence of images from a
 * single image file in different sizes. Initially, the viewing area for the
 * image has a width of 300 and a height of 300. You program should continuously
 * shrink the viewing area by 1 in width and 1 in height until it reaches a
 * width of 50 and a height of 50. At this point, the viewing area should
 * continuously enlarge by 1 in width and 1 in height until it reaches a width
 * of 300 and a height of 300. The viewing area should shrink and enlarge
 * (alternately) to create animation for the single image.
 * Method: Java draws an image using the top left corner of a window as the
 * origin and extending the positive x-axis to the right and the positive y-axis
 * downwards. When drawing an image in a JFrame/JApplet we specify a point within
 * the frame/window as the origin from which we will draw the shape.
 * 
 * Because Java does not explicitly permit the setting of the center of the image
 * (it allows setting the initial point and the length of the sides), in order to
 * keep the image centered we must adjust the starting point of the drawing. To
 * do this we must shift the origin in the opposite direction of the change by 1/2
 * the amount of the change. Because drawings on a computer screen must take place
 * in discrete units (called pixels) changes in the size of the image must be in
 * even increments (or else the integer division will cause us to lose significant
 * digits and thus the true center of the image).
 */

public class ImageResize extends JApplet{
	public final int XMAX = 601;
	public final int YMAX = 680;
	
	public ImageResize(){
		// Initialize variables
		java.net.URL url = this.getClass().getResource("tree21.gif");
		Image image = new ImageIcon(url).getImage();
		add(new ImageGrowPanel(image));
	}
	
	class ImageGrowPanel extends JPanel implements ActionListener{
		private int x=0; // Initialize this to the top left corner
		private int y=0; // of the frame.
		private int width = XMAX;  // Start the image of the tree at full
		private int height = YMAX; // size to fill the frame
		private int change = 2; // This number needs to be even or else 
		private Image image;    // integer arithmetic will drop pixels.
		private Timer timer = new Timer(50, this); 
		// Adjust timer to change the speed of "growth"
		// Timer is a special class that must have a listener associated
		// with it. The class that uses the Timer must implement an
		// ActionListener, the default actionPerformed method checking for
		// changes in the Timer object.
		
		public ImageGrowPanel(Image image){
			this.image = image; // Associate the image for the Graphics package
			timer.start(); // Start the timer
		}

		@Override
	    public void paintComponent(Graphics g) {
		// The drawing process will expand the image until it fills the screen
		// after which it will reverse the direction of change causing the image
		// to shrink.
			super.paintComponent(g);
	      	if (width > XMAX){
	      		change *= -1;
		    }
		    if (width < 50){
		    	change *= -1;
		    }
	      	width += change;
	      	height += change;
	      	x-= change/2; // recenter the x-component for each repaint
	      	y-= change; 
	      	// offset the y-component by the same amount lost in height to keep base in same location
		    g.drawImage(image, x, y, width, height, this);
		    // redraw the image with new sizes and coordinates.
		}

		public void actionPerformed(ActionEvent e) {
		// each time the Timer goes off repaint the image.
		    repaint();
		}
	}
	
	public void init(){
		setSize(new Dimension(XMAX,YMAX)); // set default frame size
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
