package DyamicProgramming;

import java.util.Arrays;

public class NoOfArrangementsToFormN {

	static int arr[] = new int[100];

	public static void main(String args[]) {
		Arrays.fill(arr, -1);

		int n = 7;
		int ans = findArrangements(n);
		System.out.println(ans);
		System.out.println("Tab " + findArrangeMentsTabular(n));
	}

	private static int findArrangements(int n) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return findArrangements(n - 1) + findArrangements(n - 3) + findArrangements(n - 5);
	}

	static int findArrangeMentsTabular(int n) {

		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		if (arr[n] != -1)
			return arr[n];
		else
			arr[n] = findArrangeMentsTabular(n - 1) + findArrangeMentsTabular(n - 3) + findArrangeMentsTabular(n - 5);

		return arr[n];
	}
}
