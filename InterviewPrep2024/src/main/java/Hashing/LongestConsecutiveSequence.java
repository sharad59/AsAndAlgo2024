package Hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

	//only +ve integers
	public static int longestConsecutive(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        int arr[] = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        int tmax = 0;
        int lmax = 0;
        for ( int i = 0; i <= max; i++) {
            if (arr[i] == 0) {
                lmax = 0;
            } else {
                lmax+=arr[i];
            }
            if (lmax> tmax)
                tmax = lmax;
        }
        return tmax;
    }
	
	static int findLongestConseqSubseq(int arr[], int n) {
		HashSet<Integer> S = new HashSet<Integer>();
		int ans = 0;

		for (int i = 0; i < n; ++i)
			S.add(arr[i]);

		for (int i = 0; i < n; ++i) {

			if (!S.contains(arr[i] - 1)) {

				int j = arr[i];
				while (S.contains(j))
					j++;
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		return ans;
	}
	
	 public int longestConsecutive1(int[] arr) {
	        HashSet<Integer> set = new HashSet<Integer>();
	        int ans = 0;

	        for (int i = 0; i < arr.length; i++) {
	            if (!set.contains(arr[i] - 1)) {
	                int j = arr[0];
	                while (set.contains(j))
	                    j++;

	                if (ans < j - arr[i])
	                    ans = j - arr[i];
	            }
	        }
			return ans;

	    }

	public static void main(String arg[]) {
		int arr[] = {100,4,200,1,3,2};


		int l = findLongestConseqSubseq(arr, arr.length);
		System.out.println(l);
	}
}
