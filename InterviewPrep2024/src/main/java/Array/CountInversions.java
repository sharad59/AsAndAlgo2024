package Array;

import java.util.Arrays;

public class CountInversions {

	public static void main(String args[]) {

		int[] arr = { 1, 20, 6, 4, 5 };

		System.out.println(merge(arr, 0, arr.length-1));
	}

	private static int merge(int[] arr, int l, int r) {
		int count = 0;
		if (l < r) {
			int m = (l +r) / 2;
			count += merge(arr, l, m);
			count += merge(arr, m + 1, r);
			count += mergeSort(arr, l, m, r);

		}
		return count;
	}

	private static int mergeSort(int[] arr, int l, int m, int r) {

		int L1[] = Arrays.copyOfRange(arr, l, m + 1);
		int R1[] = Arrays.copyOfRange(arr, m + 1, r + 1);
		int swap = 0;
		int i = 0, j = 0, k = l;

		while (i < L1.length && j < R1.length) {
			if (L1[i] < R1[j]) {
				arr[k] = L1[i];
				i++;
			} else {
				arr[k]=R1[j];
				swap += (m + 1) - (l + i);
				j++;
			}
			k++;
		}

		while (i < L1.length) {
			arr[k] = L1[i];
			i++;
			k++;
		}
		while (j < R1.length) {
			arr[k] = R1[j];
			j++;
			k++;
		}

		return swap;
	}
}