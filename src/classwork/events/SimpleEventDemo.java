package classwork.events;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleEventDemo extends JFrame {

  public SimpleEventDemo() {
    JButton jbtOK = new JButton("OK");
    setLayout(new FlowLayout());
    add(jbtOK);

    ActionListener listener = new OKListener();
    jbtOK.addActionListener(listener);
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new SimpleEventDemo();
    frame.setTitle("SimpleEventDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }
}

class OKListener implements ActionListener {
// outside the class; good for generic things, but has difficulty accessing internal variables
// must use getters and setters to interact with class.
  public void actionPerformed(ActionEvent e) {
    System.out.println("It is OK");
  }
}