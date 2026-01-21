package com.trainingday4;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;

public class Q1_WordFrequency {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("story.txt"));
			
			String line;
			Map<String,Integer> mp = new HashMap<>();
			
			while((line = br.readLine())!=null) {
				line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
				String[] part = line.trim().split("\\s+");
				for(String p : part) {
					mp.put(p, mp.getOrDefault(p, 0) + 1);
				}
				
			}
			 for (Map.Entry<String, Integer> entry : mp.entrySet()) {
		            System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
		        }
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}