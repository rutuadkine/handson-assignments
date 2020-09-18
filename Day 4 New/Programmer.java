public class Programmer extends Employee{

    private double salary;

    public Programmer(String name, String dob, String gender, long phone, Address address,long accountNumber, double salary)
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

  
    
    public void workingHours()
    {
        System.out.println("45 hrs a week");
    }

    @Override
    public void specialization()
    {
        System.out.println("Data Analytics");
    }




}