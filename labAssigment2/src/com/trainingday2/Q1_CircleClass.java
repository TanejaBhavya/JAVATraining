package com.trainingday2;
//import java.util.Scanner;
 class Circle{
	private double radius =1.0;
	private String colour = "red";

	public Circle(){
		
	}
	
	public Circle(double radius){
		this.radius = radius;
	}

	public Circle(double radius ,String colour){
		this.radius = radius;
		this.colour = colour;
		
	}
	public void getArea() {
		System.out.println("Area of circle is : "+Math.PI*radius*radius);
		
//		Math.PI*radius*radius;
	}
	public void getCirumfrence() {
		System.out.println("Circumference of circle is : " + 2*Math.PI*radius);
//		return 2*Math.PI*radius;
	}
	
	public void getColour() {
		System.out.println("Colour of circle is : " + colour);
//		return 2*Math.PI*radius;
	}
	public void getRadius() {
		System.out.println("The radius of circle is : " + radius);
	}
	
}
 
 
public class Q1_CircleClass {
	public static void main(String[] args) {
//		try {
//			Scanner scan  = new Scanner(System.in);
//			System.out.println("enter a radius: ");
//			int r= scan.nextInt();
//			
//			Circle C1 = new Circle(r);
//			C1.getArea();
//			C1.getCirumfrence();
			
			Circle C1 = new Circle(2.0,"blue");
			C1.getRadius();
			C1.getArea();
			C1.getCirumfrence();
			C1.getColour();
			System.out.println();
			
			Circle C2 = new Circle(2.0);
			C2.getRadius();
			C2.getArea();
			C2.getCirumfrence();
			C2.getColour();
			
			System.out.println();
			Circle C3 = new Circle();
			C3.getRadius();
			C3.getArea();
			C3.getCirumfrence();
			C3.getColour();
			
			
			
			
//		}catch() {
			
//		}
		
	}
}
