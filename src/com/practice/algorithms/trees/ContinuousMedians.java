package com.practice.algorithms.trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedians {

	public double[] findMedian(int[] arr) {
		if (arr.length == 0) {
			return new double[0];
		}
		double[] medians = new double[arr.length];
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -1 * o1.compareTo(o2);
			}

		});

		for (int i = 0; i < medians.length; i++) {
			int number = arr[i];
			addNum(number, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
		return medians;
	}

	private void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerBucket = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerBucket = lowers.size() > highers.size() ? highers : lowers;

		if (biggerBucket.size() - smallerBucket.size() >= 2) {
			smallerBucket.add(biggerBucket.poll());
		}

	}

	private double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		PriorityQueue<Integer> biggerBucket = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerBucket = lowers.size() > highers.size() ? highers : lowers;

		if (biggerBucket.size() == smallerBucket.size()) {
			return ((double) biggerBucket.peek() + smallerBucket.peek()) / 2;
		} else {
			return biggerBucket.peek();
		}
	}

	private void addNum(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr1 = { -1, -2, -3, -4, -5 };
		ContinuousMedians cm = new ContinuousMedians();
		double[] result = cm.findMedian(arr1);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
