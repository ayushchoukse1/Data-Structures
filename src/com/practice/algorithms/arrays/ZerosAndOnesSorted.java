package com.practice.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ZerosAndOnesSorted {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 };
		int[] arr1 = { 1, 2, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2, 1, 0, 2, 1 };
		ZerosAndOnesSorted zerosAndOnesSorted = new ZerosAndOnesSorted();
		zerosAndOnesSorted.move(arr);
		System.out.println();
		zerosAndOnesSorted.moveTwos(arr1);
	}

	// 1,0,1,0,1,0,1,0,1,0,1,0,1
	// separating 0's and 1's using counter in single scan.
	public void move(int[] nums) {
		int len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                len++;
            }else{
                int temp = nums[i];
                nums[i]= nums[i-len];
                nums[i-len]=temp;
            } 
        }     
		for (int i : nums) {
			System.out.print(i);
		}
	}

	// sort 0's ,1's, 2's in O(n) using single space complexity.
	public void moveTwos(int[] array) {
		int count = 0;
		int c = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				count++;
			} else {
				int temp = 0;
				temp = array[i - count];
				array[i - count] = array[i];
				array[i] = temp;
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 2) {
				c++;
			} else {
				int temp = 0;
				temp = array[i - c];
				array[i - c] = array[i];
				array[i] = temp;
			}
		}
//		Collections.reverse(Arrays.asList(array));
		for (int i = 0; i < array.length / 2; i++) {
			  int temp = array[i];
			  array[i] = array[array.length - 1 - i];
			  array[array.length - 1 - i] = temp;
			}
		for (int i : array) {
			System.out.print(i);
		}
	}
}
