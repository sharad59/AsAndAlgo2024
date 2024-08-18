package Sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String args[]) {
		int[] arr = { 4, 3, 12, 1, 5, 5, 3, 9 };

		countSort(arr, arr.length);
	}

	private static void countSort(int[] arr, int n) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		int count[] = new int[max+1];

		for (int j = 0; j < n; j++) {
			count[arr[j]]++;
		}
		int i = 0, j = 0;

		while (i < max) {
			if (count[i] != 0) {
				arr[j] = i;
				count[i]--;
				j++;
			} else {
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));

	}
}
