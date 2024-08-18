package Graph;

import java.util.ArrayList;

public class AdjencyListImplementation {

	public static void addEdge(ArrayList<Integer> adj[], int x, int y) {

		adj[x].add(y);
		adj[y].add(x);
	}
	
static void printGraph(ArrayList<Integer> adj[]) {
		
		for(int i=0;i<adj.length;i++) {
			System.out.print("vertex->"+i+" ");

			for(int j=0;j<adj[i].size();j++) {
				
				System.out.print("->"+adj[i].get(j));
			}
			System.out.println();

		}
	}

	public static void main(String args[]) {

		ArrayList<Integer> adj[] = new ArrayList[5];
		for (int i = 0; i < 5; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 4);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		printGraph(adj);
		delEdge(adj, 1, 2);
		printGraph(adj);

	}



	static void delEdge(ArrayList<Integer> adj[], int u, int v) {

		for (int i = 0; i < adj[u].size(); i++) {
			if (adj[u].get(i) == v) {
				adj[u].remove(i);
				break;
			}
		}

		for (int i = 0; i < adj[v].size(); i++) {
			if (adj[v].get(i) == u) {
				adj[v].remove(i);
				break;
			}
		}
	}
	
	
}
