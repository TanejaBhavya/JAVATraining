package com.trainingday2;
import java.util.ArrayList;
class EmployeePaymentApp{
	private ArrayList<Employee> employees =  new ArrayList<>();
	
	public void addHourlyEmployee(String name, int id, double rate, int hours){
		employees.add(new HourlyEmployee(name,id,rate,hours));
	}
	public void addCommissionEmployee(String name, int id, double rate, double sales) {
		employees.add(new CommissionEmployee(name,id,rate,sales));
	}
	public void addSalariedEmployee(String name, int id, double salary) {
		employees.add(new SalariedEmployee(name,id,salary));
	}
	
	public void PrintWeeklySalary() {
		for(Employee emp:employees) {
			System.out.println(" Employee Name: " + emp.getName()+
								"; Employee Id : " + emp.getID()+
								"; Weekly Pay: " + emp.getPayment() +" Rs");
		}
	}

}

public class Q4_EmpolyeePayment_Testing {
	public static void main(String[] args) {
EmployeePaymentApp EmpApp = new EmployeePaymentApp();
		
		EmpApp.addSalariedEmployee("Rahul", 101, 15000);

		EmpApp.addHourlyEmployee("Anita", 102, 500, 40);

		EmpApp.addCommissionEmployee("Vikram", 103, 10, 200000);

		EmpApp.addSalariedEmployee("Priya", 104, 12000);

		EmpApp.addHourlyEmployee("Sanjay", 105, 450, 45);
		
		EmpApp.PrintWeeklySalary();
	}
		

}
