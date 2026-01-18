package com.trainingday2;
import java.util.ArrayList;

public class Q5_UnifiedPaymentSys_PaymentApp {
	public static void main(String[] args) {
		ArrayList<Payable> payList = new ArrayList<>();

		
		payList.add(new SalariedEmployee("Rahul", 101, 15000));
		payList.add(new HourlyEmployee("Anita", 102, 500, 40));
		payList.add(new CommissionEmployee("Vikram", 103, 10, 200000));

		payList.add(new Invoice(001, "Laptop", 2, 50000));
		payList.add(new Invoice(002, "Mouse", 10, 500));
		
		for(Payable pay : payList) {
			System.out.println("Payment made: " + pay.getPayment()+ " Rs");
		}
	}
}
