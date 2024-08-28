package DyamicProgramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public static int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n], count = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        int res = 0, maxi = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j ) {
                if (arr[j] < arr[i] && lis[i]<lis[j]+1 ) {
                    lis[i] =  lis[j]+1;
                    count[i] = count[j];
                } else if (arr[j] < arr[i] && 1 + lis[j] == lis[i])
                    count[i] += count[j];
            }
            maxi = Math.max(maxi, lis[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (lis[i] == maxi)
                res += count[i];
        }

        return res;
    }
	
    public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + findNumberOfLIS(arr));
	}
}
