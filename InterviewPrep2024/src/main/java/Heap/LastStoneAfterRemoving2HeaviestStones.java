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

		int arr[] = { 2, 7, 4, 1, 8, 1 };

		System.out.println(lastStoneWeight(arr));

	}
}
