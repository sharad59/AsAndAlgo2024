package Stack;

import java.util.Stack;

public class lowestNumberByremovingKDigitsFromNumber {

	public static String removeKdigits(String num, int k) {
		StringBuilder result = new StringBuilder();

		if (k >= num.length()) {
			return "0";
		}
		if (k == 0) {
			return num;
		}
		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < num.length(); i++) {
			char c = num.charAt(i);

			while (!s.isEmpty() && k > 0 && s.peek() > c) {
				s.pop();
				k--;
			}
			if (!s.isEmpty() || c != '0')
				s.push(c);
		}

		while (!s.isEmpty() && k > 0) {
			k--;
			s.pop();
		}
		
		System.out.println(s.toString());

		if (s.isEmpty())
			return "0";
		while (!s.isEmpty()) {
			result.append(s.pop());
		}
		String str = result.reverse().toString();

		return str;
	}

	public static void main(String[] args) {
		String s = "1432219";
		
		int k = 3;
		System.out.println(removeKdigits(s, k));
	}
}
