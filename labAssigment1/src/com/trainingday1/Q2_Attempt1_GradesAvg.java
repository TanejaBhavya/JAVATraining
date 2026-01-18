package com.trainingday1;
import java.util.Scanner;

public class Q2_Attempt1_GradesAvg {
	public static void main(String[] args) {
		System.out.println("Enter number of students: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n == 0) {
			System.out.println("Average = 0");
			scan.close();
			return ;
		}
		int[] grades = new int[n+1];
		grades[0]=-1;
		int sum =0;
		for(int i =1;i<n+1;i++) {
			System.out.println("Enter grade for student "+i+" :");
			
			if(!scan.hasNextInt()) {
				System.out.println("Invalid grade. Try again");
				i--;
				scan.next();
			}
			else {
				int temp = scan.nextInt();
				if(temp<0 || temp>100) {
					System.out.println("Invalid grade. Try again");
					i--;
				}
				grades[i]=temp;
				sum+=temp;
			}
			
		}
		scan.close();
		System.out.println((double)sum/n);
		
	}
}
