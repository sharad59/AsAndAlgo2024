package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
	int vertices;
	LinkedList<Integer>[] adjList;

	BFSTraversal(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i)
			adjList[i] = new LinkedList<>();
	}

	void addEdge(int u, int v) {
		adjList[u].add(v);
	}
 
	void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[vertices];
		visited[startNode] = true;
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			System.out.print(currentNode + " ");

			// Get all adjacent vertices of the dequeued
			// vertex currentNode If an adjacent has not
			// been visited, then mark it visited and
			// enqueue it
			for (int neighbor : adjList[currentNode]) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		int vertices = 5;
		BFSTraversal graph = new BFSTraversal(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		System.out.print("Breadth First Traversal starting from vertex 0: ");
		graph.bfs(0);
	}
}
