public abstract class Employee extends Person{

    private long accountNumber;
    private double salary;
   

    Employee(String name, String dob, String gender, long phone, Address address,long accountNumber, double salary)
    {
        super(name,dob,gender,phone,address);
        this.accountNumber = accountNumber;
        this.salary = salary;
        
    }

    public long getAccountno()
    {
        return this.accountNumber;
    }
    

    public double getSalary()
    {
        return this.salary;
    }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public abstract void specialization();
    
    


    public void updateSalary()
    {
       this.salary = this.salary + (this.salary*0.1);
       System.out.println("Updated Salary: "+this.salary);
       
    }




}