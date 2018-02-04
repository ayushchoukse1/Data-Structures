package com.practice.algorithms.backtracking;

public class PathInNxNMatrix {
	public boolean solveMaze(int[][] maze) {
		int[][] sol = new int[maze.length][maze[0].length];
		if (!solveMazeUtil(maze, 0, 0, sol)) {
			return false;
		}
		printSol(sol);
		return true;
	}

	private void printSol(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}
	}

	private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		if (x == maze.length - 1 && y == maze[0].length - 1) {
			sol[x][y] = 1;
			return true;
		}
		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			if (solveMazeUtil(maze, x, y + 1, sol)) {
				return true;
			}
			if (solveMazeUtil(maze, x + 1, y, sol)) {
				return true;
			}
			sol[x][y] = 0;
			return false;
		}
		return false;
	}

	private boolean isSafe(int[][] maze, int x, int y) {
		if (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 1, 0, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0, }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 1, 1 } };
		PathInNxNMatrix pnnm = new PathInNxNMatrix();
		System.out.println(pnnm.solveMaze(maze));
	}

}
