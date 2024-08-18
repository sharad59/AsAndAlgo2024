package Greedy;

import java.util.Arrays;

public class FindLargestNumberOfDigitsAndSumGiven {

	static String findLargest(int n, int S) {
		int a = 0;
		int no = 9;

		if (S > 9 * n) {
			return String.valueOf(-1);
		}

		while (S - no >= 0 && n > 0) {
			S -= no;
			a = a * 10 + no;
			n--;
		}

		while (n > 0) {
			a = a * 10 + S;
			n--;
		}
		if (n > 0 && a == 0) {
			return String.valueOf(-1);
		}

		return String.valueOf(a);

	}

	static String findLargest1(int m, int s) {

		if (s == 0) {
			return m == 1 ? String.valueOf(0) : String.valueOf(-1);

		}

		if (s > 9 * m) {
			return String.valueOf(-1);
		}

		int[] res = new int[m];

		for (int i = 0; i < m; i++) {
			if (s >= 9) {
				res[i] = 9;
				s -= 9;
			} else {
				res[i] = s;
				s = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(i);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int s = 104, m = 42;
		System.out.println(findLargest1(m, s));
	}
}
