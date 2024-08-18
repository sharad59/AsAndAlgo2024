package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintAllSubarraysWith0Sum {

	static class Pair {
		int first, second;

		Pair(int a, int b) {
			first = a;
			second = b;
		}
	}

	static ArrayList<Pair> findSubArrays(int[] arr, int n) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		ArrayList<Pair> out = new ArrayList<>();

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0)
				out.add(new Pair(0, i));

			ArrayList<Integer> al = new ArrayList<>();

			if (map.containsKey(sum)) {
				al = map.get(sum);
				for (int j = 0; j < al.size(); j++) {
					out.add(new Pair(al.get(j) + 1, i));
				}
			}
			al.add(i);
			map.put(sum, al);
		}
		return out;
	}

	public static long findSubarray(long[] arr, int n) {
		long count = 0l;
		Map<Long, ArrayList<Integer>> map = new HashMap<>();
		long sum = 0l;
		for (int i = 0; i < n; i++) {

			sum += arr[i];
			if (sum == 0l) {
				count++;
			}
			ArrayList<Integer> l = new ArrayList<Integer>();
			if (map.containsKey(sum)) {
				l=map.get(sum);
				for (int j = 0; j < l.size(); j++) {
					count++;
				}
			}
			l.add(i);
			map.put(sum, l);

		}
		return count;
	}

	public static void main(String args[]) {
		int[] arr = { 0, 0, 5, 5, 0, 0 };
		int n = arr.length;

		ArrayList<Pair> out = findSubArrays(arr, n);
		//long r = findSubarrays(arr, n);
		//System.out.println(r);
		
		  if (out.size() == 0) System.out.println("No subarray exists"); else
		  print(out);
		 
	}

	static void print(ArrayList<Pair> out) {
		for (int i = 0; i < out.size(); i++) {
			Pair p = out.get(i);
			System.out.println("Subarray found from Index " + p.first + " to " + p.second);
		}
	}
}
