package Heap;

import java.util.PriorityQueue;

public class KthSmallestElement {

	static void kth_Smallest_MinHeap(int[] arr, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			pq.add(arr[i]);
		}
		int f = k - 1;
		while (f > 0) {
			pq.remove();
			f--;
		}

		System.out.println("Kth Smallest element " + pq.peek());
	}
	
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int N = arr.length;
	kth_Smallest_MinHeap(arr, 2);
		
	}
	
}
