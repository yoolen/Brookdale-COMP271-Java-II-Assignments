package mensing;

public  class Student
  {
    private String sname;
    private int std_id;
    private int year;
	public static String school = "Brookdale";
  
    public Student (String nm, int stdid, int yr)
    {
        sname = nm;
        std_id = stdid;
        year = yr;
    }
    public int get_year()
    {
        return year;
    }
    public String get_name()
    {
       return sname;
    }
    public int get_id()
    {
       return std_id;
    }
    public String toString()
    {
      return this.get_name() + "\t " + this.get_id() + "\t " + this.get_year() + " " + school;
    }
  }