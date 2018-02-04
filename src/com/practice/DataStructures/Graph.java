package com.practice.DataStructures;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

import com.practice.algorithms.graphs.ShortestPathInUnweightedGraph;

public class Graph {
	private final int maxVertex;
	Vertex[] vertices = null;
	private int[] visited = null;
	int[][] matrix = null;
	int vertexCount;
	Stack<Integer> stack;
	Queue<Integer> queue;

	public Graph(int verticesCount) {
		this.maxVertex = verticesCount;
		vertices = new Vertex[getMaxVertex()];
		setVisited(new int[verticesCount]);
		matrix = new int[verticesCount][verticesCount];
		vertexCount = 0;
		stack = new Stack<Integer>();
		queue = new LinkedList<Integer>();
	}

	public void addVertex(char a) {
		if ((int) a == 0) {
			System.out.println("Null Character Passed: " + a);
			throw new NullPointerException();
		}
		// create a new vertex and add it to the vertices array.
		if (vertexCount >= getMaxVertex()) {
			throw new ArrayStoreException("Cannot store '" + a + "'. Reached maximum length of vertices.");
		} else {
			vertices[vertexCount++] = new Vertex(a);
		}
	}

	public void addEdge(int a, int b) {
		// for bidirectional graphs.

		matrix[a][b] = 1;
		matrix[b][a] = 1;
	}

	public void addEdgeByName(char a, char b) {
		// if I want to be able to add edge by character name,
		// then search the index of character in the matrix and send it here.
		int locA = 0, locB = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (vertices[i].name == a) {
				locA = i;
			}
			if (vertices[i].name == b) {
				locB = i;
			}
		}
		if (vertices[locA].name != a) {
			throw new NoSuchElementException("Element not found: " + a);
		}
		if (vertices[locB].name != b) {
			throw new NoSuchElementException("Element not found: " + b);
		}
		// for bidirectional graphs.
		matrix[locA][locB] = 1;
		matrix[locB][locA] = 1;
	}

	public void displayGraph() {
		System.out.print(" ");
		for (int i = 0; i < vertices.length; i++) {
			System.out.print(" " + vertices[i].name + " ");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(vertices[i].name);
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void displayVertex(int a) {
		System.out.print(" " + vertices[a].name);
	}

	public void displayVertex(Vertex a) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == a)
				System.out.print(" " + vertices[i].name);
		}
	}

	public void resetFlags() {
		for (int i = 0; i < vertexCount; i++)
			getVisited()[i] = 0;
	}

	public int getAdjUnivistedVertex(int v) {
		// iterating all the elements in the vth row to find all the connected
		// vertices, check if the vertices are visited or not. If the vertex is
		// not visited return the position of the vertex else return -1.

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[v][i] == 1 && getVisited()[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Dfs is best used when there is requirement for minimal use of memory space.
	 * it is related to pre-order traversal. 
	 **/

	// Time complexity is O(V^2) when used with Adjacency matrix, where V is the
	// vertices count, and O(V+E) when used with adjacency Lists.
	public void dfs() {
		// mark that vertex as visited in visited array.
		getVisited()[0] = 1;
		displayVertex(0);

		// Start by adding first vertex to the stack.
		stack.push(0);
		while (!stack.isEmpty()) {

			// before popping check if the top element has adjacent unvisited
			// vertices i,e check in visited array with the elements have 0 or
			// not.
			int v = getAdjUnivistedVertex(stack.peek());

			// v = -1 shows that there were no elements that were unvisited or
			// connected.
			if (v == -1) {
				stack.pop();
			} else {
				// v = something shows that there was a vertex in the array
				// that was connected and was not visited.
				getVisited()[v] = 1;
				displayVertex(v);
				stack.push(v);

			}
		}
		// reset flags
		resetFlags();
	}
	/*	 
	 BFS is best to be used in case of
	 1. Finding shortest Paths.
	 2. Spanning forest, connected components, paths, cycles
	 
	 works similar to Level-order traversal.
	 
	 If we know in advance that the solution lies at low depth, then BFS is better
	 but if the solution lies at the maximum depth, then DFS is a better solution.
	 */
	// Time complexity of BFS is O(V^2) when used with Adjacency matrix, where V
	// is the count of the vertices., and O(V+E) when used with adjacency Lists.
	public void bfs() {
		// Add the first vertex or the provided vertex in the queue.
		queue.add(0);

		// mark the added vertex as visited.
		getVisited()[0] = 1;
		displayVertex(0);
		int child;

		// iterate until the queue is empty.
		while (!queue.isEmpty()) {
			int parent = queue.poll();

			// iterate all the child of the parent, until there is no unvisited
			// child remaining.
			while ((child = getAdjUnivistedVertex(parent)) != -1) {
				// if there is an unvisited child, mark it visited and add it to
				// the queue.
				getVisited()[child] = 1;
				displayVertex(child);
				queue.add(child);
			}
		}
		// reset the visited counter.
		resetFlags();
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addVertex('a');
		graph.addVertex('b');
		graph.addVertex('c');
		graph.addVertex('d');
		graph.addVertex('e');
		graph.addVertex('f');
		graph.addVertex('g');
		graph.addVertex('h');
		// graph.addVertex('f');
		graph.addEdge(0, 1);
		graph.addEdgeByName('b', 'c');
		graph.addEdgeByName('c', 'd');
		graph.addEdgeByName('b', 'h');
		graph.addEdgeByName('h', 'e');
		graph.addEdgeByName('c', 'e');
		graph.addEdgeByName('e', 'f');
		graph.addEdgeByName('e', 'g');
		graph.displayGraph();
		System.out.println();
		System.out.print("DFS: ");
		graph.dfs();
		System.out.println();
		System.out.print("BFS: ");
		graph.bfs();
		System.out.println();
		ShortestPathInUnweightedGraph shortestPathInUnweightedGraph = new ShortestPathInUnweightedGraph();
		shortestPathInUnweightedGraph.findShortestPath(graph, 0);
	}

	public int getMaxVertex() {
		return maxVertex;
	}

	public int[] getVisited() {
		return visited;
	}

	public void setVisited(int[] visited) {
		this.visited = visited;
	}
}
