package Hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {

	static Integer[] arr = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(arr);

		sortBasedOnFrequencyAndValue(list);
		System.out.println(Arrays.toString(list.toArray()));
	}

	private static void sortBasedOnFrequencyAndValue(List<Integer> list) {

		Map<Integer, Integer> countMap = new HashMap<>();
		Map<Integer, Integer> indexMap = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {

			if (countMap.containsKey(arr[i])) {
				countMap.put(arr[i], countMap.get(arr[i]) + 1);
			} else {
				countMap.put(arr[i], 1);
				indexMap.put(arr[i], i);

			}
		}

		/*
		 * Collections.sort(list, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer n1, Integer n2) {
		 * 
		 * int f1 = countMap.get(n1); int f2 = countMap.get(n2); if (f1 != f2) { return
		 * f2 - f1; } else { return indexMap.get(n1) - indexMap.get(n2); } }
		 * 
		 * });
		 */
		
		Collections.sort(list, (a, b) -> {
			int n1 = countMap.get(a);
			int n2 = countMap.get(b);
			if (n1 != n2)
				return n2 - n1;
			else
				return indexMap.get(a) - indexMap.get(b);

		});
	}

}
