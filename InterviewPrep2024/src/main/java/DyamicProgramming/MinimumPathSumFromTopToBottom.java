package DyamicProgramming;

import java.util.Arrays;

public class MinimumPathSumFromTopToBottom {

	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			grid[0][i] += grid[0][i - 1];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		return grid[m - 1][n - 1];
	}

	public static int minPathSum(int[][] grid, int m, int n) {

		if (n < 0 || m < 0)
			return Integer.MAX_VALUE;
		else if (m == 0 && n == 0)
			return grid[m][n];
		else
			return grid[m][n] + Math.min(minPathSum(grid, m - 1, n), minPathSum(grid, m, n - 1));
	}

	public static int minCostMemoized(int[][] cost, int m, int n, int[][] memo) {
		if (n < 0 || m < 0)
			return Integer.MAX_VALUE;
		else if (m == 0 && n == 0)
			return cost[m][n];

		if (memo[m][n] != -1)
			return memo[m][n];

		memo[m][n] = cost[m][n]
				+ Math.min(minCostMemoized(cost, m - 1, n, memo), minCostMemoized(cost, m, n - 1, memo));

		return memo[m][n];
	}

	public static void main(String args[]) {

		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int m = arr.length;
		int n = arr[0].length;
		int[][] memo = new int[m][n];
		for (int[] row : memo)
			Arrays.fill(row, -1);
		// System.out.println(minPathSum(arr));
		System.out.println(minPathSum(arr, m - 1, n - 1));
		System.out.println(minCostMemoized(arr, m-1, n-1, memo));
	}
}
