package com.trainingday1;

import java.util.Scanner;

public class Q2_Attempt2_GradesAvg {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of students: ");
		int n = scan.nextInt();
		int[] grade = new int[n + 1];
		grade[0] = -1;
		int sum = 0;
		int temp;
		for (int i = 1; i <= n; i++) {
			System.out.println("enter the grade of students: " + i);
			boolean valid_marks = false;
			while (valid_marks == false) {

				try {
					temp = scan.nextInt();
					if (temp < 0 || temp > 100) {
						throw new ExceededLimitsException("Invalid grade, enter a value between 0 and 100");
					}
					sum += temp;
					grade[i] = temp;
					valid_marks = true;
				} catch (ExceededLimitsException e) {
					System.out.println(e.getMessage());
				}
			}

		}
		scan.close();
		System.out.println((double) sum / n);
	}
}
