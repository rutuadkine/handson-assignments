class EmployeeArray{
    public static void main(String[] args)
    {
        Employee[] e = new Employee[5];
        Address addr1 = new Address("Maharashtra","Nanded",431602);
        Address addr2 = new Address("Goa","Goad",230607);
        Address addr3 = new Address("Kerala","Kochi",631792);
        Address addr4 = new Address("Maharashtra","Nanded",431602);
        //Address addr5 = new Address("Maharashtra","Nanded",431602);
        e[0] = new Employee("Rutuja",101,60000L,addr1);
        e[1] = new Employee("Tina",102,20000L,addr2);
        e[2] = new Employee("Liza",103,46000L,addr4);
        e[3] = new Employee("Ajay",104,75000L,addr3);
        e[4] = new Employee("Kedar",105,80000L);
       // e[0].display();

        for(Employee emp : e)
        {
            if(emp.salary>=50000)
            {
                emp.display();
            }
            
        }
    }
}