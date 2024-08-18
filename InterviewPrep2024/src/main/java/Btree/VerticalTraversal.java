package Btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
	
	static void getVerticalOrder(Node root, int hd, TreeMap<Integer, List<Integer>> m) {
		if (root == null)
			return;

		List<Integer> get = m.get(hd);
		if (get == null) {
			get = new ArrayList<>();
			get.add(root.key);
		} else
			get.add(root.key);

		m.put(hd, get);

		getVerticalOrder(root.left, hd - 1, m);
		getVerticalOrder(root.right, hd + 1, m);
	}

	static void printVerticalOrder(Node root) {

		TreeMap<Integer, List<Integer>> m = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(root, hd, m);

		for (Entry<Integer, List<Integer>> entry : m.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println("Vertical Order traversal is");
		printVerticalOrder(root);
	}
	
	 static class pair {
	        Node first;
	        int second;
	        pair(Node first, int second)
	        {
	            this.first = first;
	            this.second = second;
	        }
	    }

		static void printVerticalOrderbfs(Node root) {
			if (root == null)
				return;

			HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
			int hd = 0;

			Queue<pair> q = new LinkedList<>();
			q.add(new pair(root, hd));
			int mn = 0, mx = 0;
			while (q.size() > 0) {
				pair temp = q.remove();

				hd = temp.second;
				Node node = temp.first;
				if (!m.containsKey(hd))
					m.put(hd, new ArrayList<>());
				m.get(hd).add(node.key);

				if (node.left != null)
					q.add(new pair(node.left, hd - 1));
				if (node.right != null)
					q.add(new pair(node.right, hd + 1));
				if (mn > hd)
					mn = hd;
				else if (mx < hd)
					mx = hd;
			}

			for (int i = mn; i <= mx; i++) {
				ArrayList<Integer> tmp = m.get(i);
				for (int j = 0; j < tmp.size(); j++)
					System.out.print(tmp.get(j) + " ");

				System.out.println();
			}
		}
}
