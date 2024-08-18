 package Array;

import java.util.Arrays;

public class Merge2SortedArray {

	static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
    static int arr2[] = new int[] { 2, 3, 8, 13 };
    
	
	 public static void main(String[] args)
	    {
		 
	        merge2(arr1.length, arr2.length);
	        System.out.print("After Merging \nFirst Array: ");
	        System.out.println(Arrays.toString(arr1));
	        System.out.print("Second Array:  ");
	        System.out.println(Arrays.toString(arr2));
	    }


	private static void merge(int m, int n) {
		
		for(int i=n-1;i>=0;i--) {			
			int key=arr1[m-1];
			int j=m-2;
			while(j>=0&& arr1[j]>arr2[i]) {
				arr1[j+1]=arr1[j];
				j=j-1;				
			}
			
			if(key>arr2[i]) {
				arr1[j+1]=arr2[i];
				arr2[i]=key;
			}
		}
	}
	 static void merge2(int m, int n)
	    {
	        int i = 0, j = 0, k = m - 1;
	        while (i <= k && j < n) {
	            if (arr1[i] < arr2[j])
	                i++;
	            else {
	                int temp = arr2[j];
	                arr2[j] = arr1[k];
	                arr1[k] = temp;
	                j++;
	                k--;
	            }
	        }
	        Arrays.sort(arr1);
	        Arrays.sort(arr2);
	    }
	//	static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
	//    static int arr2[] = new int[] { 2, 3, 8, 13 };
	    	 
}
