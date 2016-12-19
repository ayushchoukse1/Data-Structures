package com.practice.dp;

public class MinimumJumpsToTheEnd {
	public int minJump(int[] arr) {
		int[] jump = new int[arr.length];
		int[] result = new int[arr.length];
		jump[0]=0;
		for (int i = 1; i < jump.length; i++) {
			jump[i] = Integer.MAX_VALUE - 1;
			// System.out.println(jump[i]);
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i) {
					if (jump[i] > jump[j] + 1) {
						result[i] = j;
						jump[i] = jump[j] + 1;
					}
				}
			}
		}
		for (int i = 0; i < jump.length; i++) {
			System.out.println(jump[i]);
		}
		return result[jump.length - 1];
	}

	public static void main(String[] args) {
		int[] arr = {2,3,1,1,2,4,2,0,1,1};
		MinimumJumpsToTheEnd mje = new MinimumJumpsToTheEnd();
		System.out.println(mje.minJump(arr));
	}

}
