package Greedy;

import java.util.Arrays;

public class BuyMaxToysWithAmountK {

	static int toyCount(int n, int k, int arr[]) {
		Arrays.sort(arr);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (sum + arr[i] <= k) {
				sum += arr[i];
				count++;
			}

		}
		return count;
	}

	public static void main(String[] args) {
		int K = 50;
		int cost[] = { 1, 12, 5, 111, 200, 1000, 10, 9, 12, 15 };
		int N = cost.length;
		System.out.print(toyCount(N, K, cost));
	}
}
