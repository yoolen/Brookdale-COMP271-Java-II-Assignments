package animation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class Flag extends JApplet {
  public Flag() {
    URL imageURL = this.getClass().getResource("uk.gif");
    Image image = new ImageIcon(imageURL).getImage();
    add(new FlagAnthemPanel(image));
  }

  public static class FlagAnthemPanel extends JPanel implements ActionListener {
    private Image image;
    private Timer timer = new Timer(10, this);
    private int x = 50;
    private int y = 50;
    int width = 300;
    int height = 300;
    int change = 2;

    public FlagAnthemPanel(Image image) {
      this.image = image;
      timer.start();

      //URL audioURL = this.getClass().getResource("uk.mid");
      //AudioClip audioClip = Applet.newAudioClip(audioURL);
      //audioClip.play();

    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      	if (width > 300){
      		change *= -1;
      	}
      	if (width < 50){
      		change *= -1;
      	}
      	
      	width += change;
      	height += change;
      	x-= change/2;
      	y-= change/2;

      g.drawImage(image, x, y, width, height, this);
    }

    public void actionPerformed(ActionEvent e) {
      repaint();
    }
  }

  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Flag");

    // Create an instance of the applet
    JApplet applet = new Flag();

    // Add the applet to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke applet's init method
    applet.init();

    // Display the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
