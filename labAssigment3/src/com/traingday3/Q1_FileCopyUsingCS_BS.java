package com.traingday3;
import java.io.*;
public class Q1_FileCopyUsingCS_BS {
	    public static void main(String[] args) {
	        File source = new File("pic.png");   
	        File destination = new File("charCopy.png");

	        try (FileReader reader = new FileReader(source);
	             FileWriter writer = new FileWriter(destination)) {

	            int ch;
	            while ((ch = reader.read()) != -1) {
	                writer.write(ch);
	            }

	            System.out.println("Character stream copy completed.");

	            System.out.println("Original size: " + source.length());
	            System.out.println("Copied size: " + destination.length());

	        } catch (FileNotFoundException e) {
	            System.out.println("File not found: " + e.getMessage());
	        } catch (IOException e) {
	            System.out.println("I/O Error: " + e.getMessage());
	        }
	    
	    }

}
