package gui;

import java.awt.*;
import javax.swing.*;

class MessagePanel extends JPanel{
	private String message = "Welcome to Java";
	private int xCoordinate = 20;
	private int yCoordinate = 20;
	private boolean centered;
	private int interval = 10;
	
	public MessagePanel(){	}
	
	public MessagePanel(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
		repaint();
	}
	
	public int getXCoordinate(){
		return xCoordinate;
	}
	
	public void setXCoordinate(int x){
		this.xCoordinate = x;
		repaint();
	}
	
	public int getYCoordinate(){
		return yCoordinate;
	}
	
	public void setYCoordinate(int y){
		this.xCoordinate = y;
		repaint();
	}
	
	
}

public class SliderDemo extends JFrame{
	private JSlider jsH = new JSlider(JSlider.HORIZONTAL);
	private	JSlider	jsV = new JSlider(JSlider.VERTICAL);
	
	private MessagePanel messagePanel = new MessagePanel("Welcome to Java");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
