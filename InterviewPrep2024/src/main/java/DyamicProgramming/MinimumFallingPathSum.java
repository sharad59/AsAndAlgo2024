package DyamicProgramming;

public class MinimumFallingPathSum {
	static int r = 0;
	static int c = 0;

	public int minFallingPathSum(int[][] matrix) {
		r = matrix.length;
		c = matrix[0].length;
		int col = 0, minValue = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[0][i] < minValue) {
				minValue = matrix[0][i];
				col = i;
			}
		}
		int value = minFallingPathSum1(matrix, 0, col, 0);
		return value;
	}

	int minFallingPathSum1(int[][] matrix, int row, int col, int sum) {
		if (row < 0 || row > r) {
			return 0;
		}
		if (c < 0 || c > col) {
			return 0;
		}
		sum += min(minFallingPathSum1(matrix, row + 1, col - 1, sum), minFallingPathSum1(matrix, row + 1, col, sum),
				minFallingPathSum1(matrix, row + 1, col + 1, sum));
		return sum;
	}

	int min(int x, int y, int z) {
		int c = x > y ? x : y;
		return c > z ? c : z;
	}

	  public static int minFallingPathSum2(int[][] matrix) {
	        r = matrix.length;
	        c = matrix[0].length;
	        if (matrix == null || r == 0 || c == 0)
	            return 0;

	        int dp[][] = new int[r][c];

	        for (int i = 0; i < c; i++) {
	            dp[0][i] = matrix[0][i];
	        }

	        for (int i = 1; i < r; i++) {
	            for (int j = 0; j < c; j++) {

	                if (j == 0) {
	                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
	                }
	               else if (j == c - 1) {
	                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);

	                } else {
	                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
	                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
	                }
	                dp[i][j] += matrix[i][j];

	            }
	        }

	        int min = Integer.MAX_VALUE;
	        for (int num : dp[r - 1]) {
	            min = Math.min(min, num);
	        }

	        return min;
	    }

	public static void main(String args[]) {

		int matrix[][] = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum2(matrix));
	}
}
