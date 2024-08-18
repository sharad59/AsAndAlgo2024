package String;

import java.util.Arrays;

public class LongestCommonPrefix {
	static String longestCommonPrefix(String arr[], int n) {

		if (arr.length == 1) {
			return arr[0];
		}
		int min = Integer.MAX_VALUE;
		String minS = "";
		int ix = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() < min) {
				min = arr[i].length();
				minS = arr[i];
				ix = i;
			}
		}
		int maxPrefix = 0;
		String a = new String();
		String b = new String();
		int tmaxPrefix = Integer.MAX_VALUE;

		for (int j = 0; j < arr.length; j++) {
			if (j == ix)
				continue;
			maxPrefix = 0;
			a = new String();
			for (int i = 0; i < min; i++) {

				if (minS.charAt(i) != arr[j].charAt(i)) {
					break;
				} else {
					maxPrefix++;
					a = a + minS.charAt(i);
				}

			}
			if (maxPrefix < tmaxPrefix) {
				tmaxPrefix = maxPrefix;
				b = a;
			}
		}
		// System.out.println(tmaxPrefix);
		// System.out.println(b);

		if (tmaxPrefix == 0) {
			return "-1";
		}
		return b;
	}
	
	public static  String longestCommonPrefix(String[] a) {
		int size = a.length;

		if (size == 0)
			return "";

		if (size == 1)
			return a[0];

		Arrays.sort(a);

		int end = Math.min(a[0].length(), a[size - 1].length());
		int i = 0;
		while (i < end && a[0].charAt(i) == a[size - 1].charAt(i))
			i++;

		String pre = a[0].substring(0, i);
		return pre;
	}

	public static void main(String args[]) {
		// String arr[] = { "akanksha", "akaksha" ,"akaaka" ,"akadaka" };
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		System.out.println(longestCommonPrefix(arr));

	}
}
