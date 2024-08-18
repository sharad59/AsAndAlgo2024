package String;

public class LongestPalindromeSubStringV2 {

	static void printSubStr(String str, int low, int high) {
		for (int i = low; i <= high; ++i)
			System.out.print(str.charAt(i));
		System.out.println();
	}

	static int longestPalSubstr(String s) {
		int n = s.length();
		int start = 0, maxl = 1;
		int low, hi;

		for (int i = 1; i < n; i++) {

			low = i - 1;
			hi = i;

			while (low >= 0 && hi < n && s.charAt(low) == s.charAt(hi)) {
				if (hi - low + 1 > maxl) {
					start = low;
					maxl = hi - low + 1;
				}
				low--;
				hi++;
			}

			low = i - 1;
			hi = i + 1;

			while (low >= 0 && hi < n && s.charAt(low) == s.charAt(hi)) {
				if (hi - low + 1 > maxl) {
					start = low;
					maxl = hi - low + 1;
				}
				low--;
				hi++;
			}
		}

		System.out.print("Longest palindrome substring is: ");
		printSubStr(s, start, start + maxl - 1);
		return maxl;
	}

	// Driver code
	public static void main(String[] args) {
		String s = "fsqwxqvfqlxaz";
		int length = longestPalSubstr(s);
		System.out.println("Length: " + length);
	}
}
