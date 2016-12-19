package com.practice.backtracking;

class Position {
	int col;
	int row;

	public Position(int col, int row) {
		super();
		this.col = col;
		this.row = row;
	}

	@Override
	public String toString() {
		return "Position [col=" + col + ", row=" 	+ row + "]";
	}

}

public class NQueensProblem {
	public Position[] solveNQueenProblem(int n) {
		Position[] positions = new Position[n];
		boolean result = solveNQueenProblemUtil(n, 0, positions);

		if (result) {
			return positions;

		} else {
			return new Position[0];
		}
	}

	private boolean solveNQueenProblemUtil(int n, int row, Position[] positions) {
		if (n == row) {
			return true; // base condition.
		}

		for (int col = 0; col < n; col++) {
			boolean foundSafe = true;
			for (int queen = 0; queen < row; queen++) {
				if (positions[queen].col == col || positions[queen].row == row
						|| positions[queen].row + positions[queen].col == row + col
						|| positions[queen].row - positions[queen].col == row - col) {
					foundSafe = false;
					break;
				}
			}
			if (foundSafe) {
				positions[row] = new Position(col, row);
				if (solveNQueenProblemUtil(n, row + 1, positions)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NQueensProblem nqp = new NQueensProblem();
		Position[] pos = nqp.solveNQueenProblem(4);
		for (int i = 0; i < pos.length; i++) {
			System.out.println(pos[i].toString());
		}
	}

}
