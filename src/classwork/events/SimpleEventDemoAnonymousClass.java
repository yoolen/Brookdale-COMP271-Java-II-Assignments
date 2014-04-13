package classwork.events;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleEventDemoAnonymousClass extends JFrame {
  public SimpleEventDemoAnonymousClass() {
    JButton jbtOK = new JButton("OK");
    setLayout(new FlowLayout());
    add(jbtOK);
    
    jbtOK.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    // anonymous method, single use, called/created each time the thing is called
    // still permits internal access of data
      System.out.println("It is OK");
    }
  });
  }
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new SimpleEventDemoAnonymousClass();
    frame.setTitle("SimpleEventDemoAnonymousClass");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }
}