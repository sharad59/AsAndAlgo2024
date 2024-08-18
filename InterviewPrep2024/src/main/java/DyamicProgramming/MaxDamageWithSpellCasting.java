package DyamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxDamageWithSpellCasting {

	public long maximumTotalDamage1(int[] power) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int p : power) {

			freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);

		}
		List<Integer> uniquePowers = new ArrayList<>(freqMap.keySet());
		Collections.sort(uniquePowers);
		int n = uniquePowers.size();
		long[] dp = new long[n];
		
		dp[0] = (long) uniquePowers.get(0) * freqMap.get(uniquePowers.get(0));
		
		for (int i = 1; i < n; i++) {
			int currentPower = uniquePowers.get(i);
			long currentDamage = (long) currentPower * freqMap.get(currentPower);
			
			dp[i] = dp[i - 1];
			int j = i - 1;
			while (j >= 0 && uniquePowers.get(j) >= currentPower - 2) {
				j--;
			}
			if (j >= 0) {
				dp[i] = Math.max(dp[i], currentDamage + dp[j]);
			} else {
				dp[i] = Math.max(dp[i], currentDamage);
			}
		}
		return dp[n - 1];
	}

	//This solution gives time limit exceeded with large value 
	static public long maximumTotalDamage(int[] a) {
		int n = a.length;
		int max = Arrays.stream(a).max().getAsInt();

		int[] dp = new int[max + 1];
		int freq[] = new int[max + 1];

		for (int i = 0; i < n; i++) {
			freq[a[i]]++;
		}

		dp[0] = freq[0];
		dp[1] = freq[1];
		if(max<=1) {
			return Math.max(dp[0], dp[1]);
		}
		dp[2] = max (dp[0],freq[2]*2,dp[1]);

		for (int i = 3; i < dp.length; i++)
			dp[i] = max(dp[i - 1], dp[i - 2], dp[i - 3] + freq[i] * i);

		 System.out.println(Arrays.toString(dp));
		return dp[dp.length - 1];
	}

	static int max(int a, int b, int c) {
		int max1 = a > b ? a : b;
		int max2 = max1 > c ? max1 : c;
		return max2;
	}

	public static void main(String args[]) {
		//int arr[] = { 5,9,2,10,2,7,10,9,3,8 };
		int arr[] = { 5,1,4 };

		System.out.println(maximumTotalDamage(arr));
	}
}
