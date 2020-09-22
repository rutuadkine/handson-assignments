package com.hsbc.model.dao;

import com.hsbc.model.beans.Account;

public class AccountArrayDao implements AccountDao{
	
	private static Account[] accountArray = new Account[10];
	private static int index = 0;
	
	@Override
	public Account store(Account account)
	{
		accountArray[index++]=account;
		return account;
	}
	
	@Override
	public Account[] fetchAccounts()
	{
		return accountArray;
	}
	
	@Override
	public Account fetchAccountById(int accountNumber)
	{
		Account account = null;
		for(int i=0;i<index;i++)
		{
			if(accountArray[i].getAccountNumber() == accountNumber)
			{
				account = accountArray[i];
			}
		}
		return account;
	}
	
	@Override
	public Account updateAccount(int accountNumber, Account account)
	{
		for(int i=0;i<index;i++)
		{
			if(accountArray[i].getAccountNumber() == accountNumber)
			{
				accountArray[i]=account;
			}
		}
		return account;
	}

}
