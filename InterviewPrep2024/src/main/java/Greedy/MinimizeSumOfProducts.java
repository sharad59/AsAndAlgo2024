package Greedy;

import java.util.Arrays;

public class MinimizeSumOfProducts {

	public static long minValue(long a[], long b[], long n) {
		int sum = 0;

		Arrays.sort(a);
		Arrays.sort(b);
		int j = 0;
		int t = (int) n;

		while (j < t) {
			long temp = b[j];
			b[j] = b[t - 1];
			b[t - 1] = temp;
			j++;
			t--;
		}
		for (int i = 0; i < n; i++) {
			sum += a[i] * b[i];
		}
		return sum;
	}

	public static void main(String args[]) {

		long a[] = { 7,14,16,18 };
		long b[] = { 16,7,13,10};
		int n = a.length;
		System.out.println(minValue(a, b, n));

	}
}
