package applets;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

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
 */

public class ImageResize extends JApplet {
	public ImageResize(){
		java.net.URL url = this.getClass().getResource("tree21.gif");
		add(new JLabel(new ImageIcon(url)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
