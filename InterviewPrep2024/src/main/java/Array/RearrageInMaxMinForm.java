package Array;

import java.util.Arrays;

public class RearrageInMaxMinForm {

	public static void main(String args[]) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		rearrange(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	private static void rearrange(int[] arr, int n) {
		int min = 0;
		int max = n - 1;
		int arr2[] = arr.clone();
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			if (flag) {
				arr[i] = arr2[max];
				max--;
			} else {
				arr[i] = arr2[min];
				min++;
			}
			flag=!flag;
		}

	}
}
