class Employee{
    String name;
    double salary;
    int id;
    Address addr;

    Employee(String name, int id, double salary, Address addr)
    {
        this(name,id,salary);
        this.addr = addr;

        
    }

    Employee(String name, int id, double salary)
    {
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    

    void display()
    {
        
        if(addr == null)
        {
            System.out.println(" Name: "+name+" ID: "+id+" Salary: "+salary);
        }
        else
        {
            System.out.println(" Name: "+name+" ID: "+id+" Salary: "+salary+" State: "+addr.state+" City: "+addr.city+" Pincode: "+addr.pincode);
        }
    }
}