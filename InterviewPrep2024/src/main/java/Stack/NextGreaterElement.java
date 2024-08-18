package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	static class pair {
		long first;
		int sec;

		pair(long first, int sec) {
			this.first = first;
			this.sec = sec;
		}
	}

	public static long[] nextLargerElement(long[] arr, int n) {
		long res[] = new long[n];
//		long arr[]= {1,3,2,4};
		Arrays.fill(res, -1);
		Stack<pair> st = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && st.peek().first < arr[i]) {
				res[st.pop().sec] = arr[i];
			}
	
			st.push(new pair(arr[i], i));
		}
		return res;
	}

	 public static int[] nextGreaterElements(int[] A) {
	        int n = A.length, res[] = new int[n];
	        Arrays.fill(res, -1);
	        Stack<Integer> stack = new Stack<>();
	        for (int i = 0; i < n * 2; i++) {
	            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
	                res[stack.pop()] = A[i % n];
	            stack.push(i % n);
	        }
	        return res;
	    }

	public static void main(String args[]) {
		//long arr[] = {6273,6273,8726,8726,5881,5881,1953,1953,8305,8305,9909,9909,5936,5936,4961,4961,7822,7822,4622,4622,2296,2296,2185,2185,2573,2573,7708,7708,4702,4702,2861,2861,7107,7107,2428,2428,6388,6388,6818,6818,33,33,8346,8346,3061,3061,5361,5361,275,275,2461,2461,6275,6275,8306,8306,2493,2493,302,302,9528,9528,4165,4165,7621,7621,6805,6805,1371,1371,9916,9916,3082,3082,5113,5113,3550,3550,6564,6564,8651,8651,5165,5165,3823,3823,6814,6814,8179,8179,2902,2902,2410,2410,1549,1549,4405,4405,5238,5238};
		long arr[]= {1,3,2,4};
		long s[] = nextLargerElement(arr, arr.length);
		//int arr[]= {1,2,1};
		//int s[]=nextGreaterElements(arr);
		System.out.println(Arrays.toString(s));

	}
}
