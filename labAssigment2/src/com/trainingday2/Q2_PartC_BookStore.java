package com.trainingday2;

public class Q2_PartC_BookStore {
	public static void main(String[] args) {
		BookStore BS = new BookStore();
		BS.Add("Wings of Fire", "A. P. J. Abdul Kalam", "ISBN001", 5);
		BS.Add("Effective Java", "Joshua Bloch", "ISBN002", 3);
		BS.Add("Clean Code", "Robert C. Martin", "ISBN003", 4);
		BS.Add("Java: The Complete Reference", "Herbert Schildt", "ISBN004", 6);
		BS.Add("Head First Java", "Kathy Sierra", "ISBN005", 2);
		BS.Add("The Alchemist", "Paulo Coelho", "ISBN006", 7);
		BS.Add("Introduction to Algorithms", "Thomas H. Cormen", "ISBN007", 1);

		BS.Display();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		BS.Order("ISBN004", -9);
		BS.Order("cartoon", 2);
		BS.Display();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		BS.Sell("Introduction to Algorithms", 1);
		BS.Display();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		BS.Sell("Introduction to Algorithms", 1);
		BS.Display();
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		BS.Sell("Head First Java", 3);
	}
	
}
