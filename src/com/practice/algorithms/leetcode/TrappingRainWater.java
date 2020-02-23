package com.practice.algorithms.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrappingRainWater {

	/*	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	
		For example, 
		Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	*/

	public int trap(int[] height) {
		int[] l = new int[height.length];
		int[] r = new int[height.length];
		int[] r1 = new int[height.length];
		int m = height[0];
		l[0] = 0;
		for (int i = 1; i < l.length; i++) {
			l[i] = Math.max(m, l[i-1]);
			m = Math.max(height[i], m);
		}
		
		int[] newHeights = reverse(height);
		int m1 = newHeights[0];
		r[0] = 0;
		for (int i = 1; i < r.length; i++) {
			r[i] = Math.max(m1, r[i-1]);
			m1= Math.max(newHeights[i], m1);
		}
		r1 = reverse(r);
		int[] sol = new int[height.length];
		sol[0]=0;
		sol[sol.length -1] =0;
		for (int i = 1; i < sol.length -1; i++) {
			sol[i] = Math.min(l[i], r1[i]) - height[i];
		}
		int sum=0;
		for (int i = 0; i < sol.length; i++) {
			if (sol[i]>0) {
				sum+=sol[i];
			}
		}
		return sum;
	}

	public int trap1(int[] height) {
	    int result = 0;
	 
	    if(height==null || height.length<=2)
	        return result;
	 
	    int left[] = new int[height.length];
	    int right[]= new int[height.length];
	 
	    //scan from left to right
	    int max = height[0];
	    left[0] = height[0];
	    for(int i=1; i<height.length; i++){
	        if(height[i]<max){
	            left[i]=max;
	        }else{
	            left[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //scan from right to left
	    max = height[height.length-1];
	    right[height.length-1]=height[height.length-1];
	    for(int i=height.length-2; i>=0; i--){
	        if(height[i]<max){
	            right[i]=max;
	        }else{
	            right[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //calculate totoal
	    for(int i=0; i<height.length; i++){
	        result+= Math.min(left[i],right[i])-height[i];
	    }
	 
	    return result;
	}
	public int[] reverse(int[] arr) {
		int[] heights = arr;
		for (int k = 0; k < heights.length / 2; k++) {
			int temp = heights[k];
			heights[k] = heights[heights.length - (1 + k)];
			heights[heights.length - (1 + k)] = temp;
		}
		return heights;
	}

	public static void main(String[] args) {
		int[] heights1 = {5,2,4,2,6,2,3,5};
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater trw = new TrappingRainWater();
//		trw.trap(heights);
		System.out.println(trw.trap1(heights1));
	}

}
