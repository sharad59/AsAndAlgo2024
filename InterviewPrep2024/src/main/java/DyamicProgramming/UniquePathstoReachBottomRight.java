package DyamicProgramming;

import java.util.Arrays;

public class UniquePathstoReachBottomRight {

	public static int uniquePaths(int m, int n) {

		int[][] dp = new int[n][m];
		for (int[] i : dp)
			Arrays.fill(i, -1);
		return solve(n - 1, m - 1, dp);
	}

	static int solve(int n, int m, int[][] dp) {

		if (n == 0 && m == 0)
			return 1;

		if (n < 0 || m < 0)
			return 0;
		
		if (dp[n][m] != -1)
			return dp[n][m];
		
		int down = solve(n - 1, m, dp);
		int right = solve(n, m - 1, dp);
		
		return dp[n][m] = right + down;
	}

	public static void main(String args[]) {
		System.out.println(uniquePaths(3, 2));
		
	}
}
