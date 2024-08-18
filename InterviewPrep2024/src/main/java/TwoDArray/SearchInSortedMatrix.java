package TwoDArray;

public class SearchInSortedMatrix {

	private static void search(int[][] mat,  int x) {
		int m= mat.length;
		int n=mat[0].length;
		int i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (mat[i][j] == x) {
				System.out.print("Element found at (" + i + ", " + j + ")");
				return;
			}
			if (mat[i][j] > x)
				j--;
			else // if mat[i][j] < x
				i++;
		}

		System.out.print("Element not found");
		return; // if ( i==n || j== -1 )
	}

	public static void main(String args[]) {
//int mat[][] = { { 10, 20, 30, 40 },{ 15, 25, 35, 45 },{ 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

  int mat1[][]={{1,3,5,7},{10,11,16,20},{23,30,34,60}};

		search(mat1,  3);
	}
}
