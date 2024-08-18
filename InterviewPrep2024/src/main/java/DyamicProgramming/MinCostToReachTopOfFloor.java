package DyamicProgramming;

public class MinCostToReachTopOfFloor {

	public static int minimumCost(int n, int cost[]){
	    if(n == 0) return cost[0] ;
	    if(n == 1) return cost[1] ;
	 
	    int top = cost[n]+Math.min(minimumCost(n-1,cost) ,
	                       minimumCost(n-2, cost));
	    return top;
	  }
	
		static int minimumCostMemoized(int n, int cost[], int dp[]) {
// base case
			if (n == 0)
				return dp[n] = cost[0];
			if (n == 1)
				return dp[n] = cost[1];

			if (dp[n] != -1)
				return dp[n];

			return dp[n] = Math.min(minimumCostMemoized(n - 1, cost, dp) + cost[n],
					minimumCostMemoized(n - 2, cost, dp) + cost[n]);
		}

		static int minimumCost(int cost[], int n) {
			int dp[] = new int[n];

			if (n == 1)
				return cost[0];

			dp[0] = cost[0];
			dp[1] = cost[1];

			for (int i = 2; i < n; i++) {
				dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
			}
			return Math.min(dp[n - 2], dp[n - 1]);
		}

		static int minimumCostOptimized(int cost[], int n) {
			int dp1 = 0, dp2 = 0;

			for (int i = 0; i < n; i++) {
				int dp0 = cost[i] + Math.min(dp1, dp2);
				dp2 = dp1;
				dp1 = dp0;
			}
			return Math.min(dp1, dp2);
		}
		
	  public static void main (String[] args) {
	    int a[] = { 16, 19, 10, 12, 18 };
	    int n = a.length;
	    System.out.println(minimumCost(n-2,a));
	  }
}
