package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

	static void topologicalSortUtil(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		for (int i : adj.get(v)) {
			if (!visited[i])
				topologicalSortUtil(i, adj, visited, stack);
		}
		stack.push(v);
	}

	static void topologicalSort(List<List<Integer>> adj, int V) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				topologicalSortUtil(i, adj, visited, stack);
		}

		System.out.print("Topological sorting of the graph: ");
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		int V = 4;

		List<List<Integer>> adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(3).add(1);
		adj.get(3).add(2);
		topologicalSort(adj, V);
	}
}
