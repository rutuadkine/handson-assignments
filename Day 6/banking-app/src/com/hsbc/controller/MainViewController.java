package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.model.beans.Account;
import com.hsbc.model.beans.AccountNotFoundException;
import com.hsbc.model.beans.InsufficientBalanceException;
import com.hsbc.model.service.AccountService;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class MainViewController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AccountService service = (AccountService)UserFactory.getInstance(Type.SERVICE);
		
		int choice = 0;
		
		do
		{
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Fetch Account by id 4: Transfer 5:Exit");
			System.out.println("*****************************************************************************************");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter Account no:");
				
				Account account = new Account(sc.nextInt());
				System.out.println("Enter your name:");
				
				account.setCustomerName(sc.next());
				System.out.println("Enter balance:");
				account.setBalance(sc.nextDouble());
				
				System.out.println("Enter phone number:");
				account.setContactNumber(sc.nextLong());
				
				Account newAccount = service.createAccount(account);
				System.out.println("Account created for -  "+newAccount.getCustomerName());
				break;
				
			case 2:
				Account[] accounts = service.getAllAccounts();
				for(Account temp: accounts)
				{
					if(temp!=null)
					{
						System.out.println(temp);
					}
				}
				break;
			case 3:
				System.out.println("Enter account no to fetch:");
				try {
					Account accountFound=service.getAccountById(sc.nextInt());
					System.out.println(accountFound);
					}catch(AccountNotFoundException e) {
						System.err.println("Error : "+e.getMessage());//err prints in read color
					}
					break;
					
			case 4:
				System.out.println("Enter source and destiation for transfer and amount to transfer:");
				
				try {
				service.transfer(sc.nextInt(), sc.nextInt(), sc.nextDouble());
				}
				catch(InsufficientBalanceException e)
				{
					System.err.println("Error : "+e.getMessage());//err prints in read color

				}
				break;
			case 5:
				break;
			}
			
		}
		while(choice!=6);

	}

}
