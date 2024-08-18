package DyamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteAndEarn {

	public int deleteAndEarn(int[] nums) {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for (int x : nums) {
	            map.put(x, map.getOrDefault(x, 0) + 1);
	        }

	        Integer arr[] = new Integer[nums.length];
	        Arrays.setAll(arr, i -> nums[i]);
	        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
	        List<Integer> list = new ArrayList<Integer>(set);
	        Collections.sort(list);

	        int earn1=0, earn2 = 0;
	        for (int i = 0; i < list.size(); i++) {
	            int currVal = list.get(i) * map.get(list.get(i));
	            if (i > 0 && list.get(i) == list.get(i - 1) + 1) {
	                int temp = earn2;
	                earn2 = Math.max(currVal + earn1, earn2);
	                earn1 = temp;
	            } else {
	                int temp = earn2;
	                earn2 = currVal + earn2;
	                earn1 = temp;
	            }
	        }
	        return earn2;
	    }
	
	
		static int findMaximumScore(int[] a, int n) {
			int max = Arrays.stream(a).max().getAsInt();

			int[] dp = new int[max + 1];
			int freq[] = new int[max+1];

			for (int i = 0; i <n; i++) {
				freq[a[i]]++;
			}

			dp[0] = freq[0];
			dp[1] = freq[1];

			for (int i = 2; i < dp.length; i++)
				dp[i] = Math.max(dp[i - 1], dp[i - 2] + freq[i] * i);
			
			return dp[dp.length - 1];
		}

		 public long maximumTotalDamage(int[] a) {
		        int n=a.length;
		        int max = Arrays.stream(a).max().getAsInt();

					int[] dp = new int[max + 1];
					int freq[] = new int[max+1];

					for (int i = 0; i <n; i++) {
						freq[a[i]]++;
					}

					dp[0] = freq[0];
					dp[1] = freq[1];
		        dp[2]=freq[2];

					for (int i = 3; i < dp.length; i++)
						dp[i] = max(dp[i - 1], dp[i - 2], dp[i-3] + freq[i] * i);
					
		        System.out.println(Arrays.toString(dp));
					return dp[dp.length - 1];
		    }
		    
		    int max(int a,int b ,int c){
		        int max1= a>b?a:b;
		        int max2=max1>c?max1:c;
		        return max2;
		    }
		

		public static void main(String[] args) {
			int n;
			int[] a = { 2, 2, 3, 3, 3, 4 };
			n = a.length;


			System.out.print(findMaximumScore(a, n));
		}
}

// segment tree