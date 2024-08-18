package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonElementsIn2Arrays {

	public static void main(String args[]) {

		int v1[] = {3, 4, 2, 2, 4};
		int v2[] = {3, 2, 2, 7};
		List<Integer> l = commonElement(v1, v2);
		System.out.println( Arrays.toString(l.toArray()));

		List<Integer> l1= new ArrayList<>();
		l.retainAll(l1);
		
	}

	public static ArrayList<Integer> commonElement(int v1[], int v2[]) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < v1.length; i++) {
			max = Math.max(max, v1[i]);
		}

		int arr[] = new int[max + 1];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < v1.length; i++) {

			if (!map.containsKey(v1[i])) {
				map.put(v1[i], 1);

			} else {
				map.put(v1[i], map.get(v1[i]) + 1);
			}
		}

		for (int i = 0; i < v2.length; i++) {
			if (map.containsKey(v2[i]) && arr[v2[i]] >= map.get(v2[i])) {
				continue;
			} else if (map.containsKey(v2[i])) {
				arr[v2[i]]++;
			}
		}

		for (int i = 0; i <= max; i++) {
			while (arr[i] > 0) {
				list.add(i);
				--arr[i];
			}
		}
		return list;
	}
	
	// try using counting array
}
