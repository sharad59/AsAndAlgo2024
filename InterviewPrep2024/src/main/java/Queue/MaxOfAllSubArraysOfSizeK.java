package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxOfAllSubArraysOfSizeK {

	static void printMax(int arr[], int N, int K) {
		Deque<Integer> Qi = new LinkedList<Integer>();
		int i;
		for (i = 0; i < K; ++i) {

			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast();
			Qi.addLast(i);
		}

		for (; i < N; ++i) {
			System.out.print(arr[Qi.peek()] + " ");
			while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
				Qi.removeFirst();

			while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast();
			Qi.addLast(i);
		}

		System.out.print(arr[Qi.peek()]);
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
	// ans[] = new int[n - k + 1];
		List<Integer> l = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<>();
		int i = 0;
		for (; i < k; i++) {
			while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
				dq.removeLast();

			dq.addLast(i);

		}

		for (; i < n; ++i) {
			l.add(nums[dq.peek()]);
			while (!dq.isEmpty() && dq.peek() <= i - k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
				dq.removeLast();

			dq.addLast(i);
		}
		l.add(nums[dq.peek()]);

		int[] arr = l.stream().mapToInt(Integer::intValue).toArray();
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int K = 3;
		int arr1[] = maxSlidingWindow(arr, K);
		System.out.println(Arrays.toString(arr1));
	}
}
