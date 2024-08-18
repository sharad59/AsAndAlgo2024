package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxActivitiesThatcanBePerformed {

	public static class pair {
		int first;
		int sec;

		pair(int f, int s) {
			first = f;
			sec = s;
		}
	}

	public static int activitySelection(int start[], int end[], int n) {
		pair arr[] = new pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new pair(start[i], end[i]);
		}

		/*
		 * Arrays.sort(arr, new Comparator<pair>() {
		 * 
		 * @Override public int compare(pair p1, pair p2) { return p1.sec - p2.sec; }
		 * 
		 * });
		 */

		Arrays.sort(arr, (p1, p2) -> {
			return p1.sec - p2.sec;
		});

		int i = 0;
		int j;
		int count = 1;
		for (j = 1; j < n; j++) {
			if (arr[j].first > arr[i].sec) {
				count++;
				i = j;
			}
		}
		return count;
	}

	public static int activitySelection1(int start[], int end[], int n) {
		int mat[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			mat[i][0] = start[i];
			mat[i][1] = end[i];
		}

		Arrays.sort(mat, (a, b) -> {
			return a[1] - b[1];
		});

		int ans = 1;
		int lastEnd = mat[0][1];
		for (int i = 1; i < n; i++) {
			if (mat[i][0] > lastEnd) {
				ans++;
				lastEnd = mat[i][1];
			}
		}
		return ans;
	}

	public static void main(String args[]) {
		// int s[] = { 5,3,9,2,2 };
		// int f[] = { 8, 10, 9, 4, 9 };
		// int s[] = { 2, 6, 4, 1 ,4, 2, 3 };
		// int f[] = { 4 ,10, 9, 9, 4, 5, 4};

		int s[] = { 1, 3, 2, 5 };
		int f[] = { 2, 4, 3, 6 };

		int n = s.length;
		System.out.println(activitySelection(s, f, n));
	}
}
