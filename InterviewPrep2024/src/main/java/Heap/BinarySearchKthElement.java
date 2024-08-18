package Heap;

public class BinarySearchKthElement {

	public static int findKthLargest(int[] arr, int n, int k) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;

		for (int i : arr) {
			low = Math.min(low, i);
			high = Math.max(high, i);
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;

			for (int i : arr) {
				if (i > mid) {
					count++;
				}
			}
			if (count >= k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}

	public static void printKLargest(int[] arr, int n, int k) {
		int kthLargest = findKthLargest(arr, n, k);
		for (int i : arr) {
			if (i >= kthLargest) {
				System.out.print(" " + i);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 5, 787, 1, 23 };
		int n = arr.length;
		int k = 2;

		System.out.print("K largest elements:");
		printKLargest(arr, n, k);
	}
}
