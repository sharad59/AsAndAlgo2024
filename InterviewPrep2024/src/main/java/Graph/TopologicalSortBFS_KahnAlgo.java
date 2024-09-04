package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBFS_KahnAlgo {

	
	public static void main(String args[]) {
		int n=6;
		
		List<List<Integer>> adj= new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(3);
		adj.get(4).add(5);
		adj.get(5).add(1);
		adj.get(5).add(2);
		int arr[]=topologicalSort(adj, n);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static int[] topologicalSort(List<List<Integer>> adj, int v) {
		
		int indegree[]= new int[v];
		for(int i=0;i<v;i++) {
			for(int it:adj.get(i)) {
				indegree[it]++;
			}
		}
		
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<v;i++) {
			if(indegree[i]==0)
			{
				q.add(i);
			}
		}	
		
		int result[]=new int[v];
		int index=0;
		while(!q.isEmpty()) {
			
			int node= q.poll();
			result[index++]=node;
			for(int it:adj.get(node)) {
				indegree[it]--;
				
				if(indegree[it]==0){
					q.add(it);
				}
				
			}
		}
		
		if(index!=v) {
			System.out.println("graph contains cycle");
			return new int[0];
		}
		
		return result;
	}
}
