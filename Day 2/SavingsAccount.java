class SavingsAccount{
    long accountNo, balance;
    String ifsc,name,state,city;
    int pin;

    SavingsAccount(long a, String n, String  s, String c, int p, String i)
    {
        
        System.out.println("Welcome  "+n);
        System.out.println();
        accountNo = a;
        name = n;
        state = s;
        city = c;
        pin = p;
        ifsc = i;
        balance = 0;
    }

    SavingsAccount(long a, String n, String  s, String c, int p, long b)
    {
        System.out.println("Welcome  "+n);
        System.out.println();
        ifsc = "HSBC001";
        accountNo = a;
        name = n;
        state = s;
        city = c;
        pin = p;
        balance = b;
    }

    void deposit(long deposit)
    {
        
        balance = balance + deposit;
        System.out.println("Your balance after deposit is:"+balance);
        System.out.println("----------------------------------------------------");
    }

    void withdraw(long withdraw)
    {
        
        if(balance>0 && balance >= withdraw)
        {
            balance = balance - withdraw;
        }
        else 
        {
            System.out.println("Can not withdraw");
        }

        System.out.println("Your balance after withdraw is:"+balance);
        System.out.println("----------------------------------------------------");

    }

    void display()
    {
        //System.out.println("Welcome"+name);
        System.out.println("Savings Account Details:");
        System.out.println("Name: "+name);
        System.out.println("Account no.: "+accountNo);
        System.out.println("State: "+state);
        System.out.println("City: "+city);
        System.out.println("PIN: "+pin);
        System.out.println("Current balance: "+balance);
        System.out.println("IFSC code: "+ifsc);
        System.out.println("----------------------------------------------------");



    }

   
}