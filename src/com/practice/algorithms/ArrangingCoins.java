package com.practice.algorithms;

public class ArrangingCoins {

	public static void main(String[] args) {
		Long[] coins = {(long) 4,(long) 2,(long) 5,(long) 8,(long) 3};
		arrange(coins);
		
	}
	public static void arrange(Long[] coins){
		for (Long long1 : coins) {
			System.out.println((int)(Math.sqrt((8 * long1) + 1) - 1 ) / 2);
		}
		  
	}
}
