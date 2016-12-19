package com.practice.algo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class AddsUpNumberInFiles {
	
	/*
	 *Write a function that adds up integers from a text file.
	 *There is one integer per line.
	 *
	 * For example, this file should give an answer of 34.
	 * 
	 * 10
	 * 5
	 * 8
	 * 2
	 * 9
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please pass the arguments.");
			return;
		}
		File file = new File(args[0]);
		if (!file.isFile()) {
			System.out.println("Please provide a file.");
			return;
		}
		//change file.
		System.out.println(add(file));
		
	}
	
	public static int add(File file ){
		InputStream io = null;
		try {
			io = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int temp=0;
		Scanner sc = new Scanner(io);
		while(sc.hasNext()){
			temp += Integer.parseInt(sc.nextLine());
		}
		return temp;
	}
}
