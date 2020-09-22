package com.hsbc.model.beans;

public class InsufficientBalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public InsufficientBalanceException()
	{
		super("Insufficient Balance:(");
	}
	public InsufficientBalanceException(String msg)
	{
		super(msg);
	}


}
