package mensing;

public class  empdrv
{
	public static void main(String[] args) 
	{
		Employee employees[] = new Employee[5]; // new Array, not new Employee

		employees[0] = new Salary("Bob", 123451234, 500000);
		employees[1] = new Hourly("Bill", 12312345, 25);
		employees[2] = new Salary_Commission("Jane", 980123456, 450000);
		((Commission)employees[2]).addSales(5000);
		employees[3] = new Salary_Commission("Jake", 980123400, 350000);
		((Commission)employees[3]).addSales(4000);
		employees[4] = new Hourly("Kelley", 22212345, 35);

		for (int k = 0; k < employees.length ;k++ )
		{
			System.out.printf("Employee %s earned $%5.2f\n", employees[k].get_name(), employees[k].get_paid());
		}
	}
}
// Employee
abstract class Employee
{
	private String name;
	private long social;

	public Employee(String name, long social)
	{
		this.name = name;
		this.social = social;
	}
	public String get_name()
	{
		return this.name;
	}
	public abstract double get_paid();
}
// Salary
class Salary extends Employee
{
	private double yearly_salary;

	public Salary(String name, long social, double salary)
	{
		super(name, social);
		yearly_salary = salary;
	}
	public double get_paid()
	{
		return yearly_salary / 52;
	}
}
// Hourly
class Hourly extends Employee
{
	private double hourly_rate;

	public Hourly(String name, long social, double hourly)
	{
		super(name, social);
		hourly_rate = hourly;
	}
	public double get_paid()
	{
		return hourly_rate * 40;
	}
}
interface Commission
{
	double Commission_rate = 0.10;
	void addSales(double sales);
}
class Salary_Commission extends Employee implements Commission
{
	private double yearly_salary;
	private double sales;

	public Salary_Commission(String name, long social, double salary)
	{
		super(name, social);
		yearly_salary = salary;
	}
	public double get_paid()
	{
		double amt = (yearly_salary / 52) + Commission_rate * sales;
		sales = 0;
		return amt;
	}
	public void addSales(double sales)
	{
		this.sales += sales;
	}
}