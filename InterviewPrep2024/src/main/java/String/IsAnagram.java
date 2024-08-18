package String;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {
	public static boolean isAnagram(String a, String b) {

		HashMap<Character, Integer> map = new HashMap<>();// a String
		HashMap<Character, Integer> map2 = new HashMap<>(); // b string

		int l = a.length();
		int l2 = b.length();

		if (l != l2) {
			return false;
		}
		for (int i = 0; i < l; i++) {

			char ch = a.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < l2; i++) {

			char ch = b.charAt(i);
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < l2; i++) {
			char ch = b.charAt(i);
			if (!map.containsKey(ch)||map.get(ch)==0||map.get(ch)==null) {
				return false;
			} else {
				map.put(ch, map.get(ch) - 1);

			}
		}

		for (int i = 0; i < l; i++) {
			char ch = a.charAt(i);
			if (!map2.containsKey(ch)||map2.get(ch)==0||map2.get(ch)==null) {
				return false;
			} else {

				map2.put(ch, map2.get(ch) - 1);
			}
		}
		return true;
	}

	public static void main(String args[]) {
		String a="swalrl";
		String b="lsrasw";
		System.out.println(isAnagram(a, b));
				
	}
	
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    static int NO_OF_CHARS = 256;

    static boolean areAnagram(char str1[], char str2[])
    {


        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;
 

        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        if (str1.length != str2.length)
            return false;
 
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;
 
        return true;
    }
}
