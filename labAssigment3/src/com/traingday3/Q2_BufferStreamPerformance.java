package com.traingday3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Q2_BufferStreamPerformance {
    public static void main(String[] args) throws Exception {

        String source = "input.txt";
        String dest1 = "output_without_buffer.txt";
        String dest2 = "output_with_buffer.txt";

        long start1 = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(dest1);

        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }

        fis.close();
        fos.close();

        long end1 = System.currentTimeMillis();
        long timeWithoutBuffer = end1 - start1;

        long start2 = System.currentTimeMillis();

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(dest2));

        while ((data = bis.read()) != -1) {
            bos.write(data);
        }

        bis.close();
        bos.close();

        long end2 = System.currentTimeMillis();
        long timeWithBuffer = end2 - start2;

        System.out.println("Without Buffering: " + timeWithoutBuffer + " ms");
        System.out.println("With Buffering: " + timeWithBuffer + " ms");
        System.out.println("Performance improved by: " +
                (timeWithoutBuffer - timeWithBuffer) + " ms");
    }
}
