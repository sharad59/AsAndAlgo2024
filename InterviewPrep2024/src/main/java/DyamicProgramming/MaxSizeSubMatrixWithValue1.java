package DyamicProgramming;

public class MaxSizeSubMatrixWithValue1 {

	public int maximalSquare(char[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		int dp[][] = new int[r][c];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				if (i == 0 || j == 0) {
					if (matrix[i][j] == '1') {
						dp[i][j] = 1;
						max = Math.max(max, dp[i][j]);
					}
				} else if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], matrix[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);

				} else {
					dp[i][j] = 0;
				}
			}
		}

		return max * max;
	}
	
	
	public static void main(String args[][]) {
		//int arr=
	}
}
