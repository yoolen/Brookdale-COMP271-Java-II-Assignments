package mensing;
 // Purpose - Use the Student class
// and create an array of objects

public class studs 
{
  public static void main (String args[]) 
  {
    String fname;
    String lname;
     
    int k;
     Student[] stds = new Student[10]; // an array of Students  
        
    for (k=0; k < stds.length; k++)
    {
		// Create a student by passing name, student id, and year
        stds[k] = new Student("name"+k, 1 + (int) (Math.random()*100), 1 + (int) (Math.random()*4));
    }
    // reference a static within a class can be done two ways
	System.out.println("Student name \t  id \t class  " + Student.school);
    for (k=0; k<stds.length; k++)
    {
       if (stds[k].get_year() == 1)
          System.out.println("Student " + stds[k].get_name() + " is a frosh at " + Student.school);
       System.out.println("Student " + stds[k]);
    }
   

  System.exit(0);  
    
  }
}

  
