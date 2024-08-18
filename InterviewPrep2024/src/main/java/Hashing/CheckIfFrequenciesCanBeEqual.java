package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckIfFrequenciesCanBeEqual {
	static boolean sameFreq(String s) {

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

		}

		int maxFreqCounter = 0;
		int minFreqCounter = 0;

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (max == entry.getValue())
				maxFreqCounter++;
			if (min == entry.getValue())
				minFreqCounter++;
			if (entry.getValue() > max) {
				max = entry.getValue();
				maxFreqCounter = 1;
			}

			if (entry.getValue() < min) {
				min = entry.getValue();
				minFreqCounter = 1;

			}
		}
		if (map.size() == 1)
			return true;
		else if (map.size() == 2 && min == 1)//aaab
			return true;
		else if (max == min)
			return true;
		else if (max - min == 1) {
			if (maxFreqCounter == 1)
				return true;
			else if (minFreqCounter == 1 && min == 1)//xxyyz
				return true;
			else
				return false;
		} else if (maxFreqCounter % 2 == 0 && minFreqCounter == 1 && min == 1)
			//ececccddca
			return true;
	

		else
			return false;

	}

	public static void main(String args[]) {
		String s = "babaaaabbbabbbbbbbbaabababbbbabaababbabbbbaabbababbaabbbbaaabaabbabababbaabbbaaaabbaaaabaaaaababababbaababbbaaababbbaababbaaaabbbbbbbaaaabbabbaaaabaabababaababbaaaaaabababbbbaabababbabbaaababbababbaaabaaababaaaaaaabbaabaaababbababbabaabbaabbbbbabbabababbbababbabababbbbababbabbabbaaabbbaabaaaabaaabaaaaaaaabbbaaabbbbbabbabababaabbbabaaaabbaaababbabbbaaababaaaaababaabaababaaabbbabbbbabbbabaababaaaabbaaabbabbabbbabaaaaabaabaabbbaaabababbbababbababbbabbaabbbbbbaabaaaaaaabababbbabaaaabbbabbbbabbbbbbaaabbaaabaabbbbaaaababaabbbbbbaabaababaabbbabbbabbabaabaabbbaaababbaaabaabbbbaaabbbbbbbaababbababaaabbabbaaaaabbbaabababbaaababbaabbababbbbbaabbbbbbabbbaaaabababaabbbbabbaabbbbaabbabbababaabaaabaaaaaaabbbabbbababbaaababaaaabaaaaababbabaaaaabbbbaabbababbaabaabbabbabbaaabbaabbaabbaababaabaabbaabaabbabaabbbaaabaabababbbbaaabbababbabbaabbabbbbaaaaaabaabbbaaabababbaaaabaaabbbbaaababababbaabbbbbbbaaabbbabbaabbbbbbbbbababbaabbaababaababababbabaaabaaabbaabbbabbaabaaaaaabbabaaabbababaaaaaaabaabaaaabbaaabbabbbbabaababbbabbbabbbaaabaabbbaababbaaabaababbbbababaabbabbaabbbbbaaaabbbabaababaaa";
		String a = "aaaaabbbbbc";
		boolean f = sameFreq(a);
		System.out.println(f);
	}

}
