package com.practice.algo;

import java.util.ArrayList;
import java.util.List;

public class FillMissingSequence {
	
	/*
	input 1,2,18,24,37,88,99
	
	output - 1 ,2 ,3-17,18,19-23,24,25-36,37,38-87,88,89-99
	*/
	public List missingSeq(int[] arr){
		List list = new ArrayList();
		if (arr.length == 0) {
			return null;
		}
		for (int i = 0; i < arr.length; i++) {
//			if (i == arr.length - 1) {
//				break;
//			}
			if (arr[i]+1 == arr[i+1]) {
				list.add(arr[i]);
			}
			else{
				list.add(arr[i]);
				list.add((arr[i]+1)+"-"+(arr[i+1]-1));
			}
		}
		System.out.println(list);
	return list;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 18, 24, 37,88,99 };
		FillMissingSequence obj =  new FillMissingSequence();
		obj.missingSeq(arr);
	}

}
