public class MainBank {
    public static void main(String[] args) {
        //pass the accountNo and amount to deposit from CLA

        //Assignment 1
       /* long acctNo = Long.parseLong(args[0]);
        double amount = Double.parseDouble(args[1]);
        
        Account acc = MainBank.getAccount(acctNo);
	    if(acc != null) {
		    acc.accountInformation();
		    acc.deposit(amount);
		    acc.accountInformation();
	    }
	    else
		    System.out.println("Account not found. Enter vaild Account Number");*/
        
        //Assignment 2
        long source = Long.parseLong(args[0]);
        long destination = Long.parseLong(args[1]);
        double amount = Double.parseDouble(args[2]);

        Account acc1 = MainBank.getAccount(source);
	    Account acc2 = MainBank.getAccount(destination);

        acc1.accountInformation();
        acc2.accountInformation();

        if(acc1 != null && acc2 != null) {
		    if(acc1.getBalance() >= amount) {
			    acc1.withdraw(amount);
			    acc2.deposit(amount);
			    System.out.println("Amount Transferred");
		    }
		    else
			    System.out.println("Insufficient Balance");
	    }
	    else
		    System.out.println("Account not found. Enter vaild Account Number");

        acc1.accountInformation();
        acc2.accountInformation();









        //get the Account using the accountNo by calling getAccount(...)
        // if accountNo is wrong show the error message and must not perform any below
        // operation
        
        // show the account information before deposit
        //deposit the amount to that particular Account
        //show the account information after deposit
    }

    // pass the accountNO and get the Account from Accounts[] 
   public static Account getAccount(long accountNo) {
	Account[] accounts = AccountsDB.getAccounts();
	for(Account t : accounts)
		if(t.getAccountNumber() == accountNo)
			return t;
	return null;
    }
}