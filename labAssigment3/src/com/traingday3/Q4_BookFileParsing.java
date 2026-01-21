package com.traingday3;
import java.io.*;
import java.util.LinkedList;


class BookInventory{
	private LinkedList<Q4_Book> list;
//	= new LinkedList<>();
	BookInventory(){
		list = new LinkedList<>();
	}
	
	
	public void addBook(Q4_Book B) {
		list.add(B);
	}
	
	public void searchBook_withId(int id) {
		for(Q4_Book  B : list) {
			if (B.getId()==id) {
				System.out.println("Book with id " + id +" found!");
				System.out.println("Details of book: ");
				B.Display();
				return;
			}
		}
		System.out.println("Book with id " + id + " not found");
	}
	
	public Q4_Book searchBook_withISBN(String isbn) {
		for(Q4_Book  B : list) {
			if (B.getIsbn().equals(isbn)) {
				return B;
			}
		}
		System.out.println("Book with id " + isbn + " not found");
		return null;
	}
	
	public void sellBook(String isbn, int quantity){
			Q4_Book B = searchBook_withISBN(isbn);
			if(B==null) {
				System.out.println("Book not found");
				return;
			}
			B.Sell(quantity);
	}
	public void purchase(String isbn, int quantity) {
	    Q4_Book B = searchBook_withISBN(isbn);
	    if (B == null) {
	        System.out.println("Cannot purchase. Book not found.");
	        return;
	    }
	    B.Add(quantity);
	}

	
	public void seeInventory() {
		for(Q4_Book B : list) {
			B.Display();
		}
	}
	
}


public class Q4_BookFileParsing {
	    public static void main(String[] args)  {
	    		try {
					BufferedReader br = new BufferedReader(new FileReader("book.txt"));
					
					String Line; 
					
					BookInventory bookList = new BookInventory();
					
					
					while((Line = br.readLine())!=null){
						String[] section = Line.trim().split(":");
						int id  = Integer.parseInt(section[0]);
						String isbn = section[1];
						String title = section[2];
						String author = section[3];
						int copies = Integer.parseInt(section[4]);
						
						try {
							bookList.addBook(new Q4_Book(title, id, isbn, copies,author));
						} catch (NegativeInputException e) {
							System.out.println(e.getMessage());
						}
		
					}
					bookList.seeInventory();
					bookList.searchBook_withId(121);
					
					
					bookList.purchase("B234",50);
					bookList.seeInventory();
					
					bookList.sellBook("S234", 40);
					bookList.seeInventory();
					
					
					
					
					
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
//					e.printStackTrace();
				}
	    			catch(IOException e) {
	    				System.out.println(e.getMessage());
	    			}
	    		
	    		
	    		
	    		
	    		
	    }
	}


