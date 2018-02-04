package com.practice.algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

class Job {
	int start;
	int end;
	int profit;

	public Job(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.profit = weight;
	}

	@Override
	public String toString() {
		return "Job [start=" + start + ", end=" + end + ", profit=" + profit + "]";
	}

}

class MyCustomComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		return o1.end <= o2.end ? -1 : 1;
	}

}

public class WeightedJobScheduling {

	public int schedule(Job[] jobs) {

		// create new array for profit.
		int[] T = new int[jobs.length];
		Arrays.sort(jobs, new MyCustomComparator());
		T[0] = jobs[0].profit;
		for (int i = 0; i < jobs.length; i++) {
			System.out.println(jobs[i].toString());
		}
		for (int i = 1; i < jobs.length; i++) {
			T[i] = Math.max(jobs[i].profit, T[i - 1]);
			for (int j = i - 1; j >= 0; j--) {
				if (jobs[j].end <= jobs[i].start) {
					T[i] = Math.max(T[i], T[j] + jobs[i].profit);
					break;
				}
			}
		}
		int max = T[0];
		for (int i = 1; i < T.length; i++) {
			if (T[i] > max) {
				max = T[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		WeightedJobScheduling wjs = new WeightedJobScheduling();
		Job[] jobs = new Job[6];
		jobs[0] = new Job(1, 3, 5);
		jobs[1] = new Job(2, 5, 6);
		jobs[2] = new Job(4, 6, 5);
		jobs[3] = new Job(6, 7, 4);
		jobs[4] = new Job(5, 8, 11);
		jobs[5] = new Job(7, 9, 2);

		System.out.println(wjs.schedule(jobs));

	}

}
