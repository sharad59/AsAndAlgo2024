package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ParenthesesChecker {

	public static void main(String args[]) {
		String s = "[{}]";
		boolean a = checkParenthesis2(s);
		System.out.println(a);
	}

	private static boolean checkParenthesis(String s) {

		Stack<Character> st = new Stack<>();
		List<Character> list = Arrays.asList('{', '(', '[');
		List<Character> list2 = Arrays.asList(']', '}', ')');

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (list.contains(ch))
				st.push(ch);

			else if (list2.contains(ch)) {

				if (st.isEmpty()) {
					return false;
				}
				char c = st.pop();
				switch (ch) {
				case ']':
					if (c != '[')
						return false;
					break;

				case '}':
					if (c != '{')
						return false;
					break;

				case ')':
					if (c != '(')
						return false;
					break;

				default:
					return false;
				}
			}

		}
		if (!st.isEmpty()) {
			return false;
		} else
			return true;
	}
	
	 public static boolean checkParenthesis2(String s)
	    {
	        int i = -1;
	        char[] stack = new char[s.length()];
	        for (char ch : s.toCharArray()) {
	            if (ch == '(' || ch == '{' || ch == '[')
	                stack[++i] = ch;
	            else {
	                if (i >= 0
	                    && ((stack[i] == '(' && ch == ')')
	                        || (stack[i] == '{' && ch == '}')
	                        || (stack[i] == '[' && ch == ']')))
	                    i--;
	                else
	                    return false;
	            }
	        }
	        return i == -1;
	    }
}
