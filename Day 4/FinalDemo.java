public class FinalDemo{
    public static void main(String[] args)
    {
        Address address = new Address("Maharashtra","Nanded","431602");
        
        
        Manager manager = new Manager("Rutuja","31Aug1990","Female",88888888L,address,11111L,70000.00);
        Admin admin = new Admin("Kedar","04Dec1991","Male",9898998989L,address,22222L,30000.00);

        Programmer programmer = new Programmer("Kavya","10Aug1996","Female",1212121212L,address,33333L,40000.00);
        Student student = new Student("Ajay","16July1997","Male",88880000L,address);
        Customer customer = new Customer("Siddhi","01Aug1998","Female",9009091231L,address);

        System.out.println("---------------------------------------------------");
        manager.displayInfo();
        manager.updateSalary();
        manager.specialization();
        manager.workingHours();
        System.out.println("---------------------------------------------------");
        admin.displayInfo();
        admin.updateSalary();
        admin.specialization();
        admin.workingHours();
        System.out.println("---------------------------------------------------");
        programmer.displayInfo();
        programmer.updateSalary();
        programmer.specialization();
        System.out.println("---------------------------------------------------");
        student.displayInfo();
        System.out.println("---------------------------------------------------");
        customer.displayInfo();
        System.out.println("---------------------------------------------------");







    }
} 