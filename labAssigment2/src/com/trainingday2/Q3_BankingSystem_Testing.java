package com.trainingday2;

public class Q3_BankingSystem_Testing {
	public static void main(String[] args) {
		
		
		
		Account A1_savings = new SavingsAccount("Rahul", 1234, 0);
//		SavingsAccount A3 = new SavingsAccount("Ram", 3423, 4000);
		Account A2_current = new CurrentAccount("Laxmi", 3432, 500);
		try {
			A1_savings.Deposit(6000);
			A2_current.Deposit(400);
			A1_savings.Deposit(-700);
		}catch(NegativeInputException e) {
			System.out.println("invalide amount");
		}
		System.out.println("Current balance of Account number " + A1_savings.getAccNumber() + " is : " +A1_savings.getBalance());
		System.out.println("Current balance of Account number "+ A2_current.getAccNumber() + " is " + A2_current.getBalance());
		System.out.println("---------------------------------------------------------------------------");
		
		A1_savings.Withdraw(40000);
		A2_current.Withdraw(9000);
		A1_savings.Withdraw(90);
		System.out.println("Current balance of Account number " + A1_savings.getAccNumber() + " is : " +A1_savings.getBalance());
		System.out.println("Current balance of Account number "+ A2_current.getAccNumber() + " is " + A2_current.getBalance());
		System.out.println("---------------------------------------------------------------------------");
		
		
	}
}
