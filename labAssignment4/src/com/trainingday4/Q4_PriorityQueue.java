package com.trainingday4;
import java.util.PriorityQueue;

import java.util.Collections;
import java.util.Comparator;

class Product{
	private int productId;
	private String productName ;
	private double productPrice;
    public Product(int productId, String productName, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }
    @Override
    public String toString() {
        return productName + " (" + productPrice + ") ₹";
    }
    public double getPrice() {
    		return productPrice;
    }
	
}

public class Q4_PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Product> product = new PriorityQueue<>();
		
		product.add(new Product(1,"pen",10.0));
		product.add(new Product(2,"pencile",5.0));
		product.add(new Product(3,"bag",400.0));
		product.add(new Product(4,"notebook",25.0));
		product.add(new Product(5,"laptop",100000.0));
		
        Comparator<Product> ascendingPrice = (p1, p2) -> 
        Double.compare(p1.getPrice(), p2.getPrice());
        
        Comparator<Product> descendingPrice = (p1, p2) -> 
        Double.compare(p2.getPrice(), p1.getPrice());

        
        
		  System.out.println("=== Ascending (Lowest Price First) ===");
	        while (!product.isEmpty()) {
	            System.out.println("Processing product: " + product.poll());
	        }
	}

}
