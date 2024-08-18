package Stack;
import java.util.Stack;

public class LongestValidParenthesis {

	public int longestValidParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        boolean valid[] = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (!st.isEmpty()) {
                if (s.charAt(i) == ')') {
                    valid[st.pop()] = valid[i] = true;
                }
            }
        }

        return longest(valid);
    }

    int longest(boolean valid[]) {

        int max = 0;
        int l = 0;
        for (int i = 0; i < valid.length; i++) {
            max = Math.max(max, l = valid[i] ? l + 1 : 0);
        }

        return max;
    }
    
	public static void main(String args[]) {
		String s = "()()";
		int a = new LongestValidParenthesis().longestValidParentheses(s);
		System.out.println(a);
	}
}
