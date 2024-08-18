package DyamicProgramming;

import java.util.Arrays;

public class HouseRobberI {

	public static void main(String args[]) {
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int N = 6;

		// Function call
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);
		//System.out.println(findMaxSum(arr, 0));
		//System.out.println(findMaxSumMemo(arr, 0,dp));
		 System.out.println( maxLoot(arr,N));
		//System.out.println(robTab(arr));

	}

	private static int findMaxSum(int[] arr, int i) {

		if (i >= arr.length)
			return 0;

		return Math.max(arr[i] + findMaxSum(arr, i + 2), findMaxSum(arr, i + 1));
	}

	public static int findMaxSumMemo(int arr[], int i, int dp[]) {

		if (i >= arr.length) {
			return 0;
		}
		if (dp[i] != -1)
			return dp[i];

		dp[i] = Math.max(findMaxSumMemo(arr, i + 2, dp)+arr[i], findMaxSumMemo(arr, i + 1, dp));

		return dp[i];

	}

	 public static int robTab(int[] nums) {
	        int n=nums.length;
	        int dp[][]=new int [n][2];

	        if(n==1){
	            return nums[0];
	        }

	        dp[0][1]=nums[0];
	        dp[0][0]=0;

	        for(int i=1;i<n;i++){

	            dp[i][1]= nums[i]+dp[i-1][0];
	            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
	        }
	        return Math.max(dp[n-1][0],dp[n-1][1]);
	    }
	
	 //GFG optimized 
	 static int maxLoot(int hval[], int n) 
	    { 
	        if (n == 0) 
	            return 0; 
	        if (n == 1) 
	            return hval[0]; 
	        if (n == 2) 
	            return Math.max(hval[0], hval[1]); 

	        int[] dp = new int[n]; 
	  
	        dp[0] = hval[0]; 
	        dp[1] = Math.max(hval[0], hval[1]); 
	  
	        for (int i = 2; i < n; i++) 
	            dp[i] 
	                = Math.max(hval[i] + dp[i - 2], dp[i - 1]); 	  
	        return dp[n - 1]; 
	    } 
	// optimized leetcode 
	 public int rob(int[] nums) {
		 if(nums.length>2)
		      nums[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);

		         if (nums.length == 2)
		             return Math.max(nums[0], nums[1]);
		        
		         for (int i = nums.length - 3; i >= 0; i--) {
		             nums[i] = Math.max((nums[i] + nums[i + 2]), nums[i + 1]);
		         }
		         return nums[0];
		 }
}
