package binarySearch;

import java.util.Arrays;

public class KokoEatsBananas {

	public static int minEatingSpeed(int[] piles, int h) {
		int max = Arrays.stream(piles).max().getAsInt();
		int left = 1;
		int right = max;
		int mid = 0;
		int res = right;
		while (left <= right) {

			mid = (left + right) / 2;

			if (calculate(piles, mid) <= h) {
				res = Math.min(res, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}

	static int calculate(int piles[], int mid) {
		double sum = 0;
		for (int i = 0; i < piles.length; i++) {
			sum += Math.ceil(piles[i] / (double) mid);
		}
		return (int) sum;

	}

	public static void main(String args[]) {
		int arr[] = { 3, 6, 7, 11 };
		int h = 8;
		System.out.println(calculate(arr, h));

	}
}
