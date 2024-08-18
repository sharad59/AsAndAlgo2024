package Hashing;

public class SmallestWindowInAStringContainingAllCharactersOfOtherString {
    static final int no_of_chars = 256;

	static String findSubString(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();

		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}

		int hash_pat[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];

		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		int count = 0;
		for (int j = 0; j < len1; j++) {

			hash_str[str.charAt(j)]++;
			 //If string's char matches with pattern's char then increment count
			if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;
			
            // If all the characters are matched
			if (count == len2) {

				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {

					//if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		return str.substring(start_index, start_index + min_len);
	}

	public static void main(String[] args) {
		String str1 = "zoomlazapzo";
		String pattern1 = "oza";
		System.out.println("Input: string = \"" + str1 + "\", pattern = \"" + pattern1 + "\"");
		System.out.println("Output: \"" + findSubString(str1, pattern1) + "\"");
		
		String str2 = "geeksforgeeks";
		String pattern2 = "ork";
		System.out.println("Input: string = \"" + str2 + "\", pattern = \"" + pattern2 + "\"");
		System.out.println("Output: \"" + findSubString(str2, pattern2) + "\"");
	}

	private static String findSmallestSubstring(String str1, String str2) {

		int l1 = str1.length();
		int maxLength = Integer.MAX_VALUE;
		String resString = null;
		for (int i = 0; i < l1; i++) {
			for (int j = i ; j < l1; j++) {
				String temp = str1.substring(i, j+1);
				if (ispatternPartOfString(temp, str2)) {

					if (maxLength > temp.length()) {
						maxLength = temp.length();
						resString = temp;
					}
				}
			}
		}
		return resString;
	}

	private static boolean ispatternPartOfString(String substring, String str2) {
		int arr[] = new int[256];

		for (int i = 0; i < str2.length(); i++) {

			arr[str2.charAt(i) ]++;
		}

		for (int i = 0; i < substring.length(); i++) {

			arr[substring.charAt(i)]--;
		}

		for (int i = 0; i < 256; i++) {
			if (arr[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
