package com.trainingday2;

import java.util.Scanner;

class BookStore {
	Book[] books;
	int count;
//	Book[] books = new Book[10];
//	int count= 0;

	public BookStore() {
		books = new Book[10];
		count = 0;
	}

	public void Add(String title, String author, String ISBN, int quant) {
		try {
			if (count < 10) {
				books[count] = new Book(title, author, ISBN, quant);
				count++;
			} else {
				System.out.println("books storage full!");
			}
		} catch (NegativeInputException e) {
			System.out.println("Book not added: " + e.getMessage());
		}
	}

	public void Sell(String BookTitle, int num) {
		for (int i = 0; i < count; i++) {
			if (books[i].BookTitle.equals(BookTitle)) {
				books[i].Sell(num);
				return;
			}
		}
		System.out.println("book with title: " + BookTitle + " not found");
	}

	public void Order(String Isbn, int num) {
		for (int i = 0; i < count; i++) {
			if (books[i].ISBN.equals(Isbn)) {
				if (!books[i].Add(num)) {
					System.out.println("Order failed due to invalid quantity.");
				}
				return;
			}
		}
		System.out.println("book with ISBN no. : " + Isbn + " not found");
		System.out.println("Press 1 if want to add a new book with ISBN no. :" + Isbn);
		Scanner scan = new Scanner(System.in);
		if (scan.nextInt() == 1) {
//			if(count>=10) {
//				System.out.println("no more books can be added; storage is full");
//				scan.close();
//				return;
//			}
			scan.nextLine();

			System.out.println("enter book title: ");
			String title = scan.nextLine();
//			scan.nextLine();

			System.out.println("enter book Author: ");
			String author = scan.nextLine();
//			scan.nextLine();

			System.out.println("enter book quantity: ");
			int Quantity = scan.nextInt();

			Add(title, author, Isbn, Quantity);

//			books[count] = new Book(title,author,Isbn,Quantity);
			scan.close();
		}
	}

	public void Display() {
		System.out.println("Books present in the bookstore:");
		for (int i = 0; i < count; i++) {
			books[i].Display();
			
//			System.out.println("Title: " + books[i].BookTitle + "; Author: " + books[i].Author + "; ISBN: "
//					+ books[i].ISBN + "; Number of copies avaliable : " + books[i].numOfCopies);
		}
	}

};

public class Q2_PartB_BookStore {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);


	}
}

