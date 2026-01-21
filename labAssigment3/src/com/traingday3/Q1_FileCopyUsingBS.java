package com.traingday3;
import java.io.*;
public class Q1_FileCopyUsingBS {
	public static void main(String[] args) {
        File source = new File("pic.png");
        File destination = new File("byteCopy.jpg");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("Byte stream copy completed.");

            System.out.println("Original size: " + source.length());
            System.out.println("Copied size: " + destination.length());

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
	}

	    

}
