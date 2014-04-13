package accounting;

/* Terry Chern
 * Comp 271-001RL
 * 6 February 2014
 * John Mensing
 * Lab 3b: P.442#11.3 - The Account Class
 * Problem: The Account class is defined to model a bank account. An account has the properties:
 * account number, balance, annual interest rate, and date created, and methods to deposit and
 * withdraw funds. Create two subclasses for checking and savings accounts. A checking account
 * has an overdraft limit, but a savings account cannot be overdrawn. Draw the UML diagrams for
 * the classes and then implement them. Write a test program that creates objects of Account,
 * SavingsAccount, and CheckingAccount and invokes their toString() methods.
 */

public class AccountTest {
	public static void main(String[] args) {
		SavingsAccount save1 = new SavingsAccount(0,500);
		save1.setAnnualInterestRate(0.04);
		System.out.println(save1);
		save1.withdraw(100);
		System.out.println(save1);
		save1.withdraw(500);
		System.out.println(save1);
		
		CheckingAccount chek1 = new CheckingAccount(0,100);
		System.out.println(chek1);
		chek1.withdraw(50);
		System.out.println(chek1);
		chek1.withdraw(100);
		System.out.println(chek1);
		chek1.withdraw(100);
		System.out.println(chek1);
	}
}

class SavingsAccount extends Account{
	public SavingsAccount(){
		this(0,0);
	}
	
	public SavingsAccount(int ID, double balance){
		super(ID,balance);
	}
	
	public void withdraw(double withdrawal){
	// Savings account does not allow withdraw below balance.
		if(withdrawal > this.balance){
			System.out.println("Insufficient funds.");
		}
		else
			this.balance -= withdrawal;
	}
}

class CheckingAccount extends Account{
	private final double LIMIT = 100.0; // Defined here because no other Account uses it.
	
	public CheckingAccount(){
		this(0,0);
	}
	
	public CheckingAccount(int ID, double balance){
		super(ID,balance);
	}

	public void withdraw(double withdrawal){
	// Checking has an overdraft of up to LIMIT
		if(withdrawal - this.balance > LIMIT){
			System.out.println("Insufficient funds.");
		}
		else
			this.balance -= withdrawal;
	}
}