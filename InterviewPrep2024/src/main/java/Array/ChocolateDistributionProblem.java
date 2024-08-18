package Array;

import java.util.Arrays;

public class ChocolateDistributionProblem {

	public static void main(String args[]) {
		int M = 5;
		int arr[] = { 3, 4, 1, 9, 56, 7, 9, 12 };
		distributeChocolates(arr, M);
	}

	private static void distributeChocolates(int[] arr, int m) {

		Arrays.sort(arr);
		m=m-1;
		if(arr.length<m)
			{System.out.println("not possible");
		return;}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1-m;i++) {
			if(  arr[i+m]-arr[i]<min)
				min=arr[i+m]-arr[i];
		}
		System.out.println(min);
		
	}
}
