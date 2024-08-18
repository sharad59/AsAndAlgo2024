package BackTacrking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	static int m = 0;
	static int n = 0;

	public static String[] wordBoggle(char board[][], String[] dictionary) {
		m = board.length;
		n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		String str = "";
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				wordBoggleUtil(board, visited, i, j, str, strList, dictionary);
			}
		}
		String[] strings = strList.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(strings));
		return strings;
	}

	static void wordBoggleUtil(char board[][], boolean visited[][], int i, int j, String str, List<String> strList,
			String[] dictionary) {
		visited[i][j] = true;

		str += board[i][j];

		if (isWord(str, dictionary)) {
			strList.add(str);
		}

		for (int row = i - 1; row <= i + 1 && row < m; row++)
			for (int col = j - 1; col <= j + 1 && col < n; col++)
				if (row >= 0 && col >= 0 && !visited[row][col])
					wordBoggleUtil(board, visited, row, col, str, strList, dictionary);
			
		
		str = "" + str.charAt(str.length() - 1);
		visited[i][j] = false;

	}

	static boolean isWord(String str, String[] d) {
		for (int i = 0; i < d.length; i++) {

			if (str.equals(d[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		char boggle[][] = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
		String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };

		System.out.println("Following words of dictionary are present");
		System.out.println( wordBoggle(boggle, dictionary));
	}
}
