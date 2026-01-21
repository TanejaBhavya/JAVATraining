package com.traingday3;


public class Q4_Book {
	private String BookTitle;
	private int id;
	private String ISBN;
	private String Author;
	private int numOfCopies;

	public Q4_Book(String BookTitle, int id , String ISBN, int numOfCopies, String author) throws NegativeInputException {
		this.BookTitle = BookTitle;
		this.id = id;
		this.ISBN = ISBN;
		this.Author=author;
		if (numOfCopies < 0) {
//	        System.out.println("Invalid quantity.");
			throw new NegativeInputException("Quantitiy of book can't be negative");
//	        this.numOfCopies = 0;
		} else {
			this.numOfCopies = numOfCopies;
		}
	}
	
	public int getId() {
		return id;
	}
	public String getIsbn() {
		return ISBN;
	}

	public void Display() {
		System.out.println(
				"Title - " + BookTitle + "; Author - " + Author + "; id - " + id + "; ISBN - " + ISBN + "; Quantity - " + numOfCopies);
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
