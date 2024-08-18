package Graph;

public class AjencyMatrixImpl {

	private int n;
	private int[][] g = new int[10][10];

	AjencyMatrixImpl(int x) {
		this.n = x;

		// Initializing each element of the
		// adjacency matrix to zero
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				g[i][j] = 0;
			}
		}
	}

	public void displayAdjacencyMatrix() {
		for (int i = 0; i < n; ++i) {
			System.out.println();
			for (int j = 0; j < n; ++j) {
				System.out.print(" " + g[i][j]);
			}
		}
		System.out.println();
	}

	public void addEdge(int x, int y) {
		if (x < 0 || x >= n)
			System.out.println("vertex does not exist");

		if (y < 0 || y >= n)
			System.out.println("vertex does not exist");

		if (x == y)
			System.out.println("same vertex");
		else {
			g[x][y] = 1;
			g[y][x] = 1;
		}
	}

	public void removeEdge(int x, int y) {
		if (x < 0 || x >= n)
			System.out.println("vertex does not exist");

		if (y < 0 || y >= n)
			System.out.println("vertex does not exist");

		if (x == y)
			System.out.println("same vertex");
		else {
			g[x][y] = 0;
			g[y][x] = 0;
		}
	}

	public static void main(String args[]) {
		AjencyMatrixImpl obj = new AjencyMatrixImpl(6);
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(0, 3);
		obj.addEdge(0, 4);
		obj.addEdge(1, 3);
		obj.addEdge(2, 3);
		obj.addEdge(2, 4);
		obj.addEdge(2, 5);
		obj.addEdge(3, 5);
		System.out.println("Adjacency matrix after" + " edge insertions:");
		obj.displayAdjacencyMatrix();
		obj.removeEdge(2, 3);
		System.out.println("Adjacency matrix after" + " edge removal:");
		obj.displayAdjacencyMatrix();

	}
}
