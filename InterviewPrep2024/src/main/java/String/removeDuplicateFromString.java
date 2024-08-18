package String;

import java.util.HashSet;

public class removeDuplicateFromString {

	 String removeDups(String S) {
	        char arr[]=S.toCharArray();
	String str= new String();
	HashSet<Character> set = new HashSet<>();

	for(int i=0;i<S.length();i++){
	   char ch = S.charAt(i);
	    if(!set.contains(ch)){
	        str=str+ch;
	        set.add(ch);
	    }
	}
	return str;

	    }
}
