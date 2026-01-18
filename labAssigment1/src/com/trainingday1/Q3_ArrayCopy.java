package com.trainingday1;

public class Q3_ArrayCopy {
	
	public static int[] copyOf(int[] original, int n) {
		
			int[] copy_of_original = new int[n];
			for(int i = 0;i<n ;i++) {
				copy_of_original[i] = original[i];
		}
			return copy_of_original;
	}
	
	
	public static void print(int [] arr, int n) {
		for(int i =0 ;i<n;i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
//		int[] original = {1,23,4,5,77};
		int[] original = {};
		int n = original.length;
		int[] copyArray = copyOf(original,n);
		
		if (original.length == 0) {
			System.out.println("original array is empty ");
			System.out.println("address of original array : " + original); 
			System.out.println("address of original array : " + copyArray);
			return ;
		}

		System.out.println("orignal array: ");
		print(original,n);
	
		System.out.println("copied array: ");
		print(copyArray,n);
		
		
		copyArray[0] = -1;
		System.out.println("copied array after modification: ");
		print(copyArray,n);
		System.out.println("orignal array after modification: ");
		print(original,n);
	
		
	}
}
