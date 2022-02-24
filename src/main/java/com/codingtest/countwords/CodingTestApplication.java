package com.codingtest.countwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingTestApplication {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		SpringApplication.run(CodingTestApplication.class, args);
		
		
		List<String> bunchOfWords = new ArrayList<>(); 
		
//		 File file = new File(
//		            "C:\\Users\\vemman01\\OneDrive - CSG Systems Inc\\Desktop\\Mani.txt");
//		 String path = "./properties.txt";
		 File file = new File(
		            "./input.txt");
		       
		        BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
		       
		        String st ;
		        StringBuilder lines = new StringBuilder();
		        
		        while ((st = br.readLine()) != null)
		        {
		        	lines.append(st);
		        }
		        
		        bunchOfWords = Arrays.asList(lines.toString().split(","));		
//		        bunchOfWords = Arrays.asList("Manideep","moon","Mcdonalds","match","Make","monkey");
		List<String> qualifiedWords = CountWords(bunchOfWords);
		System.out.println("Total number of Words matching the criteria are : "+qualifiedWords.size()+ 
				" and the words are"+qualifiedWords.toString()); 
//		-- logger
		
	}
	
	/**
	 * This method is intended to filter words which start with M and m
	 * However word will be counted if it length is greater than 5.
	 * 
	 * @param bunchofWords list of words to find the qualified words
	 */
	public static List<String> CountWords(List<String> bunchofWords) {
		
		List<String> mOrM = new ArrayList<>();
		
		for(String word : bunchofWords)
		{
			char firstLetter = word.charAt(0);
			
			if((firstLetter == 'M' || firstLetter == 'm') && (word.length() > 5))
			{
				mOrM.add(word);
			}
		}
		
		return mOrM;
		
	}

}
