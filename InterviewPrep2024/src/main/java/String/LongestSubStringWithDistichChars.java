package String;

import java.util.Arrays;

public class LongestSubStringWithDistichChars {
    static final int NO_OF_CHARS = 256;

	//O(n^2) complexity
	public static int longestUniqueSubsttr(String str) {
		int n = str.length();

		int res = 0;

		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[256];
			for (int j = i; j < n; j++) {
				if (visited[str.charAt(j)] == true)
					break;
				else {
					res = Math.max(res, j - i + 1);
					visited[str.charAt(j)] = true;
				}
			}
			//visited[str.charAt(i)] = false;
		}
		return res;
	}

	public static int longestUniqueSubStr(String str) {
		if (str.length() == 0)
			return 0;

		if (str.length() == 1)
			return 1;

		int maxLength = 0;
		boolean[] visited = new boolean[256];

		int left = 0, right = 0;
		while (right < str.length()) {

			if (visited[str.charAt(right)]) {

				while (visited[str.charAt(right)]) {

					visited[str.charAt(left)] = false;
					left++;
				}
			}

			visited[str.charAt(right)] = true;
			maxLength = Math.max(maxLength, (right - left + 1));
			right++;
		}
		return maxLength;
	}

	static int longestUniqueSubStr1(String str) {
		int n = str.length();

		int res = 0;

		int[] lastIndex = new int[NO_OF_CHARS];
		Arrays.fill(lastIndex, -1);

		int i = 0;
		for (int j = 0; j < n; j++) {

			i = Math.max(i, lastIndex[str.charAt(j)] + 1);
			res = Math.max(res, j - i + 1);
			lastIndex[str.charAt(j)] = j;
		}
		return res;
	}

	public static void main(String[] args) {
		String str = "geeksfeorgeeks";
		System.out.println("The input string is " + str);

		int len = longestUniqueSubStr(str);
		System.out.println("The length of the longest " + "non-repeating character " + "substring is " + len);
	}

}
