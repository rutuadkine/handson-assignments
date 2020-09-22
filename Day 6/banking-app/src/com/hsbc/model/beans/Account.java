package com.hsbc.model.beans;

public class Account {
	
	private int accountNumber;
	private String customerName;
	private double balance;
	private long contactNumber;
	// generate account number at the time of object creation
	// generate required constructors, getters & setters
	
	public static int AccountCount = 1;
	
	public Account(int accountNumber)
	{
		super();
		this.accountNumber = accountNumber;
		AccountCount++;
	}
	

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerName=" + customerName + ", balance=" + balance
				+ ", contactNumber=" + contactNumber + "]";
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	
}
