package com.trainingday2;

abstract class Employee implements Payable{
	private String name;
	private int EmpId;
	Employee(String name, int EmpId){
		this.name = name;
		this.EmpId = EmpId;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return EmpId;
	}
	
//	public abstract double getPayment();
}



class SalariedEmployee extends Employee{
	private double WeeklySalary;
	
	SalariedEmployee(String name, int EmpId, double WeeklySalary){
		super(name, EmpId);
		this.WeeklySalary = WeeklySalary;
	}
	@Override
	public double getPayment(){
		return WeeklySalary;
	}
	
}




class HourlyEmployee extends Employee{
	private double HourlyRate;
	private int HoursWorked;
	
	HourlyEmployee(String name, int EmpId, double HourlySalary, int HoursWorked){
		super(name, EmpId);
		this.HourlyRate = HourlySalary;
		this.HoursWorked = HoursWorked;
	}
	@Override
	public double getPayment(){
		return HourlyRate*HoursWorked;
	}
	
}

class CommissionEmployee extends Employee{
	private double CommissionRate;
	private double TotalSales;
	
	CommissionEmployee(String name, int Id, double CommissionRate, double TotalSales){
		super(name,Id);
		this.CommissionRate = CommissionRate;
		this.TotalSales = TotalSales;
	}
	
	@Override
	public double getPayment() {
		return (CommissionRate*TotalSales) /100;
	}
	
}



public class Q4_EmployeePayment {

}
