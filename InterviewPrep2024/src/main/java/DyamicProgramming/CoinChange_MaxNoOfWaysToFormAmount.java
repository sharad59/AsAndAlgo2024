package DyamicProgramming;

import java.util.Arrays;
import java.util.List;

public class CoinChange_MaxNoOfWaysToFormAmount {

	// no of ways to make a amount with given coins
	// Input: sum = 4, coins[] = {1,2,3},
	// Output: 4
	// Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1,
	// 3}.

	//brute force
	static int coinChange(int coins[], int n, int sum) {

		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;

		if (n <= 0 && sum > 0)
			return 0;
		int res1 = coinChange(coins, n - 1, sum);
		int res2 = coinChange(coins, n, sum - coins[n - 1]);
		return res1 + res2;
	}
	// Top-down-memoization
	static int coinChangeMemo(int coins[], int n, int sum, int dp[][]) {
		if(sum==0)
			return dp[n][sum]=1;
		
		if(n<=0||sum<0)
			return 0;
		
		if(dp[n][sum]!=-1)		
			return dp[n][sum];
		
		return dp[n][sum]=coinChangeMemo(coins, n-1, sum, dp)+
				coinChangeMemo(coins, n, sum-coins[n-1],dp);
		

	}
	
	//Bottom up -- tabulation
	static int count(List<Integer> coins, int n, int sum) {

		int[][] dp = new int[n + 1][sum + 1];

		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {

				dp[i][j] += dp[i - 1][j];

				if ((j - coins.get(i - 1)) >= 0) {

					dp[i][j] += dp[i][j - coins.get(i - 1)];
				}
			}
		}
		return dp[n][sum];
	}


	public static void main(String args[]) {
		int sum = 4;
		int coins[] = { 1, 2, 3 };
		int n = coins.length;
		int res = coinChange(coins, n, sum);
		int[][] dp = new int[n + 1][sum + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		int res2 = coinChangeMemo(coins, n, sum, dp);
		//int  res2=count(coins, sum, n, dp);
		System.out.println(res2);
        List<Integer> coins1 = Arrays.asList(1, 2, 3);

        System.out.println(count(coins1, n, sum));


	}
}