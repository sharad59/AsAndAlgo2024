package DyamicProgramming;

import java.util.Arrays;

public class MinOperationsToFromN {

	public static  int minOperation(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {

			if (i % 2 == 0) {
				int x = dp[i / 2];
				if (x + 1 < dp[i])
					dp[i] = x + 1;
				//dp[i]=Math.min(dp[i / 2]+1 ,dp[i]);
			}
			int x = dp[i - 1];
			if (x + 1 < dp[i])
				dp[i] = x + 1;
			//dp[i]=Math.min(dp[i - 1]+1 ,dp[i]);
		}
		return dp[n];
	}
	
	public static void main (String []args)
	{
	    int n = 4;
	     
	    System.out.print( minOperation(n));
	}
	}

