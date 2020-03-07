package com.practice.algorithms.arrays;

import java.io.*;
import java.util.*;

/*
 * Imagine we have an image where every pixel is white or black. 
 * We�ll represent this image as a simple 2D array (0 = black, 1 = white). 
 * The image you get is known to have a single black rectangle on a white background. 
 * Write a function that takes in the image and returns the coordinates of the rectangle 
 * -- either top-left and bottom-right; or top-left, width, and height.
 */

class RectangleCoordinatesIn2DArray {

	// Sample image
	static int[][] image = { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 0, 1 }, { 1, 1, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1 } };

	static int x = 0, y = 0;
	// (x,y coords) [ 3, 2, 5, 3 ]
	// row, column, width, height [ 2, 3, 3, 2 ]
	static int horizontalCounter = 0;
	static int verticalCounter = 0;

	public static void main(String[] args) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
		RectangleCoordinatesIn2DArray sol = new RectangleCoordinatesIn2DArray();
		sol.innerCircle(image);

	}
	/*
	 * 1. scan for the zeroes 2. if image[i][j]==0; then go to step 3. 3.. if
	 * image[i][j] is marked false else if(not marked ) mark the cell
	 * 
	 * return true; 3.
	 * 
	 */

	public void innerCircle(int[][] image) {

		if (image == null) {
			throw new NullPointerException();
		}

		// int i=0,j=0;

		for (int i = 0; i < image.length; i++) {

			for (int j = 0; j < image[i].length; j++) {
				if (image[i][j] == 0) {
					scanRow(i);
				}
			}
		}
		print();
	}

	public void print() {
		System.out.println(horizontalCounter);
		System.out.println(verticalCounter);
		System.out.println(x + " " + y);
	}

	public void scanRow(int i) {

		// scan that entire row.
		for (int j = 0; j < image.length; j++) {
			// System.out.println(i+" "+j);
			if (image[i][j] == 0) {
				if (horizontalCounter == 0) {
					x = j;
					y = i;
				}
				horizontalCounter++;
				scanColumn(j);
			}
			if (image[i][j] == 1) {
				if (horizontalCounter != 0) {
					break;
				}
			}
		}

		// scan that entire column.
	}

	public void scanColumn(int j) {

		for (int i = 0; i < image.length; i++) {

			if (image[i][j] == 0) {
				verticalCounter++;
			}
			if (image[i][j] == 1) {
				if (verticalCounter != 0) {
					break;
				}
			}

		}
	}
}
