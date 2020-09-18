public abstract class Person{

    private String name, dob, gender;
    private long phone;
    Address address;
    //Account account;

    public Person(String name, String dob, String gender, long phone, Address address)
    {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        //this.account = account;
    }
    public String getName()
    {
        return this.name;
    }
    public String getDob()
    {
        return this.dob;
    }
    public String getGender()
    {
        return this.gender;
    }
    public long getPhone()
    {
        return this.phone;
    }
    public void displayInfo()
    {
        System.out.println("Personal Details:");
        System.out.println("Name: "+this.name);
        System.out.println("Date of birth: "+this.dob);
        System.out.println("Gender: "+this.gender);
        System.out.println("Phone no.: "+this.phone);
        System.out.println("Address: State- "+address.getState()+" City- "+address.getCity()+" Pincode- "+address.getPincode());
        
    }

    public abstract void  workingHours();

    
    /*public void updateGrade(Student student)
    {
        student.setGrade("A");
    }*/


}