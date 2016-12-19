package com.practice.dp;

public class CatalanNumber {

	public int numberOfBst(int n) {
		int count = 0;
		if (n == 0) {
			return 1;
		}
		for (int i = 1; i <= n; i++) {
			count += (numberOfBst(i - 1) * numberOfBst(n - i));
		}
		return count;
	}

	public static void main(String[] args) {
		CatalanNumber cn = new CatalanNumber();
		System.out.println(cn.numberOfBst(2));
	}

}
