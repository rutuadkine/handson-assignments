public class Customer extends Person{

    private int balance;

    public Customer(String name, String dob, String gender, long phone, Address address,int balance)
    {
        super(name,dob,gender,phone,address);
        this.balance = balance;
    }

   
    public void workingHours()
    {
        System.out.println("On his will till the project gets completed");
    }

    public void updateBalance(int bal)
    {
        this.balance = bal;
        System.out.println("New balance: "+this.balance);
    }




}