public class Customer extends Organization{

    

    public Customer(String name, String dob, String gender, long phone, Address address)
    {
        super(name,dob,gender,phone,address);
    }

   
    public void workingHours()
    {
        System.out.println("On his will till the project gets completed");
    }




}