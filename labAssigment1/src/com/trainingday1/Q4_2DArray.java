package com.trainingday1;

public class Q4_2DArray {
public static void prints(int[][] array) {
	for(int row = 0;row<8;row++) {
		for(int col = 0; col<8;col++) {
			if(col<=row) {
				System.out.print(array[row][col]+" ");
			}
		}
		System.out.println();
	}
}
	
	public static void main(String[] args) {
		int [][] triangle = new int[9][9];
		
		for(int row = 0;row<8;row++) {
			for(int col = 0; col<8;col++) {
				if(col<=row) {
					triangle[row][col] = col+1;
				}
			}
		}
		prints(triangle);
	}
}
