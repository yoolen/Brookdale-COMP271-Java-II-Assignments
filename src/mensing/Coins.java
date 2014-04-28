package mensing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Coins extends JFrame{
	private JButton nickelBtn, dimeBtn, quarterBtn, returnBtn; 
	private JTextArea myText;
	
	public Coins(String string){
		super(string);
		setLayout(new BorderLayout());
		setSize(150,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		myText = new JTextArea();
		myText.setLineWrap(true);
		myText.setWrapStyleWord(true);
		JScrollPane textPanel = new JScrollPane(myText);
		textPanel.setBorder(BorderFactory.createTitledBorder("Coins"));
				
		add(new Buttons(),BorderLayout.NORTH);
		add(textPanel,BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	class Buttons extends JPanel implements ActionListener{
		StringBuilder clicks = new StringBuilder("");
		
		public Buttons(){
			setLayout(new GridLayout(4,1));
			nickelBtn = new JButton("Nickel");
			dimeBtn = new JButton("Dime");
			quarterBtn = new JButton("Quarter");
			returnBtn = new JButton("Return");
			
			nickelBtn.addActionListener(this);
			dimeBtn.addActionListener(this);
			quarterBtn.addActionListener(this);
			returnBtn.addActionListener(this);
			
			add(nickelBtn);
			add(dimeBtn);
			add(quarterBtn);
			add(returnBtn);
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(clicks.substring(0).equals("Coins returned!")){
				clicks.setLength(0);
			}
			if(ae.getActionCommand()=="Return"){
				clicks.setLength(0);
				clicks.append("Coins returned!");
			}
			else{
				clicks.append(ae.getActionCommand());
				clicks.append(" ");
			}
			myText.setText(clicks.toString());
		}
	}
		

	public static void main(String[] args) {
		Coins myCoins = new Coins("Coins");
	}

}
