package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static  int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>();

        for(int i=0;i<k;i++)
        pq.add(arr[i]);

        for(int i=k;i<arr.length;i++){
            if(arr[i]>pq.peek())
            { pq.remove();
            pq.add(arr[i]);}
        }
        return pq.peek();
    }
    
    //Kth  largest using Max Heap
	static void kth_Largest_MaxHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int f = k - 1;
		while (f > 0) {
			pq.remove();
			f--;
		}
		System.out.println("Kth Largest element " + pq.peek());
	}
    
    
    public static void main(String args[]) {
    	int arr[]= {3,2,1,5,6,4};
    	System.out.println(findKthLargest(arr, 2));
    	
    	
    }
}
