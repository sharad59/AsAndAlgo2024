package Btree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxZizZagpathTraversalCount {

	public static void main(String args[]) {

	}



	int pathLength = 0;

	private void dfs(TreeNode node, boolean goLeft, int steps) {
		if (node == null) {
			return;
		}
		pathLength = Math.max(pathLength, steps);
		if (goLeft) {
			dfs(node.left, false, steps + 1);
			dfs(node.right, true, 1);
		} else {
			dfs(node.left, false, 1);
			dfs(node.right, true, steps + 1);
		}
	}

	public int longestZigZag1(TreeNode root) {
		dfs(root, false, 0);
		dfs(root, true, 0);
		return pathLength;
	}

	class Pair {
		TreeNode node;
		int len;
		int dir;

		public Pair(TreeNode node, int len, int dir) {
			this.node = node;
			this.len = len;
			this.dir = dir;
		}
	}

	// 0: gone left, 1: gone right
	public int longestZigZag(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 0;
		int max = Integer.MIN_VALUE;
		Queue<Pair> que = new LinkedList<>();

		que.add(new Pair(root, 0, -1));

		while (que.size() != 0) {
			Pair rem = que.poll();
			if (rem.len > max)
				max = rem.len;

			if (rem.dir == -1) { // for processing the root node
				if (rem.node.left != null)
					que.add(new Pair(rem.node.left, rem.len + 1, 0));
				if (rem.node.right != null)
					que.add(new Pair(rem.node.right, rem.len + 1, 1));
			} else if (rem.dir == 0) { // if we have gone left in the prev step, the len of path will increase only if
										// we go right in this step
				if (rem.node.right != null)
					que.add(new Pair(rem.node.right, rem.len + 1, 1));
				if (rem.node.left != null) {
					if (rem.node.left.right != null)
						que.add(new Pair(rem.node.left, 1, 0));
					else
						que.add(new Pair(rem.node.left, 0, 0));
				}
			} else {
				if (rem.node.left != null)
					que.add(new Pair(rem.node.left, rem.len + 1, 0));
				if (rem.node.right != null) {
					if (rem.node.right.left != null)
						que.add(new Pair(rem.node.right, 1, 1));
					else
						que.add(new Pair(rem.node.right, 0, 1));
				}
			}

		}
		return max;
	}
}
