package DyamicProgramming;

import java.util.Arrays;

public class MaxuniquePathCountFromToBottomInMatrix {

	static int numberOfpaths(int m, int n) {

		if (m == 1 || n == 1) {
			return 1;
		}
		return numberOfpaths(m - 1, n) + numberOfpaths(m, n - 1);
	}

	static int noOfPath1(int m, int n, int dp[][]) {
		if (m == 1 || n == 1) {
			return dp[m][n] = 1;
		}
		if (dp[m][n] != -1) {
			return dp[m][n];
		} else
			dp[m][n] = noOfPath1(m - 1, n, dp) + noOfPath1(m, n - 1, dp);

		return dp[m][n];
	}

	static int noOfPaths2(int m, int n, int dp[][]) {

		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[m - 1][n - 1];
	}
	
	public static void main(String args[]) {

		int m = 3, n = 7;
		System.out.println(numberOfpaths(m, n));
		int dp[][] = new int[m + 1][n + 1];
		for (int arr[] : dp)
			Arrays.fill(arr, -1);
		System.out.println(noOfPath1(m, n, dp));

	}

}
