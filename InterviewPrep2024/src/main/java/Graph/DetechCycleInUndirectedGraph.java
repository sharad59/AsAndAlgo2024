package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//DFS method to check cycle
//it is based on the idea that there is a cycle in a graph only if there is a back edge 
//To detect a back edge, we need to keep track of the visited nodes hat are in the current recursion stack 
public class DetechCycleInUndirectedGraph {
	static  private int V;

	  static   private LinkedList<Integer> adj[];

	    DetechCycleInUndirectedGraph(int v)
	    {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i = 0; i < v; ++i)
	            adj[i] = new LinkedList();
	    }

	    void addEdge(int v, int w)
	    {
	        adj[v].add(w);
	        adj[w].add(v);
	    }

		boolean isCyclicUtil(int v, boolean visited[], int parent) {
			visited[v] = true;
			for (int i : adj[v]) {
				if (!visited[i]) {
					if (isCyclicUtil(i, visited, v))
						return true;
				} else if (i != parent)
					return true;
			}
			return false;
		}

		Boolean isCyclic() {
			boolean visited[] = new boolean[V];

			for (int u = 0; u < V; u++) {
				if (!visited[u])
					if (isCyclicUtil(u, visited, -1))
						return true;
			}
			return false;
		}

	    public static void main(String args[])
	    {

	    	DetechCycleInUndirectedGraph g1 = new DetechCycleInUndirectedGraph(5);
	        g1.addEdge(1, 0);
	        g1.addEdge(0, 2);
	        g1.addEdge(2, 1);
	        g1.addEdge(0, 3);
	        g1.addEdge(3, 4);
	        if (g1.isCyclic())
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contain cycle");
	       // System.out.println(  isCyclicDisconnected(adj, V));//BFS

	        DetechCycleInUndirectedGraph g2 = new DetechCycleInUndirectedGraph(4);
	        g2.addEdge(0, 1);
	        g2.addEdge(1, 2);
	        g2.addEdge(3, 0);

	        if (g2.isCyclic())
	            System.out.println("Graph contains cycle");
	        else
	            System.out.println("Graph doesn't contain cycle");
	        System.out.println(  isCyclicDisconnected(adj, V));//BFS
	      
	    }
//------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------
//BFS method to check cycle   
//The basic idea is to keep track of visited nodes during BFS traversal.
//If a node is encountered more than once during BFS, it indicates the
//presence of a cycle in the graph.
	    public static boolean isCyclicConnected(LinkedList<Integer>[] adj, int s, int V, boolean[] visited) {
	        Queue<Integer> q = new LinkedList<>();
	        q.add(s);

	        while (!q.isEmpty()) {
	            int v = q.poll();

	            if (visited[v]) {
	                return true; // Cycle detected
	            }

	            visited[v] = true; // Mark as visited

	            for (int it : adj[v]) {
	                if (!visited[it]) {
	                    q.add(it);
	                }
	            }
	        }
	        return false;
	    }

	    public static boolean isCyclicDisconnected(LinkedList<Integer>[] adj, int V) {
	        boolean[] visited = new boolean[V];

	        for (int i = 0; i < V; i++) {
	            if (!visited[i] && isCyclicConnected(adj, i, V, visited)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
}
