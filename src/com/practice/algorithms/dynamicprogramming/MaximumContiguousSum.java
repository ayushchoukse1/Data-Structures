package com.practice.algorithms.dynamicprogramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaximumContiguousSum {
	static long maximumSum(int[] arr) {
        if(arr == null){return 0;}
        int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
 
		for (int i = 1; i < arr.length; i++) {
			sum[i] = Math.max(arr[i], sum[i - 1] + arr[i]);
			max = Math.max(max, sum[i]);
		}
 
		return max;
    }
	public static void main(String[] args) {
		int[] arr = {4,1,-1,-2,3};
		System.out.println(maximumSum(arr));
		System.out.println(sample(arr));
	}
static long sample(int[] A){
	int newsum=A[0];
    int max=A[0];
    for(int i=1;i<A.length;i++){
        newsum=Math.max(newsum+A[i],A[i]);
        max= Math.max(max, newsum);
    }
    return max;
}
}
