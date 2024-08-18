package TwoDArray;

public class ClockwiseRotateBy90 {

	static int N = 4;

	static void rotate90Clockwise(int arr[][]) {

		TransposeOfMatrix.transpose(arr);
		for (int i = 0; i < N; i++) {
			int l = 0;
			int r = N - 1;
			while (l < r) {
				int temp = arr[i][l];
				arr[i][l] = arr[i][r];
				arr[i][r] = temp;
				l++;
				r--;

			}
		}
		printMatrix(arr);
	}

	public static void rotate90ClockwiseBruteForce(int arr[][], int n) {
		int i = 0, j = 0;
		arr[j][n - i - 1] = arr[i][j];
	}

	static void printMatrix(int arr[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
int arr[][] = { { 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10,11,12},
				{ 13, 14,15,16}};
		//rotate90ClockwiseBruteForce(arr, N);
		 rotate90Clockwise(arr);
		// printMatrix(arr);
	}
}
