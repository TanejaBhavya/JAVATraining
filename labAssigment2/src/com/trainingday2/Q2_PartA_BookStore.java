package com.trainingday2;

class Book {
	String BookTitle;
	String Author;
	String ISBN;
	int numOfCopies;

	public Book(String BookTitle, String Author, String ISBN, int numOfCopies) throws NegativeInputException {
		this.BookTitle = BookTitle;
		this.Author = Author;
		this.ISBN = ISBN;
		if (numOfCopies < 0) {
//	        System.out.println("Invalid quantity.");
			throw new NegativeInputException("Quantitiy of book can't be negative");
//	        this.numOfCopies = 0;
		} else {
			this.numOfCopies = numOfCopies;
		}
	}

	public void Display() {
		System.out.println(
				"Title - " + BookTitle + "; Author - " + Author + "; ISBN - " + ISBN + "; Quantity - " + numOfCopies);
	}

	public void Sell(int num) {
		if (num <= 0) {
			System.out.println("Enter a valid quantity to sell.");
			return;
		}
		if (numOfCopies == 0) {
			System.out.println("Book, " + BookTitle + " is out of stock");
			return;
		}
		if (numOfCopies - num < 0) {
			System.out.println(
					num + " Copies of " + BookTitle + " is not avaliable. Only " + numOfCopies + " are avaliable.");
			return;
		} else {
			numOfCopies = numOfCopies - num;
			System.out.println(num + " copy of " + BookTitle + " sold; Number of copies left " + numOfCopies);
		}
	}

	public boolean Add(int num) {
		if (num <= 0) {
			System.out.println("Enter a valid quantity.");
			return false;
		}

		numOfCopies = numOfCopies + num;
		System.out.println(num + " new copies of " + BookTitle + " added to stock. ");
		System.out.println("Total copies : " + numOfCopies);
		return true;
	}
}

public class Q2_PartA_BookStore {
	public static void main(String[] args) {
//		Book B1 = new Book("Wings Of Fire","so","124",-4);
//		B1.Display();
//		B1.Sell(1);
//		B1.Sell(2);
//		B1.Add(-6);
	}
}
