package Graph;

public class NoOfIslands {

	static boolean isSafe(char[][] M, int r, int c, boolean[][] visited) {
		int ROW = M.length;
		int COL = M[0].length;

		return r >= 0 && r < ROW && c >= 0 && c < COL && M[r][c] == '1' && !visited[r][c];
	}

	static int countIslands(char[][] M) {
		int ROW = M.length;
		int COL = M[0].length;

		boolean[][] visited = new boolean[ROW][COL];

		int count = 0;
		for (int r = 0; r < ROW; ++r) {
			for (int c = 0; c < COL; ++c) {
				if (M[r][c] == '1' && !visited[r][c]) {
					DFS(M, r, c, visited);
					++count;
				}
			}
		}
		return count;
	}

	static void DFS(char[][] M, int r, int c, boolean[][] visited) {

		int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

		visited[r][c] = true;

		for (int k = 0; k < 8; ++k) {
			int newR = r + rNbr[k];
			int newC = c + cNbr[k];
			if (isSafe(M, newR, newC, visited)) {
				DFS(M, newR, newC, visited);
			}
		}
	}

	public static void main(String[] args) {
 char[][] M = { { '1', '1', '0', '0', '0' },
				{ '0', '1', '0', '0', '1' }, 
				{ '1', '0', '0', '1', '1' },
				{ '0', '0', '0', '0', '0' },
				{ '1', '0', '1', '1', '0' } };

		System.out.println(countIslands(M));
	}
}
