package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DFSTraversal {
	private int V;

	private LinkedList<Integer> adj[];

	DFSTraversal(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int n : adj[v]) {
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFSUtil(v, visited);
	}

	public static void main(String args[]) {
		DFSTraversal g = new DFSTraversal(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		 System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
		 g.DFS(2);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		adj.add(new ArrayList<>(Arrays.asList( 1)));
		adj.add(new ArrayList<>(Arrays.asList(2)));
		adj.add(new ArrayList<>(Arrays.asList(1, 3,4)));
		adj.add(new ArrayList<>(Arrays.asList(2)));
		adj.add(new ArrayList<>(Arrays.asList(2)));


		ArrayList<Integer> ll = dfsOfGraph(5, adj);
		System.out.println(ll);
	}

	static ArrayList<Integer> l = new ArrayList<>();

	public static ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[n];
		l = DfsUtil(adj, 0, visited);
		return l;

	}

	static ArrayList<Integer> DfsUtil(ArrayList<ArrayList<Integer>> adj, int i, boolean visited[]) {

		visited[i] = true;
		l.add(i);
		for (int j : adj.get(i)) {
			if (!visited[j]) {
				DfsUtil(adj, j, visited);
			}
		}
		return l;
	}
}
