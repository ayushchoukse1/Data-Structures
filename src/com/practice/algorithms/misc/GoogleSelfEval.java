package com.practice.algorithms.misc;

public class GoogleSelfEval {

	/*
	 * 
	 * A sample state of ‘a’: [[2, NULL, 2, NULL], [2, NULL, 2, NULL], [NULL, NULL,
	 * NULL, NULL], [NULL, NULL, NULL, NULL]] FUNCTION foo() FOR y = 0 to 3 FOR x =
	 * 0 to 3 IF a[x+1][y] != NULL IF a[x+1][y] = a[x][y]: a[x][y] := a[x][y]*2
	 * a[x+1][y] := NULL END IF IF a[x][y] = NULL a[x][y] := a[x+1][y] a[x+1][y] :=
	 * NULL END IF END IF END FOR END FOR END FUNCTION
	 * 
	 */
	public static int a[][] = { { 2, 0, 2, 0 }, { 2, 0, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j]=0;
			}
		}
	}

	public static void foo() {

	}
}
