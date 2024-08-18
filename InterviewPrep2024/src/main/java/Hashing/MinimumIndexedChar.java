package Hashing;

import java.util.HashMap;

public class MinimumIndexedChar {

	 public static int minIndexChar(String str, String patt)
	    {
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	for(int i=0;i<str.length();i++){
	    if(!map.containsKey(str.charAt(i)))
	         map.put(str.charAt(i),i);
	}
	int in=Integer.MAX_VALUE;

	for(int i=0;i<patt.length();i++){
	    char ch= patt.charAt(i);
	    if(map.containsKey(ch) && map.get(ch)<in){
	       in=map.get(ch); 
	    }
	    
	}
	if(in ==Integer.MAX_VALUE)
	return -1;
	else 
	return in ;
	    }
	 
	 public static void main(String args[]) {
			
		String  str = "geeksforgeeks";
			String	 patt = "set";
			int i= minIndexChar(str, patt);
			System.out.println(i);
	 }
	}

