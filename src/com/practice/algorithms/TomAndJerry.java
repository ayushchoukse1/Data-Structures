package com.practice.algorithms;

public class TomAndJerry {
	int count = 0;
	int finalXPostion = 0, finalYPosition = 0;

	public void print(int[][] solution) {
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++)
				System.out.print(" " + solution[i][j] + " ");
			System.out.println();
		}
	}

	public boolean isSafe(int[][] maze, int startX, int startY) {
		return (startX >= 0 && startX < maze.length && startY >= 0 && startY < maze.length
				&& maze[startX][startY] == 1);
	}

	public static void main(String[] args) {
		TomAndJerry object = new TomAndJerry();
		int[][] maze = new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 } };
		System.out.println(object.SolveMaze(maze, 3, 2));
	}

	public boolean SolveMaze(int[][] maze, int x, int y) {
		finalXPostion = x - 1;
		finalYPosition = y - 1;
		// Traverse to all the cells in the maze.
		// for each maze check if its it safe to traverse. by calling another
		// method.
		int[][] solution = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		if (SolveMazeUtil(maze, 0, 0, solution) == false) {
			System.out.println("NO path to the destination.");
			return false;
		}
		// print solution.
		print(solution);
		System.out.println(count);
		return true;
	}
	/*public static int minMoves(int[][] maze, int x, int y) {
		// Call a method to find all the paths to x,y with an empty an empty
		// maze for the solution.
		return 0;
	}
	*/
	// This method goes to every cell block in the maze to check
	// all the possible paths to to destination.

	boolean SolveMazeUtil(int[][] maze, int startX, int startY, int[][] solution) {
		// base case.
		if (startX == finalXPostion && startY == finalYPosition) {
			solution[startX][startY] = 1;
			return true;
		}
		// check if the current cell block is safe to traverse or not.
		if (isSafe(maze, startX, startY) == true) {

			solution[startX][startY] = 1;
			count++;
			// check same method for left cell block
			if (SolveMazeUtil(maze, startX + 1, startY, solution)) {
				return true;
			}
			// check the same method for right cell block.
			if (SolveMazeUtil(maze, startX, startY + 1, solution)) {
				return true;
			}
			print(solution);
			// if none of the above moves are working then backtrack and unmark
			// startX and StartY to 0 to indicate that there is no path.
			solution[startX][startY] = 0;
			count--;
			return false;
		}

		return false;
	}

}
