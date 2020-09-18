public class Student extends Person{

    private String grade;
    //private String rollNo;

    public Student(String name, String dob, String gender, long phone, Address address,String grade)
    {
        super(name,dob,gender,phone,address);
        this.grade = grade;
    }

    public String getGrade()
    {
        return this.grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    
   
    public void workingHours()
    {
        System.out.println("30 hrs a week");
    }

    public void updateGrade(String a)
    {
        this.grade = a;
        System.out.println("New Gardes: "+this.grade);

    }




}