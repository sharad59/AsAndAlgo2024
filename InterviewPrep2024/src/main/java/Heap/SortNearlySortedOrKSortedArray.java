package Heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortNearlySortedOrKSortedArray {

	private static void kSort(int[] arr, int n, int k)
    {
        if (arr == null || arr.length == 0) {
            return;
        }
        PriorityQueue<Integer> priorityQueue
            = new PriorityQueue<>();

        int minCount = Math.min(arr.length, k + 1);
        // add first k + 1 items to the min heap
        // as the smallest element will be among the first k+1 elements // as each element can move k steps
        for (int i = 0; i < minCount; i++) {
            priorityQueue.add(arr[i]);
        }
 
        int index = 0;
        // here even if size=k then n will be n=k,so i<n
        // works fine
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }
	//Time Complexity: O(K) + O((N – K) * log(k))

	public static void main(String args[]) {
		
		 int k = 3;
	        int arr[] = { 2, 6, 3, 12, 56, 8 };
	        int n = arr.length;
	        kSort(arr, n, k);
		 	  System.out.println(Arrays.toString(arr));  

	}
}
