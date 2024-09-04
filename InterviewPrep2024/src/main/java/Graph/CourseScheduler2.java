package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseScheduler2 {

	public static void main(String args[]) {

		int v = 4;
		int arr[][] = { { 1, 0 }, { 0, 2 }, { 3, 1 }, { 2, 3 } };
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i[] : arr) {
			adj.get(i[1]).add(i[0]);
		}

		int ans[]=getTopSort(adj, v);
		System.out.println(Arrays.toString(ans));
	}

	private static int [] getTopSort(List<List<Integer>> adj, int v) {

		boolean visited[] = new boolean[v];
		Stack<Integer> st = new Stack<>();
        boolean path[] = new boolean[v];

        int[] ans = new int[v];

		for (int i = 0; i < v; i++) {
			if (!visited[i])
				if(getTopologicalSortAndCheckCycle(visited, st, adj, i,path))
					return new int[0];
		}
		
		 int i = 0;
	        while (!st.isEmpty())
	            ans[i++] = st.pop();
	        return ans;
	}

	private static boolean getTopologicalSortAndCheckCycle(boolean[] visited, Stack<Integer> st,
			List<List<Integer>> adj, int i, boolean path[]) {
		visited[i] = true;
		path[i] = true;

		for (int x : adj.get(i)) {
			if (!visited[x]) {
				if(getTopologicalSortAndCheckCycle(visited, st, adj, x, path))
					return true;
			} else if (path[x])
				return true;
		}
		path[i] = false;
		st.push(i);
		return false;

	}
}
