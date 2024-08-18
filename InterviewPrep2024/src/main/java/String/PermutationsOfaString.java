package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsOfaString {
	static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		String str = "ABB";
		list = find_permutation(str);
		System.out.println(list);
	}

	public static List<String> find_permutation(String S) {
		List<String> list = new ArrayList<String>();
		list = permute(S, 0, S.length() - 1, list);
		//Collections.sort(list);

		return list; 

	}

	private static List<String> permute(String str, int l, int r, List<String> list) {
			if (l == r) {
			if (!list.contains(str))
				list.add(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				list = permute(str, l + 1, r, list);
				str = swap(str, l, i);

			}
		}
		return list;
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
	
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }
            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}
