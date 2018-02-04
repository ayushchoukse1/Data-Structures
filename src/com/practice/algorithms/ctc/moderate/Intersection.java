package com.practice.algorithms.ctc.moderate;

public class Intersection {
	public Point checkIntersection(Point start1, Point end1, Point start2, Point end2) {
		if (start1 == null || end1 == null || start2 == null || end2 == null) {
			return null;
		}

		if (start1.x > end1.x) {
			swap(start1, end1);
		}
		if (start2.x > end2.x) {
			swap(start2, end2);
		}
		if (start1.x > start2.x) {
			swap(start1, start2);
			swap(end1, end2);
		}
		Line line1 = new Line(start1, end1);
		Line line2 = new Line(start2, end2);

		if (line1.slope == line2.slope) {
			if (line1.yIntercept == line2.yIntercept && isBetween(start1, start2, end1)) {
				return start2;
			}
		}
		double intersectionX = (line2.yIntercept - line1.yIntercept) / (line1.slope - line2.slope);
		double intersectionY = intersectionX * line1.slope + line1.yIntercept;
		Point intersection = new Point(intersectionX, intersectionY);

		// check if within line segment range.
		if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
			return intersection;
		}

		return null;
	}

	private void swap(Point start1, Point end1) {
		double x = start1.x;
		double y = start1.y;
		start1.setLocation(end1.x, end1.y);
		end1.setLocation(x, y);
	}

	private boolean isBetween(Point start, Point middle, Point end) {
		return isBetween(start.x, middle.x, end.x) && isBetween(start.x, middle.x, end.x);
	}

	private boolean isBetween(double start, double middle, double end) {
		if (start > end) {
			return end <= middle && middle <= start;
		} else
			return start <= middle && middle <= end;
	}

	public static void main(String[] args) {
		Intersection inter = new Intersection();
		System.out.println(inter.checkIntersection(new Point(2, 5), new Point(6, 2), new Point(1, 2), new Point(4, 6)).toString());
	}

}
/*
Enacpsulation provided for point and a line for simplicity.
*/
class Point {
	double x;
	double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

class Line {
	Point start;
	Point end;
	Double slope;
	Double yIntercept;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
		this.slope = (end.y - start.y) / (end.x - start.x);
		this.yIntercept = end.y - slope * end.x;
	}

}