package com.practice.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

import com.practice.DataStructures.Graph;

public class ShortestPathInUnweightedGraph {
	Queue<Integer> queue;
	int[] distance;

	public ShortestPathInUnweightedGraph() {
		this.queue = new LinkedList<Integer>();
	}

	// This is a modification to BFS for the graphs, with adding the distance
	// with the distance of the previous vertex, every time a new unvisited vertex
	// is encountered.
	public void findShortestPath(Graph graph, int vertex) {
		// initialize distance array with the size of vertices.
		distance = new int[graph.getMaxVertex()];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = -1;
		}
		// Add the first vertex or the provided vertex in the queue.
		queue.add(vertex);
		distance[vertex] = 0;
		// mark the added vertex as visited.
		graph.getVisited()[vertex] = 1;
		graph.displayVertex(0);
		int w, v;

		// iterate until the queue is empty.
		while (!queue.isEmpty()) {
			v = queue.poll();

			// for each unvisited adjacent vertex of the v vertex.
			while ((w = graph.getAdjUnivistedVertex(v)) != -1) {

				// distance == -1 means vertex not visited before
				if (distance[w] == -1) {
					distance[w] = distance[v] + 1;
					graph.getVisited()[w] = 1;
					graph.displayVertex(w);
					queue.add(w);
				}
			}
		}
		for (int i = 0; i < distance.length; i++) {
			System.out.println(distance[i]);
		}
		// reset the visited counter.
		graph.resetFlags();
		queue.clear();
	}
}
