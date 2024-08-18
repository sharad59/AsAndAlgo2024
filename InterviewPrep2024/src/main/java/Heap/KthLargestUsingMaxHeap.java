package Heap;

public class KthLargestUsingMaxHeap {
	// remove the top K-1 elements from the heap. The top element will be Kth's
	// Largest element
	static int findthElement(int arr[], int k) {

		for (int i = arr.length / 2 - 1; i >= 0; i--)
			heapify(i, arr.length, arr);
		int n=arr.length;
		
		for (int i = 0; i < k - 1; i++) {
			removeMaxElement(arr,n-i);
		}
		return arr[0];
	}

	public static void removeMaxElement(int arr[], int n) {
		int temp = arr[0];
		arr[0] = arr[n - 1];
		arr[n - 1] = temp;
		heapify(0, n, arr);
	}

	public static void heapify(int i, int n, int arr[]) {

		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < n && arr[left] > arr[i])
			largest = left;
		if (right < n && arr[right] > arr[largest])
			largest = right;

		if (i != largest) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(largest, n, arr);
		}

	}

	public static void main(String args[]) {
		int arr[] = { 3, 2, 1, 5, 6, 4 };
		int k = 3;
		System.out.println(findthElement(arr, k));

	}
}
