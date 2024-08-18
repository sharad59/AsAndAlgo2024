package Array;

import java.util.Arrays;
import java.util.HashSet;

public class PythagorasTriplet {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 4, 6, 5 };
		int n = arr.length;
		if (checkTriplet(arr, n) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean isTriplet(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);
		for (int i = n - 1; i >= 2; i--) {
			int l = 0, r = i - 1;

			while (l < r) {
				if (arr[l] + arr[r] == arr[i])
					return true;
				if (arr[l] + arr[r] < arr[i])
					l++;
				else {
					r--;
				}
			}
		}
		return false;

	}

	static boolean checkTriplet(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] * arr[i];
		}
		//Arrays.sort(arr);
		for (int i = n - 1; i > 1; i--) {
			HashSet<Integer> s = new HashSet<>();
			for (int j = i - 1; j >= 0; j--) {
				if (s.contains(arr[i] - arr[j])) {
					return true;
				}
				s.add(arr[j]);
			}
		}
		return false;
	}
}
