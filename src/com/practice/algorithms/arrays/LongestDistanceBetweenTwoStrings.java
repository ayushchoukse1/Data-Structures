package com.practice.algorithms.arrays;

import java.util.HashMap;

public class LongestDistanceBetweenTwoStrings {
	//public static String[] a = { "practice", "makes", "coding", "perfect", "awesome" };
	 public static String[] a = { "a", "c", "b", "a" };

	public int getDistance(String s1, String s2) {
		return 0;
	}
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i<nums.length;i++){
            int temp = nums[i];
            if(map.containsKey(target-temp)){
                result[0]=temp;
                result[1]=map.get(temp);
            }
            map.put(temp,target-temp);
        }
        return result;
    }

	public static int closestS1(String s1) {
		int location = 0;
		for (int i = 0; i < a.length; i++) {
			String string = a[i];
			if (string == s1) {
				location = i;
				break;
			}
		}
		// System.out.println("closestS1 " + (location + 1));
		return location + 1;
	}

	public static int farthestS2(String s2) {
		int location = 0;
		for (int i = 0; i < a.length; i++) {
			String string = a[i];
			if (string == s2) {
				if (i > location) {
					location = i;
				}
			}
		}
		// System.out.println("farthestS2 " + (location + 1));
		return location + 1;
	}

	public static void main(String[] args) {
		LongestDistanceBetweenTwoStrings ld = new LongestDistanceBetweenTwoStrings();
		System.out.println(farthestS2("a") - closestS1("b") - 1);
	}

}
