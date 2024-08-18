package Greedy;

import java.util.Arrays;

public class SwapOccuranceOf2CharactersToGetSmallestString {

	static int MAX = 26;

	static String smallestStr(char[] str, int n) {
		int i, j = 0;

		int[] chk = new int[MAX];
		Arrays.fill(chk, -1);

		for (i = 0; i < n; i++) {

			if (chk[str[i] - 'a'] == -1)
				chk[str[i] - 'a'] = i;
		}

		for (i = 0; i < n; i++) {
			boolean flag = false;

			for (j = 0; j < str[i] - 'a'; j++) {

				if (chk[j] > chk[str[i] - 'a']) {
					flag = true;
					break;
				}
			}

			if (flag)
				break;
		}

		 System.out.println(i);
			System.out.println(j);

		if (i < n - 1) {
			char ch1 = str[i];
			char ch2 = (char) (j + 'a');

			for (i = 0; i < n; i++) {

				if (str[i] == ch1)
					str[i] = ch2;

				else if (str[i] == ch2)
					str[i] = ch1;
			}
		}

		return String.valueOf(str);
	}
	
	static String chooseandswap(String str) {
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		int l = str.length();
		if (l < 2)
			return str;
		for (int i = 0; i < l; i++) {
			if (arr[str.charAt(i) - 'a'] == -1) {
				arr[str.charAt(i) - 'a'] = i;
			}
		}

		int i = 0, j = 0;
		for (i = 0; i < l; i++) {
			boolean flag = false;
			for (j = 0; j < str.charAt(i) - 'a'; j++) {
				if (arr[j] > arr[str.charAt(i) - 'a']) {
					flag = true;
					break;
				}

			}
			if (flag)
				break;
		}

		 System.out.println(i);
		System.out.println(j);

		char ch[] = str.toCharArray();

		if (i < l - 1) {
			char c1 = ch[i];
			char c2 = (char) ('a' + j);

			for (int k = 0; k < l; k++) {
				if (ch[k] == c1)
					ch[k] = c2;
				else if (ch[k] == c2)
					ch[k] = c1;
			}

		}
		return String.valueOf(ch);

	} 

	public static void main(String[] args) {
		String str = "abcdefghijklabcdefghijklpop";
		int n = str.length();
		System.out.println(chooseandswap(str));

		//System.out.println(smallestStr(str.toCharArray(), n));
	}
}
