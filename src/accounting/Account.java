package accounting;

import java.util.Date;
/* Terry Chern
 * Comp 171-800RL
 * 1 November 2013
 * Lab 12 - p.331#8.7 - Account Class
 * Problem: Design a class named Account; draw the UML diagram for this class
 * and then implement the class. Write a test program that creates an Account
 * object with an account ID of 1122, a balance of $20,000, and an annual interest
 * rate of 4.5%. Use the withdraw method to withdraw $2500, use the deposit
 * method to deposit $3000, and print the balance, the monthly interest, and the
 * date this account was created.
 * Method: The class will contain the following:
 * 	A private int data field named id for the account (default 0)
 *  A private double data field named balance for the account (default 0)
 *  A private double data field named annualInterestRate that stores the current interest rate (default 0)
 *  A private Date data field named dateCreated that stores the date when the account was created
 *  A no-arg constructor that creates a default account
 *  A constructor that creates an account with the specified id and initial balance
 *  The accessor and mutator methods for id, balance, and annualInterestRate
 *  The accessor method for dateCreated
 *  A method named getMonthlyInterestRate() that returns the monthly interest rate
 *  A method named getMonthlyInterest that returns the monthly interest
 *  A method named withdraw that withdraws a specified amount from the account
 *  A method named deposit that deposits a specified amount to the account
 */
class Account {
	protected int ID;
	protected double balance;
	protected double annualInterestRate;
	protected Date dateCreated;
	//protected String acctType; //unnecessary because subclasses have reflection (know what kind of account they are)

	public Account(){
	// no-arg constructor with default values set
		ID = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date(); // date defaults to today's date
	}
	
	public Account(int ID, double balance){
	// constructor with ID and balance as initial values.
		this.ID = ID;
		this.balance = balance;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	public void setID(int newID){
	// id mutator
		this.ID = newID;
	}
	
	public int getID(){
	// id accessor
		return this.ID;
	}
	
	public void setBalance(double newBalance){
	// balance mutator
		this.balance = newBalance;
	}
	
	public double getBalance(){
	// balance accessor
		return this.balance;
	}
	
	protected void setAnnualInterestRate(double newAnnualInterestRate){
	// annual interest rate mutator
		this.annualInterestRate = newAnnualInterestRate;
	}
	
	public double getAnnualInterestRate(){
	// annual interest rate accessor
		return this.annualInterestRate;
	}
	
/*	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
*/
	public Date getDateCreated(){
	// creation date accessor (no mutator because date of creation should not be changed)
		return this.dateCreated;
	}
	
	protected double getMonthlyInterestRate(){
	// monthly interest rate is calculated privately for the function getMonthlyInterest()
		return this.annualInterestRate/1200;
	}
	
	public double getMonthlyInterest(){
	// method that calculates and returns the monthly interest earned given current balance and rate
		return this.balance * this.getMonthlyInterestRate();
	}
	
	public void withdraw(double withdrawal){
	// method to withdraw funds
		this.balance -= withdrawal;
	}
	
	public void deposit(double deposit){
	// method to add funds
		this.balance += deposit;
	}
	
	public String toString(){
	// method to get account details, returns a formatted string
		return String.format("Account ID: %d \t Account Type: %s\nBalance: $%.2f\nMonthly Interest: $%.2f"
				+ "\nDate Created: ", this.getID(), this.getClass().getSimpleName(), this.getBalance(), this.getMonthlyInterest()) +
				this.getDateCreated();
	}
}