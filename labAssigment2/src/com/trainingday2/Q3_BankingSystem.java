package com.trainingday2;

class Account{
	private String Name;
	private double AccNumber;
//	private double AccBalance;
	protected double AccBalance;
	
	Account(String Name, double AccNumber, double AccBalance){
		this.Name=Name;
		this.AccBalance = AccBalance;
		this.AccNumber = AccNumber;
	}
	
//	public double getAmount() {
//		return AccBalance;
//	}
	public double getBalance() {
	return AccBalance;
}
	public void setAmount(double amount) {
		AccBalance = amount;
	}
	public double getAccNumber() {
		return AccNumber;
	}
	public String getName() {
		return Name;
	}
	
	
	
	public void Deposit(double amount) throws NegativeInputException{
		if(amount < 0) throw new NegativeInputException("Amount to be deposited can't be negative");
		AccBalance = AccBalance+amount;
	}
	public void Withdraw(double amount) {
		AccBalance = AccBalance- amount;
	}
	
	
}

class SavingsAccount extends Account{
	final int interest = 5;
	private double MaxWithdrawLimit;
	final int MinBalanceAllowed = 5000;
	
	SavingsAccount(String name, double AccNum, double AccBalance){
		super(name,AccNum,AccBalance);
		MaxWithdrawLimit = getBalance();
	}
	
	@Override
	public void Withdraw(double amount) {
		MaxWithdrawLimit= getBalance();
		if(amount<= MaxWithdrawLimit-MinBalanceAllowed) {
			setAmount(getBalance()-amount);
		}
		else {
			System.out.println("The given amount can't be withdawn because of insufficinet balance");
		}
	}
	
	public double getBalance() {
		return AccBalance + (AccBalance * interest/100);
	}

}


class CurrentAccount extends Account{
	private int TradeLicenseNumber ;
	final private double overdraft = 5000; // assumed value
	
	CurrentAccount(String name, double AccNum, double AccBalance){
		super(name,AccNum,AccBalance);
		
	}
//	
//	public double getBalance() {
//		return getAmount();
//	}
	@Override
	public void Withdraw(double amount) {
		if(amount<= getBalance()+overdraft) {
			setAmount(getBalance()-amount);
		}
		else {
			System.out.println("withdrawal exceeds overdraft limit");
		}
	}
	
}

public class Q3_BankingSystem {
	public static void main(String[] args) {
		
	}
}
