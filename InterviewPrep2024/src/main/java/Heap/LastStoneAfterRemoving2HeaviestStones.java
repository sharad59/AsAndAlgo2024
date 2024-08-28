package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneAfterRemoving2HeaviestStones {

	public static int lastStoneWeight(int[] stones) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int stone : stones)
			pq.add(stone);

		while (pq.size() > 0) {

			if (pq.size() == 1)
				return pq.poll();

			int y = pq.poll();
			int x = pq.poll();
			if (y != x) {
				pq.add(y - x);
			}
		}

		return 0;
	}

	public static void main(String args[]) {
/*
 * We are playing a game with the stones.
 *  On each turn, we choose the heaviest two stones and smash them together.
 *  Suppose the heaviest two stones have weights x and y with x <= y. 
 *  The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.
 */
		int arr[] = { 2, 7, 4, 1, 8, 1 };

		System.out.println(lastStoneWeight(arr));

	}
}
