package com.hsbc.model.service;

import com.hsbc.model.beans.Account;
import com.hsbc.model.beans.AccountNotFoundException;
import com.hsbc.model.beans.InsufficientBalanceException;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class AccountServiceImpl implements AccountService{
	
	public AccountDao dao;
	
	public AccountServiceImpl()
	{
		dao = (AccountDao) UserFactory.getInstance(Type.DAO);
	}

	@Override
	public Account createAccount(Account account) {
		
		Account newAccount = dao.store(account);
		return newAccount;
	}

	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException {
		
		Account account = dao.fetchAccountById(accountNumber);
		if(account==null)
			throw new AccountNotFoundException("Sorry.Account not found!");
		return account;
	}

	@Override
	public Account[] getAllAccounts() {
		
		return dao.fetchAccounts();
	}

	@Override
	public void transfer(int from, int to, double amount) throws InsufficientBalanceException{
		
		Account account1 = dao.fetchAccountById(from);
		Account account2 = dao.fetchAccountById(to);
		
		if(account1.getBalance() < amount)
		{
			throw new InsufficientBalanceException("Insufficient Balance!");
		}
		else
		{
			account1.setBalance(account1.getBalance()-amount);
			account2.setBalance(account2.getBalance()+amount);
		}
		
		
		
		
	}
	
	
	
	

}
