package com.trainingday1;
import java.util.Scanner;
public class Q5_DateCalculator {
	

	public static void main(String[] args) {
//		boolean checkable = false;
//		while (checkable) {
//		try {
		int date, month, year;
		int [] num_days = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter day: ");
		date = scan.nextInt();
		System.out.println("Enter month: ");
		month = scan.nextInt();
		System.out.println("Enter year: ");
		year = scan.nextInt();
//	}
//}		
		scan.close();
		if(year<0) {
			System.out.println("Year invalid");
			return;
		}
		boolean isLeap = false;
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			isLeap = true;
		}
		


		if(month >12 || month <1) {
			System.out.println("Month invalid");
			return;
		}
		if(isLeap == true) {
			num_days[1] = 29;
		}
		if(date<=0 || num_days[month-1] < date ) {
			System.out.println("Date invalid");
			return;
		}
			
			System.out.println("Today is : "+ date+"/" + month+"/"+year);
		
		
		
		
//		NextDay(date,month,year);
//		int NDate, NMonth, NYear;
		
		if(date == num_days[month-1])	{
			date=1;
//			NDate =1;
			if(month == 12) 	{
				month =1;
				year++;
			}
			else
			month++;
		}
		else {
			date++;
		}
		
		System.out.println("Next day is: " + date+"/"+month+"/"+ year);
//		System.out.println("Next day is: " + NDate+"/"+NMonth+"/"+ NYear);
		
		
		

	}

}



//Great question — this shows you’re thinking in the **right OO direction** 👍
//You’re correct: **Java is pass-by-value**, so a `void` method cannot “modify” primitive variables (`int`) in the caller.
//
//But in Java, there are **clean and standard ways** to handle this.
//
//---
//
//## ✅ Best & Common Solutions
//
//### ⭐ **Solution 1: Return an Object (BEST PRACTICE)**
//
//Create a small class to hold `date`, `month`, and `year`.
//
//### Step 1: Create a Date class
//
//```java
//class DateResult {
//    int day;
//    int month;
//    int year;
//
//    DateResult(int day, int month, int year) {
//        this.day = day;
//        this.month = month;
//        this.year = year;
//    }
//}
//```
//
//### Step 2: Method returns the object
//
//```java
//static DateResult getNextDate(int day, int month, int year) {
//    int[] num_days = {31,28,31,30,31,30,31,31,30,31,30,31};
//
//    boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
//    if (isLeap) num_days[1] = 29;
//
//    if (day == num_days[month - 1]) {
//        day = 1;
//        if (month == 12) {
//            month = 1;
//            year++;
//        } else {
//            month++;
//        }
//    } else {
//        day++;
//    }
//
//    return new DateResult(day, month, year);
//}
//```
//
//### Step 3: Use it
//
//```java
//DateResult next = getNextDate(date, month, year);
//System.out.println(next.day + "/" + next.month + "/" + next.year);
//```
//
//✔️ Clean
//✔️ Scalable
//✔️ Object-Oriented
//
//---
//
//## ✅ Solution 2: Return an `int[]` (Simple but less clean)
//
//```java
//static int[] getNextDate(int day, int month, int year) {
//    // calculate next date
//    return new int[]{day, month, year};
//}
//```
//
//Usage:
//
//```java
//int[] next = getNextDate(date, month, year);
//System.out.println(next[0] + "/" + next[1] + "/" + next[2]);
//```
//
//⚠️ Works, but:
//
//* No meaning attached to indices
//* Easy to misuse
//
//---
//
//## ✅ Solution 3: Use a Wrapper Object (Mutable Object)
//
//```java
//class MutableDate {
//    int day, month, year;
//}
//```
//
//```java
//static void getNextDate(MutableDate d) {
//    // modify d.day, d.month, d.year
//}
//```
//
//Usage:
//
//```java
//MutableDate d = new MutableDate();
//d.day = date;
//d.month = month;
//d.year = year;
//
//getNextDate(d);
//```
//
//✔️ Demonstrates pass-by-value of object references
//⚠️ More advanced, less beginner-friendly
//
//---
//
//## ❌ What NOT to Do
//
//* Global variables
//* Static fields for date/month/year
//* Trying to “pass by reference” primitives (Java doesn’t allow it)
//
//---
//
//## 🧠 Important Concept (Very Useful for Interviews)
//
//> Java is **pass-by-value**, but when passing objects, the **value is the reference**, so the object’s contents can be modified.
//
//---
//
//## ⭐ Recommendation for YOU
//
//Given your current code and learning stage:
//
//👉 **Use Solution 1 (return an object)**
//It matches:
//
//* Clean design
//* Real Java style
//* Interview expectations
//
//If you want, I can **refactor your entire program** using:
//
//* Validation methods
//* `getNextDate()` function
//* Or show the **same problem using `LocalDate`**
//
//Just tell me 🙂

//A **UML diagram** is a **visual way to draw and explain how a program is structured and how its parts relate to each other**.
//
//UML stands for **Unified Modeling Language**.
//
//Think of it as a **blueprint** 🏗️ for software — just like architects draw building plans before construction.
//
//---
//
//## Why UML is used
//
//* To **plan code before writing it**
//* To **understand existing code**
//* To **communicate design** with other developers
//* To show **classes, objects, and relationships** clearly
//
//---
//
//## Most common UML diagram (Class Diagram)
//
//Since you’re learning Java, this is the **most important one**.
//
//### Example (simple Java class)
//
//```java
//class DateResult {
//    int day;
//    int month;
//    int year;
//
//    DateResult(int d, int m, int y) {
//        day = d;
//        month = m;
//        year = y;
//    }
//}
//```
//
//### UML Class Diagram for this
//
//```
//-------------------------
//|      DateResult       |
//-------------------------
//| - day   : int         |
//| - month: int          |
//| - year : int          |
//-------------------------
//| + DateResult(d,m,y)   |
//-------------------------
//```
//
//---
//
//## How to read this
//
//### 1️⃣ Class name (top box)
//
//```
//DateResult
//```
//
//---
//
//### 2️⃣ Attributes / Fields (middle box)
//
//```
//day   : int
//month : int
//year  : int
//```
//
//* `int` → data type
//* `-` means **private** (usually)
//* `+` means **public**
//
//---
//
//### 3️⃣ Methods / Constructors (bottom box)
//
//```
//DateResult(d,m,y)
//```
//
//This is the constructor.
//
//---
//
//## UML Symbols (Important)
//
//| Symbol | Meaning   |
//| ------ | --------- |
//| `+`    | public    |
//| `-`    | private   |
//| `#`    | protected |
//| `:`    | type      |
//| `()`   | method    |
//
//---
//
//## UML Diagram for your Date Calculator idea
//
//```
//--------------------------------
//|       DateCalculator         |
//--------------------------------
//|                              |
//--------------------------------
//| + getNextDate(d,m,y):DateResult |
//--------------------------------
//            |
//            |
//            v
//-------------------------
//|      DateResult       |
//-------------------------
//| - day   : int         |
//| - month: int         |
//| - year : int         |
//-------------------------
//```
//
//This shows:
//
//* `DateCalculator` **uses** `DateResult`
//* `getNextDate()` **returns** a `DateResult` object
//
//---
//
//## Do you *need* UML as a beginner?
//
//👉 **For exams, interviews, and design thinking — YES**
//👉 **For small programs — OPTIONAL**
//
//But learning UML now will make:
//
//* OOP concepts clearer
//* Code design easier
//* Interviews much easier later
//
//---
//
//## Types of UML diagrams (FYI)
//
//You don’t need all now, but just to know:
//
//* **Class diagram** ✅ (most important for Java)
//* Use case diagram
//* Sequence diagram
//* Activity diagram
//* Object diagram
//
//---
//
//## Simple way to remember
//
//> **Code = implementation**
//> **UML = picture of the code**
//
//If you want, I can:
//
//* Draw UML for **your full date program**
//* Help you **convert UML → Java code**
//* Explain **UML vs flowchart** differences



