package com.trainingday1;

public class Q1_FibonacciSeries {

	public static void main(String[] args) {
		int [] array = new int[21];
		array[0]=0;
		array[1]=1;
		int sum = 1;
		for(int i =2;i<=20;i++) {
			array[i]=array[i-1]+array[i-2];
			sum+=array[i];
			
		}
		for(int num:array) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("Average is: " + (float)sum/array.length);
	}

}
