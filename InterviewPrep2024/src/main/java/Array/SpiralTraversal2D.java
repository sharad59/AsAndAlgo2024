package Array;

public class SpiralTraversal2D {

	public static void main(String args[]) {
		int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int r = arr.length;
		int c = arr[0].length;
		printSpiral(arr, r, c);
	}

	private static void printSpiral(int[][] arr, int m, int n) {
		int k = 0, l = 0, i = 0;

		while (k < m && l < n) {

			for (i = l; i < n; i++) {
				System.out.print(arr[k][i] + ", ");
			}
			k++;
			for (i = k; i < m; i++) {
				System.out.print(arr[i][n - 1] + ", ");
			}
			n--;

			if (k < m) {
				for (i = n - 1; i >= l; i--) {
					System.out.print(arr[m - 1][i] + ", ");
				}
				m--;
			}

			if (l < n) {
				for (i = m - 1; i >= k; i--)
					System.out.print(arr[i][l] + ", ");
				l++;
			}

		}
	}

}
