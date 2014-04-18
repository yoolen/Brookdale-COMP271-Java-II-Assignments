package applets;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BounceBallApp extends Applet{
	public BounceBallApp(){
		setLayout(new FlowLayout());
		add(new BallControl());
	}
	
	public void init(){
		setSize(300,300);
	}
}

class Ball extends JPanel{
	private int delay = 10;
	
	// Create a timer with the specified delay in milliseconds
	private Timer timer = new Timer(delay, new TimerListener());

	// Current ball position
	private int x = 0;
	private int y = 0;
	
	private int radius = 5; // ball radius
	
	// Position increment
	private int dx = 2;
	private int dy = 2;
	
	// constructor
	public Ball(){
		timer.start();
	}
	
	private class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae){
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.red);
		
		// check boundaries
		if(x < 0 || x > getWidth()){
			dx *= -1;
		}
		if(y < 0 || y > getHeight()){
			dy *= -1;
		}
		
		// adjust ball position
		x += dx;
		y += dy;
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}
	
	public void suspend(){
		timer.stop();
	}
	
	public void resume(){
		timer.start();
	}
	
	public void setDelay(int delay){
		this.delay = delay;
		timer.setDelay(delay);
	}
}

class BallControl extends JPanel{
	private Ball ball = new Ball();
	private JButton jbtSuspend = new JButton("Stop");
	private JButton jbtResume = new JButton("Resume");
	private JScrollBar jsbDelay = new JScrollBar();
	
	public BallControl(){
		// Group buttons in a panel
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
		
		setPreferredSize(new Dimension(300,300)); // sets size of panel
		setLayout(new BorderLayout());
		
		// Add ball and buttons to the panel
		ball.setBorder(new javax.swing.border.LineBorder(Color.red));
		jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
		ball.setDelay(jsbDelay.getMaximum());
		
		add(jsbDelay, BorderLayout.NORTH);
		add(ball, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		// Register Listeners
		jbtSuspend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.suspend();
			}
		});
		
		jbtResume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.resume();
			}
		});
		
		jsbDelay.addAdjustmentListener(new AdjustmentListener() {
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e){
				ball.setDelay(jsbDelay.getMaximum()-e.getValue());
			}
		});
	}
}


