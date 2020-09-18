public class FinalDemo{
    public static void main(String[] args)
    {
        Address address = new Address("Maharashtra","Nanded","431602");
        
        
        Manager manager = new Manager("Rutuja","31Aug1990","Female",88888888L,address,11111L,70000.00);
        Admin admin = new Admin("Kedar","04Dec1991","Male",9898998989L,address,22222L,30000.00);

        Programmer programmer = new Programmer("Kavya","10Aug1996","Female",1212121212L,address,33333L,40000.00);
        Student student = new Student("Ajay","16July1997","Male",88880000L,address,"C");
        Customer customer = new Customer("Siddhi","01Aug1998","Female",9009091231L,address,3000);

        System.out.println("---------------------------------------------------");
        manager.displayInfo();
        FinalDemo.testUpdate(manager);
        //manager.updateSalary();
        manager.specialization();
        manager.workingHours();
        System.out.println("---------------------------------------------------");
        admin.displayInfo();
        FinalDemo.testUpdate(admin);
        //admin.updateSalary();
        admin.specialization();
        admin.workingHours();
        System.out.println("---------------------------------------------------");
        programmer.displayInfo();
        FinalDemo.testUpdate(programmer);
        //programmer.updateSalary();
        programmer.specialization();
        System.out.println("---------------------------------------------------");
        student.displayInfo();
        FinalDemo.testUpdate(student);
        System.out.println("---------------------------------------------------");
        customer.displayInfo();
        FinalDemo.testUpdate(customer);
        System.out.println("---------------------------------------------------");







    }
     public static void testUpdate(Person person){
        
        if(person instanceof Manager){
            double extra=0;
            Manager manager=(Manager)person;
            double presentSalary=manager.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            manager.setSalary(presentSalary);
        }

           
        if(people instanceof Admin){
            double extra=0;
            Admin admin=(Admin)people;
            double presentSalary=admin.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            admin.setSalary(presentSalary);
        }


        //Updating Salary Of Programmer
        if(person instanceof Programmer){
            double extra=0;
            Programmer man=(Programmer)person;
            double presentSalary=man.getSalary();
            extra=presentSalary*10;
            extra/=100;
            presentSalary+=extra;
            System.out.println("Salary increased by 10% that is : "+extra);
            man.setSalary(presentSalary);
        }


        
        if(person instanceof Student){
            Student student=(Student)person;
            student.updateGrade("A");
        }


        
        if(person instanceof Customer){
            Customer customer=(Customer)person;
            customer.updateBalance(20000);
        }

    }
} 