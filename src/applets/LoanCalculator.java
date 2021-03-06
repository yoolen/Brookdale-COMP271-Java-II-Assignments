package applets;

/* Terry Chern
 * Comp 271-001RL
 * 14 April 2014
 * Lab 9 - P698#18.1: Loan Calculator
 * Problem: Revise Listing 16.7, LoanCalculator.java, 
 * to be an applet for computing loan payment.
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import accounting.Loan;
	
public class LoanCalculator extends JApplet { // swap JFrame for JApplet
// Create text fields for interest rate, years,
// loan amount, monthly payment, and total payment
	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfNumberOfYears = new JTextField();
	private JTextField jtfLoanAmount = new JTextField();
	private JTextField jtfMonthlyPayment = new JTextField();
	private JTextField jtfTotalPayment = new JTextField();
	
	// Create a Compute Payment button
	private JButton jbtComputeLoan = new JButton("Compute Payment");
	
	// Panel p1 to hold labels and text fields
	public LoanCalculator(){
		JPanel p1 = new JPanel(new GridLayout(5,2));
		p1.add(new JLabel("Annual Interest Rate"));
		p1.add(jtfAnnualInterestRate);
		p1.add(new JLabel("Number of Years"));
		p1.add(jtfNumberOfYears);
		p1.add(new JLabel("Loan Amount"));
		p1.add(jtfLoanAmount);
		p1.add(new JLabel("Monthly Payment"));
		p1.add(jtfMonthlyPayment);
		p1.add(new JLabel("Total Payment"));
		p1.add(jtfTotalPayment);
		p1.setBorder(new TitledBorder("Enter loan amount, interest rate, and years"));
	
		// Panel p2 to hold the button
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeLoan);
	
		// Add the panels to the frame
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
	
		// Register listener
		jbtComputeLoan.addActionListener(new ButtonListener());
	}
	
	/** Handle the Compute Payment button */
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Get values from text fields
			double interest = Double.parseDouble(jtfAnnualInterestRate.getText());
			int year = Integer.parseInt(jtfNumberOfYears.getText());
			double loanAmount =	Double.parseDouble(jtfLoanAmount.getText());
	
			// Create a loan object. Loan defined in Listing 10.2
			Loan loan = new Loan(interest, year, loanAmount);
		
			// Display monthly payment and total payment
			jtfMonthlyPayment.setText(String.format("%.2f", loan.getMonthlyPayment()));
			jtfTotalPayment.setText(String.format("%.2f", loan.getTotalPayment()));
		}
	}
	
	
	public void init() {
		// The browser instantiates the class upon creation,
		// is the init method strictly necessary? or will it
		// automatically be called by the superclass on instantiation?
		// Can I just leave the init() method out?
	}
	
	/*	// main method is never executed by the browser
	public static void main(String[] args){
		LoanCalculator fram = new LoanCalculator();
		frame.pack();
		frame.setTitle("LoanCalculator");
		frame.setLocatoinRelativeTo(null); // center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	} */
	
}
	
