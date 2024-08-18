package Greedy;

import java.util.Deque;
import java.util.LinkedList;

public class PageFaultsInLRU {

	static int pageFaults(int N, int C, int pages[]) {

		Deque<Integer> q = new LinkedList<>();

		int l = pages.length;
		int i = 0;
		int c = 0;
		while (i < l) {

			if (q.isEmpty() || !q.contains(pages[i])) {

				if (q.size() == C)
					q.removeLast();

				q.addFirst(pages[i]);
				c++;
			} else {
				q.remove(pages[i]);
				q.addFirst(pages[i]);

			}
			i++;
		}

		return c;

	}

	public static void main(String[] args) {
		int pages[] = new int[] { 1, 2, 1, 4, 2, 3, 5 };
		int n = 7, c = 3;

		System.out.println("Page Faults = " + pageFaults(n, c, pages));
	}
}
