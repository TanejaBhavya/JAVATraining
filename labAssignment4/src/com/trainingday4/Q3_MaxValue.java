package com.trainingday4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3_MaxValue {
	public static void main(String[] args) {
		List<Double> numberList = new ArrayList<>();
		try(Scanner scan = new Scanner(new File("data.txt"));){
			while(scan.hasNext()) {
				try {
					double value = Double.parseDouble(scan.next());
					numberList.add(value);
				}catch(NumberFormatException e) {
					System.out.println("invalid number.....skipped");
				}
			}
			if(numberList.isEmpty()) {
				System.out.println("File is empty");
			}
			else {
				double max = numberList.get(0);
				for(double num:numberList) {
					if(num>max) {
						max=num;
					}
				}
				System.out.println("Maximum value in list is : " + max);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
