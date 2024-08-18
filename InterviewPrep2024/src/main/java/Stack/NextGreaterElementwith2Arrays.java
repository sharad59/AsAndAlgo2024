package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementwith2Arrays {

	
	public static int[] nextGreaterElement1(int[] n1, int[] n2) {
		Stack<Integer> s1 = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n2.length; i++) {
			while (!s1.isEmpty() && s1.peek() <=  n2[i]) {
				map.put(s1.pop(), n2[i]);
			}

			s1.push( n2[i]);
		}
		while (!s1.isEmpty()) {
			map.put(s1.pop(), -1);
		}

		for (int i = 0; i < n1.length; i++) {
			n1[i] = map.containsKey(n1[i]) ? map.get(n1[i]) : -1;
		}
		return n1;
	}
	public static void main(String args[]) {
		
		int  nums1[] = { 4,1,2};
		int nums2[] = {1,3,4,2};
		int nums3[]=nextGreaterElement1(nums1, nums2);
		System.out.println(Arrays.toString(nums3));
	}
}
