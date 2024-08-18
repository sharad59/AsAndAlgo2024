package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class SwappingPairsToMakeSumEqual {

	static int getTarget(int A[], int n, int B[], int m) {
		int sum1 = Arrays.stream(A).sum();
		int sum2 = Arrays.stream(B).sum();

		if ((sum1 - sum2) % 2 != 0)
			return 0;
		return ((sum1 - sum2) / 2);
	}

	static void findSwapValues(int A[], int n, int B[], int m) {
		Arrays.sort(A);
		Arrays.sort(B);

		int target = getTarget(A, n, B, m);

		if (target == 0)
			return;

		int i = 0, j = 0;
		while (i < n && j < m) {
			int diff = A[i] - B[j];
			if (diff == target) {
				System.out.println(A[i] + " " + B[i]);
				return;
			}

			else if (diff < target)
				i++;

			else
				j++;
		}
	}

	 static long findSwapValues(long A[], int n, long  B[], int m)
	    {
			long sumA = Arrays.stream(A).sum();
			long sumB = Arrays.stream(B).sum();

	        if((sumA-sumB)%2!=0)
	        return -1;
	        long diffSum =0;
	        //System.out.println(sumA);

	         diffSum =(sumA-sumB)/2;
	        
	        HashSet<Long> set= new HashSet<Long>();
	        for(int j=0;j<m;j++){
	           set.add(B[j]); 
	        }
	        
	        for(int i=0;i<n;i++){
	            if(set.contains(A[i]-diffSum))
	            	System.out.println(A[i]+" "+(A[i]-diffSum) );
	            return 1;
	        }
	        return -1;
	    }
	    
	    
	    long getSum (long arr[] , int n){
	        long sum =0;
	        for(int i=0;i<n;i++){
	            sum+=arr[0];
	        }
	        return sum;
	    }
	
	public static void main(String[] args) {
		long A[] = {5, 7, 4, 6};
		int n = A.length;
		long B[] = {1, 2, 3, 8};
		int m = B.length;

		 System.out.println(findSwapValues(A, n, B, m));
	}
}
