package DyamicProgramming;

import java.util.Arrays;

public class Coin_Change_MinimumNoOfCoinsToFormAmount {
	

//Recursion
	static int minCoinsRecursion(int coins[], int m, int V) {
		if (V == 0)
			return 0;

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				int sub_res = minCoinsRecursion(coins, m, V - coins[i]);
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
					res = sub_res + 1;
			}
		}
		return res;
	}
	 
	    public static void main(String args[])
	    {
	       int coins[] =  {1,2,5};
	       int m = coins.length;
	       int V = 11;
	        int[] dp = new int[V + 1];
	        Arrays.fill(dp, -1);
	      // System.out.println(minCoinsUtil(coins, m, V,dp));
	       System.out.println(minCoinsTab(coins, m, V));

	    }
	    
		static int minCoinsTab(int coins[], int m, int V) {

			int table[] = new int[V + 1];
			table[0] = 0;
			for (int i = 1; i <= V; i++)
				table[i] = Integer.MAX_VALUE;

			for (int i = 1; i <= V; i++) {
 				for (int j = 0; j < m; j++)
					if (coins[j] <= i) {
						int sub_res = table[i - coins[j]];
						if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
							table[i] = sub_res + 1;
					}
			}

			if (table[V] == Integer.MAX_VALUE)
				return -1;

			return table[V];

		}
		
		
		public static int minCoinsUtil(int[] coins, int m, int V, int[] dp) {

			if (V == 0)
				return 0;

			if (dp[V] != -1)
				return dp[V];

			int res = Integer.MAX_VALUE;

			for (int i = 0; i < m; i++) {
				if (coins[i] <= V) {

					int sub_res = minCoinsUtil(coins, m, V - coins[i], dp);

					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
						res = sub_res + 1;
				}
			}

			dp[V] = res;
			return res;
		}

		public static int minCoinsMemo(int[] coins, int m, int V) {
			int[] dp = new int[V + 1];
			Arrays.fill(dp, -1);
			return minCoinsUtil(coins, m, V, dp);
		}
}
