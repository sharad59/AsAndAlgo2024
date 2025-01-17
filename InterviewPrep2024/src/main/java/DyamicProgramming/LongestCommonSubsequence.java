package DyamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

	 public static void main(String[] args) { 
	        String S1 = "AGGTAB"; 
	        String S2 = "GXTXAYB"; 
	        int m=S1.length();
	        int n=S2.length();
	        int dp[][]=new int [m+1][n+1];
	        for(int i=0;i<=m;i++)
	        Arrays.fill(dp[i], -1);
	        // Function call 
	        System.out.println( longestCommonSubsequence(S1, S2,S1.length(),S2.length())); 
	        System.out.println(longestCommonSubsequenceMemo(S1, S2,S1.length(),S2.length(), dp));
	        System.out.println(longestCommonSubsequenceTab(S1, S2, m, n));
	    }

		private static int longestCommonSubsequence(String s1, String s2, int m, int n) {
			if (m == 0 || n == 0)
				return 0;
			if (s1 == null || s2 == null)
				return 0;

			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				return 1 + longestCommonSubsequence(s1, s2, m - 1, n - 1);
			} else {
				return Math.max(longestCommonSubsequence(s1, s2, m - 1, n), longestCommonSubsequence(s1, s2, m, n - 1));
			}
		}
		
		private static int longestCommonSubsequenceMemo(String s1,String s2,int m,int n, int dp[][]) {
		
			if (m == 0 || n == 0)
				return 0;
			if (s1 == null || s2 == null)
				return 0;
			if(dp[m][n]!=-1)
				return dp[m][n];
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				dp[m][n] =1 + longestCommonSubsequenceMemo(s1, s2, m - 1, n - 1,dp);
			}
			else {
				dp[m][n]=Math.max(longestCommonSubsequenceMemo(s1, s2, m - 1, n,dp), longestCommonSubsequenceMemo(s1, s2, m, n - 1,dp));
			}
				
			return dp[m][n];
		}
		
		private static int longestCommonSubsequenceTab(String s1,String s2,int m,int n) {
			 int dp[][]=new int [m+1][n+1];
		       
			 for(int i=0;i<=m;i++) {
				 
				 for(int j=0;j<=n;j++) {
					 if(i==0||j==0) {
						 dp[i][j]=0;
					 }
					 else  if(s1.charAt(i-1)==s2.charAt(j-1)) {
						 dp[i][j]=1+dp[i-1][j-1];
					 }
					 else {
						 dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]) ;
					 }
					 
				 }
			 }	        
		   return dp[m][n];     
		}
	}
