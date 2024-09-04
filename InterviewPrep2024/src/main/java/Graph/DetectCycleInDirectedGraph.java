package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

	public static void main(String args[]) {

		int v = 4;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {

			adj.add(new ArrayList<>());}
			adj.get(0).add(1);
			adj.get(1).add(2);
			//adj.get(2).add(0);
			adj.get(2).add(3);
			adj.get(3).add(0);

			if(isCyclic(adj,v)) {
				System.out.println("contains cycle");
			}
			else
				System.out.println("does not contain cycle");
			System.out.println(isCycle(adj, v));
		}
	

	private static boolean isCyclic(List<List<Integer>> adj, int v) {
		boolean st[] = new boolean[v];
		boolean visited[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i] && isCyclicUtil(adj, i,  visited, st)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicUtil(List<List<Integer>> adj, int i, boolean[] visited, boolean[] st) {
		if (!visited[i]) {
			visited[i] = true;
			st[i] = true;
			for (int x : adj.get(i)) {
				if (!visited[x] && isCyclicUtil(adj, x, visited, st)) {
					return true;
				} else if (st[x])
					return true;
			}

		}
		st[i] = false;
		return false;
	}
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//BFS traversal
	
	static boolean  isCycle(List<List<Integer>> adj, int v) {

		int inDegree[] = new int[v];

		for (int i = 0; i < v; i++) {
			for (int j : adj.get(i)) {
				inDegree[j]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}
		
		int count = 0;
		List<Integer> top = new ArrayList<>();

		while (!q.isEmpty()) {
			int u = q.poll();
			top.add(u);
			count++;
			for (int itr : adj.get(u)) {
				inDegree[itr]--;
				if (inDegree[itr] == 0) {
					q.add(itr);
				}
			}

		}
		if (count != v) {
			return true;
		} else
			return false;

	}
}
