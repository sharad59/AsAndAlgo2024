package Sorting;

import java.util.Arrays;

public class HeapSort {

	public void sort(int arr[]) {
		int N = arr.length;

		// Build heap (rearrange array)
		for (int i = N / 2 - 1; i >= 0; i--)
			heapify(arr, N, i);

		// One by one extract an element from heap
		for (int i = N - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	void heapify(int arr[], int N, int i) {
		int largest = i;
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2
		if (l < N && arr[l] > arr[largest])
			largest = l;
		if (r < N && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, N, largest);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int N = arr.length;
		HeapSort ob = new HeapSort();
		ob.heapSort(arr, N);
		System.out.println(Arrays.toString(arr));
	}

	void buildHeap(int arr[], int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify1(arr, n, i);
		}
	}

	// Heapify function to maintain heap property.
	void heapify1(int arr[], int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l < n && arr[l] > arr[i])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (i != largest) {
			int t = arr[i];
			arr[i] = arr[largest];
			arr[largest] = t;
			heapify1(arr, n, largest);
		}
	}

	// Function to sort an array using Heap Sort.
	public void heapSort(int arr[], int n) {
		buildHeap(arr, n);
		for (int i = n - 1; i >= 0; i--) {
			int t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;
			heapify1(arr, i, 0);
		}
	}
}
