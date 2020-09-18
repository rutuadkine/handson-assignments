public class Admin extends Employee{


     public Admin(String name, String dob, String gender, long phone, Address address,long accountNumber, double salary)
    {
        super(name,dob,gender,phone,address,accountNumber,salary);
        
    }

   
    
    public void workingHours()
    {
        System.out.println("40 hrs a week");
    }

    @Override
    public void specialization()
    {
        System.out.println("System Maintainence");
    }





}