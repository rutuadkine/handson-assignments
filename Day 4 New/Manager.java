public class Manager extends Employee
{

   private double salary;

   public Manager(String name, String dob, String gender, long phone, Address address,long accountNumber, double salary)
    {
        super(name,dob,gender,phone,address,accountNumber,salary);
        this.salary = salary;
        
    }

     public double getSalary()
    {
        return this.salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }



     
    @Override
    public void workingHours()
    {
        System.out.println("50 hrs a week");
    }
    
    @Override
    public void specialization()
    {
        System.out.println("Project Management");
    }



}