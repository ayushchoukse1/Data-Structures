package com.practice.algorithms.ctc.moderate;

import java.util.ArrayList;

public class PondSize {
	public ArrayList<Integer> getPondSize(int[][] pond) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < pond.length; i++) {
			for (int j = 0; j < pond[0].length; j++) {
				if (pond[i][j] == 0) {
					list.add(getSize(pond, i, j));

				}
			}
		}
		return list;
	}

	private Integer getSize(int[][] pond, int i, int j) {
		if (i < 0 || j < 0 || i >= pond.length || j >= pond[0].length || pond[i][j] != 0) {
			return 0;
		}
		int size = 1;
		pond[i][j] = -1; // mark as visited.
		for (int k = -1; k <= 1; k++) {
			for (int k2 = -1; k2 <= 1; k2++) {
				size += getSize(pond, i + k, j + k2);
			}
		}
		return size;
	}

	public static void main(String[] args) {
		PondSize ps = new PondSize();
		int[][] pond = { { 0, 2, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } };
		System.out.println(ps.getPondSize(pond));
	}

}
