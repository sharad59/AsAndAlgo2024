package Array;

public class MaximumDifferencebetweenTwoElementssuchthatLargerElementAppear {

	 public static void main(String[] args) 
	    { 
		int  arr[] = {2, 3, 10, 6, 4, 8, 1};
	        int n = arr.length; 
	  
	        System.out.print(maxDiff(arr,n)); 
	    }

	private static int maxDiff(int[] arr, int n) {
		
		int min=arr[0];
		int max_diff=arr[1]-arr[0];
		int res=0;
		for(int i=1;i<n;i++) {
			
			if(arr[i]<min) {
				min=arr[i];
			}
			
			if(arr[i]-min>max_diff) {
				max_diff=arr[i]-min;
			}
			
		}
		return max_diff;

	}

	static int maxProfit(int prices[], int size) {

		int maxProfit = 0;

		for (int i = 1; i < size; i++)
			if (prices[i] > prices[i - 1])
				maxProfit += prices[i] - prices[i - 1];
		return maxProfit;
	}
}
