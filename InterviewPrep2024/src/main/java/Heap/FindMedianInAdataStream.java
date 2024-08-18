package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianInAdataStream {

	PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;

	public FindMedianInAdataStream() {
		left = new PriorityQueue<>(Collections.reverseOrder());
		right = new PriorityQueue<>();

	}

	public void addNum(int num) {

		if (left.isEmpty() || num <= left.peek()) {
			left.add(num);
		} else {
			right.add(num);
		}

		if (left.size() > right.size() + 1) {
			right.add(left.remove());
		}

		else if (left.size() < right.size()) {
			left.add(right.remove());
		}

	}

	public double findMedian() {

		int lsize = left.size();
		int rsize = right.size();
		if (lsize > rsize) {
			return left.peek();
		} else {
			return (left.peek() + right.peek()) / 2.0;
		}

	}
	
	public static void main(String args[]) {
		
		
	}
}
