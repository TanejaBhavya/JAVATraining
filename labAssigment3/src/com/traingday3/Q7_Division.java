package com.traingday3;
import java.util.Scanner;
public class Q7_Division {
	public static void main(String[] args) {
		try(Scanner Scan = new Scanner(System.in);) {
			
			System.out.println("Enter an integer : ");
			int a = Scan.nextInt();
			
			System.out.println("Enter another integer : ");
			int b = Scan.nextInt();
			
			if(b==0) {
				
			}
			
			System.out.println("The quotient of " + a + "/" + b + " = " + (float)a/b);
			
		}
		catch(ArithmeticException e ){
			System.out.println("Can't divide by zero");
		}
		
		finally {
			System.out.println("this is finally block");
		}
		
		
		
	}
}
