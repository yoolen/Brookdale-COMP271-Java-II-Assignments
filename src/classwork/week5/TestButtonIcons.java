package classwork.week5;

import javax.swing.*;

public class TestButtonIcons extends JFrame  {
  public static void main(String[] args) {
    // Create a frame and set its properties
    JFrame frame = new TestButtonIcons();
    frame.setTitle("ButtonIcons");
    frame.setSize(165, 80);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public TestButtonIcons() {
    ImageIcon usIcon = new ImageIcon(getClass().getResource("usIcon.gif"));
    ImageIcon caIcon = new ImageIcon(getClass().getResource("caIcon.gif"));
    ImageIcon ukIcon = new ImageIcon(getClass().getResource("ukIcon.gif"));

    JButton jbt = new JButton("Click it", usIcon);
    jbt.setPressedIcon(caIcon);
    jbt.setRolloverIcon(ukIcon);

    add(jbt);
  }
}
