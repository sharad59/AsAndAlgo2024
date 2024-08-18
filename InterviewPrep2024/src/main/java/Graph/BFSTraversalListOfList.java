package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversalListOfList {

	public static void main(String[] args) {
		int V = 6;
		List<List<Integer>> adj = new ArrayList<>(V);

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);

		bfsDisconnected(adj);
	}

	public static void bfsDisconnected(List<List<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()]; // Not visited

		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i]) {
				bfs(adj, i, visited);
			}
		}
	}

	public static void bfs(List<List<Integer>> adj, int s, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();

		visited[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");

			for (int x : adj.get(curr)) {
				if (!visited[x]) {
					visited[x] = true;
					q.add(x);
				}
			}
		}
	}

	public static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u); 
	}

}
