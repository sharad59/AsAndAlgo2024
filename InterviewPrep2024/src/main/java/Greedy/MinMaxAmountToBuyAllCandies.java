package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MinMaxAmountToBuyAllCandies {

	static ArrayList<Integer> candyStore(int arr[], int n, int k) {
		ArrayList<Integer> l = new ArrayList<>();
		Arrays.sort(arr);
		int min = 0;
		int max = 0;
		int c = 0;
		for (int i = 0; i < n && c < n; i++) {
			min += arr[i];
			max += arr[n - i - 1];

			c++;
			c += k;
		}
		l.add(min);
		l.add(max);
		return l;
	}

	public static void main(String args[]) {

		int a[] = { 3, 2, 1, 4 };
		int n = a.length;
		System.out.println(candyStore(a, 4, 2));

	}
}
