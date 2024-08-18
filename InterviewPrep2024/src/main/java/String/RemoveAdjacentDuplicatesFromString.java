package String;
import java.util.*;

public class RemoveAdjacentDuplicatesFromString {

	public static String rremove(String S) {
		char[] newString = S.toCharArray(); 
		Stack<Character> stack = new Stack<>(); 
		int i = 0; 

		while (i < S.length()) {
			if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
				while (i < S.length() && S.charAt(i) == stack.peek()) {
					i++;
				}
				stack.pop();
			}

			if (i < S.length()) {
				stack.push(S.charAt(i));
				i++;
			}
		}

		char[] stackArray = new char[stack.size()];
		for (int j = 0; j < stackArray.length; j++) {
			stackArray[j] = stack.get(j);
		}

		if (Arrays.equals(newString, stackArray)) {
			return S;
		} else {
			return rremove(new String(stackArray));
		}
	}

	public static void main(String[] args) {
		String inputString = "abccbccba";
		String outputString = sremove(inputString);
		System.out.println("Output: " + outputString);
	}
	
	static  String sremove(String s) {
		  char crr[]= s.toCharArray();
		  Stack<Character> st= new Stack<>();
		  int i=0;
		  
		  while(i<s.length()){
		    if(!st.isEmpty()  && s.charAt(i)==st.peek() ){
		    while(i<s.length() && s.charAt(i)==st.peek()){
		        i++;
		    }
		    st.pop();
		        
		    }
		    
		    if(i<s.length()){
		    	st.push(s.charAt(i));
		        i++;
		    }
		}
		    char stArr[]=new char[st.size()];
		    for(int j=0;j<st.size();j++){
		        stArr[j]=st.get(j);
		    }
		    if(Arrays.equals(crr,stArr)){
		        return s;
		    }
		    else{
		        return sremove(new String(stArr));
		    }



		}
}
