package com.practice.algorithms.misc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		String str = "I am ayush Choukse";
			
			String[] arr = str.split(" ");
			for (int i = arr.length -1 ; i >=0 ; i--) {
				System.out.print(arr[i]+" ");
		}
	}

}
