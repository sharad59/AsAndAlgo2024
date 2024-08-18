package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubArrayWith0Sum {

	public static void main(String args[]) {
		int A[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		//findLargestSubArrayWith0Sum(A, A.length);
		maxLen(A,  A.length);

	}
	public static class pair{
		int i,j;
		pair(int i,int j){
			this.i=i;
			this.j=j;
		}
			
	}
	
	
	private static void findLargestSubArrayWith0Sum(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currSum = 0;
		int start = 0;
		int end = 0;
		int l = 0;
		for (int i = 0; i < n; i++) {
			currSum += arr[i];
			if (currSum == 0)
				l = i + 1;
			if (map.containsKey(currSum) && i - (map.get(currSum)) > l) {
			
					start = map.get(currSum);
					end = i;
					l = end - start;
				
			} else {
				map.put(currSum, i);
			}
		}
		System.out.println(l);
	}
	
	
	static void maxLen(int arr[], int n) {
		int sum = 0;
		int start = 0;
		int end = 0;
		int l = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		List<pair> list= new ArrayList<>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0)
			l = i + 1;
			if (map.containsKey(sum)) {
					start = map.get(sum);
					end = i;
					l = end - start;
					list.add(new pair(start+1,end));
				}
			 else {
				map.put(sum, i);
			}

		}
		System.out.println(l);
		list.forEach(a->System.out.println(a.i+", "+a.j)); 
	}

}
