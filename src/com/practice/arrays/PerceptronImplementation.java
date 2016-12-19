package com.practice.arrays;

import java.text.DecimalFormat;

public class PerceptronImplementation {
	static int MAX_ITERATIONS = 100;
	static double LEARNING_RATE = 0.1;
	static int INSTANCES = 10;
	static int THRESHOLD = 0;

	public static void main(String[] args) {
		double[] weights = new double[INSTANCES + 1];
		double[] x = new double[INSTANCES];
		double[] y = new double[INSTANCES];
		double[] z = new double[INSTANCES];
		int[] output = new int[INSTANCES];
		int result = 0, iterations = 0;
		int error_count;
		double error;

		for (int i = 0; i < INSTANCES / 2; i++) {
			x[i] = getNumber(5, 10);
			y[i] = getNumber(4, 8);
			z[i] = getNumber(2, 9);
			output[i] = 1;
		}

		for (int i = 5; i < INSTANCES; i++) {
			x[i] = getNumber(-1, 3);
			y[i] = getNumber(-4, 2);
			z[i] = getNumber(-3, 5);
			output[i] = -1;
		}

		for (int i = 0; i < INSTANCES; i++) {
			System.out.println(x[i] + "  " + y[i] + "  " + z[i] + "  " + output[i]);
		}

		weights[0] = getNumber(0, 1);
		weights[1] = getNumber(0, 1);
		weights[2] = getNumber(0, 1);
		weights[3] = getNumber(0, 1);

		System.out.println(weights[0] + " " + weights[1] + " " + weights[2] + " " + weights[3]);
		do {
			iterations++;
			error_count = 0;

			for (int i = 0; i < INSTANCES; i++) {
				result = getResult(weights, x[i], y[i], z[i], THRESHOLD);
				error = output[i] - result;
				weights[0] = weights[0] + (LEARNING_RATE * error * x[i]);
				weights[2] = weights[2] + (LEARNING_RATE * error * y[i]);
				weights[3] = weights[3] + (LEARNING_RATE * error * z[i]);
				weights[4] = weights[4] + (LEARNING_RATE * error);

				error_count += 1;
			}

		} while (error_count != 0);

		System.out.println(iterations + "  " + weights[0] + "*x  + " + weights[1] + "*y  +" + weights[2] + "*z  + "
				+ weights[3] + " = 0");
	}

	public static double getNumber(int min, int max) {
		double temp = ((Math.random() * (max - min))) + min;
		DecimalFormat df = new DecimalFormat("#.####");
		String s = df.format(temp);
		double x = Double.parseDouble(s);
		return x;
	}

	public static int getResult(double[] weights, double x, double y, double z, int threshold) {
		double temp = ((weights[0] * x) + (weights[1] * y) + (weights[2] * z) + weights[3]);

		if (temp > threshold) {
			return 1;
		} else {
			return -1;
		}
	}

}
