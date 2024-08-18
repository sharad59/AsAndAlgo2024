package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class CapacityToShipPackagesWithDdays {

	static int check(int[] v, int cap) {
		int days = 1;
		int curr = 0;
		for (int x : v) {
			if (curr + x <= cap)
				curr += x;
			else {
				curr = 0;
				curr += x;
				days++;
			}
		}
		return days;
	}

	static int shipWithinDays(int[] weights, int days) {
		int sum = 0, maxi = Integer.MIN_VALUE;
		for (int x : weights) {
			maxi = Math.max(maxi, x);
			sum += x;
		}
		int left = maxi, right = sum;
		int need = days, curr = 0;

		while (left < right) {
			int cap = left + (right - left) / 2;
			curr = check(weights, cap);
			if (curr > need)
				left = cap + 1;
			else
				right = cap;
		}
		return left;
	}

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		int sum =Arrays.stream(arr).sum();
System.out.println(shipWithinDays2(arr, days));
	}

	static int shipWithinDays2(int[] weights, int days) {
		int sum = 0, maxi = Integer.MIN_VALUE;
		for (int x : weights) {
			maxi = Math.max(maxi, x);
			sum += x;
		}
		maxi=Arrays.stream(weights).max().getAsInt();
		int left = maxi, right = sum;
		int res = sum;

		while (left <= right) {
			int cap = (left + right) / 2;
			if (canShip(weights,cap, days)) {
				res = Math.min(res, cap);
				right = cap - 1;
			} else {
				left = cap + 1;
			}
		}
		return res;
	}

	private static boolean canShip(int[] weights, int cap, int days) {

		int d = 1, currCap = cap;
		for (int w : weights) {
			if (currCap - w < 0) {
				d++;
				currCap = cap;
			}
			currCap -= w;

		}
		return d <= days;
	}

}
