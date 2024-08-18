package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	public static class Ele {
		int x;
		int y;

		Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean checkAll(int arr[][]) {

		int r = arr.length;
		int c = arr[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 1)
					return true;

			}
		}
		return false;
	}

	boolean isDelim(Ele ele) {

		return ele.x == -1 && ele.y == -1;
	}

	boolean isValid(int i, int j, int r, int c) {
		return i >= 0 && j >= 0 && i < r && j < c;
	}

	public int orangesRotting(int[][] arr) {
		Queue<Ele> q = new LinkedList<>();

		int r = arr.length;
		int c = arr[0].length;

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (arr[i][j] == 2)
					q.add(new Ele(i, j));

		q.add(new Ele(-1, -1));

		int ans = 0;
		Ele temp;

		while (!q.isEmpty()) {
			boolean flag = false;
			while (!isDelim(q.peek())) {
				temp = q.peek();

				if (isValid(temp.x + 1, temp.y, r, c) && arr[temp.x + 1][temp.y] == 1) {

					if (!flag) {
						flag = true;
						ans += 1;
					}
					arr[temp.x + 1][temp.y] = 2;
					q.add(new Ele(temp.x + 1, temp.y));

				}

				if (isValid(temp.x - 1, temp.y, r, c) && arr[temp.x - 1][temp.y] == 1) {

					if (!flag) {
						flag = true;
						ans += 1;
					}
					arr[temp.x - 1][temp.y] = 2;
					q.add(new Ele(temp.x - 1, temp.y));

				}

				if (isValid(temp.x, temp.y + 1, r, c) && arr[temp.x][temp.y + 1] == 1) {

					if (!flag) {
						flag = true;
						ans += 1;
					}
					arr[temp.x][temp.y + 1] = 2;
					q.add(new Ele(temp.x, temp.y + 1));

				}

				if (isValid(temp.x, temp.y - 1, r, c) && arr[temp.x][temp.y - 1] == 1) {

					if (!flag) {
						flag = true;
						ans += 1;
					}
					arr[temp.x][temp.y - 1] = 2;
					q.add(new Ele(temp.x, temp.y - 1));

				}
				q.remove();

			}
			q.remove();
			if (!q.isEmpty()) {
				q.add(new Ele(-1, -1));
			}
		}
		return checkAll(arr) ? -1 : ans;

	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };

		int ans = new RottenOranges().orangesRotting(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot => " + ans);
	}
}
