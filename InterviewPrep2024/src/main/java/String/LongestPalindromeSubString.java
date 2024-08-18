package String;

public class LongestPalindromeSubString {

	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high));
	}

	static int longestPalSubstr(String str) {
		int n = str.length();
		boolean table[][] = new boolean[n][n];

		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= n; k++) {

			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		System.out.print("Longest palindrome substring is: ");
		printSubStr(str, start, start + maxLength);
		return maxLength;
	}

	static String maxPalindrome(String str) {
	str	=str.replaceAll("[^0-9a-zA-Z\\n]", "");
		System.out.println(str);
		int n = str.length();

		boolean arr[][] = new boolean[n][n];
		int start = 0, max = 0;
		for (int i = 0; i < n; i++) {
			arr[i][i] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1))
				arr[i][i + 1] = true;
			max = 2;
		}

		for (int k = 3; k <= n; k++) {

			for (int i = 0; i < n - k - 1; i++) {
				int j = i + k - 1;

				if (str.charAt(i) == str.charAt(j) && arr[i + 1][j - 1] == true) {
					arr[i][j] = true;
					if (k > max) {
						start = i;
						max = k;
					}
				}
			}
		}
		return str.substring(start, start + max);
	}

	public static void main(String[] args) {
		String str = "sharahdd  ha,t:yi";
		System.out.println("Length is: " + maxPalindrome(str));
	}
}
