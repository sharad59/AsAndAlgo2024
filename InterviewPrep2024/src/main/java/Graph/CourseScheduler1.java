package Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduler1 {
	/*
	 * There are a total of numCourses courses you have to take, labeled from 0 to
	 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
	 * [ai, bi] indicates that you must take course bi first if you want to take
	 * course ai.
	 */
	public static void main(String args[]) {
		int v=2;
		int arr[][]= {{1,0},{0,1}};
		List<List<Integer>> adj=new ArrayList<>();
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<Integer>()); 
		}
		for(int i[]:arr) {
			adj.get(i[1]).add(i[0]);
		}
		
		System.out.println(canFinish(adj,v));
	}

	private static boolean canFinish(List<List<Integer>> adj, int v) {
		boolean visited[]=new boolean[v];
		boolean st[]=new boolean[v];
		for(int i=0;i<v;i++) {
			if(!visited[i] && containsCycle(adj,visited,st, i))
				return false;
			
		}
		return true;

	}

	private static boolean containsCycle(List<List<Integer>> adj, boolean[] visited, boolean[] st, int i) {

		visited[i] = true;
		st[i] = true;
		for (int x : adj.get(i)) {
			if (!visited[x] && containsCycle(adj, visited, st, x))
				return true;
			else if (st[x]) {
				return true;
			}

		}
		st[i] = false;
		return false;
	}
}
