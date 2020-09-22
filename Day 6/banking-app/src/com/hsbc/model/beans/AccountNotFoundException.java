package com.hsbc.model.beans;

// Add constructors inside AccountNotFoundException
public class AccountNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccountNotFoundException()
	{
		super("Account not found");
	}
	public AccountNotFoundException(String msg)
	{
		super(msg);
	}

}
