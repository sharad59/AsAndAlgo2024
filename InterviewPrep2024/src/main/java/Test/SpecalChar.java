package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpecalChar {

	public static  int numberOfSpecialChars(String s) {
        int c=0;
    int arr[] = new int[26];
        int l= s.length();
        Arrays.fill(arr, 0);
        for(int i=0;i<l;i++){
            char ch = s.charAt(i);
            if(ch>='A' && ch<='Z')
            arr[ch-'A']++;  
            else if(ch>='a' && ch<='z')
                arr[ch-'a']++;
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=2){
                c++;
            }          
        }
        return c;
    }
	
	public static int numberOfSpecialChars1(String s) {
		  int l= s.length();
	        int c=0;
	        Map<Character,Integer> map= new HashMap<>();
	    int arr[]= new int [26]; 
	        for(int i=0;i<l;i++){
	        	if(map.containsKey(s.charAt(i)))
	        		continue;
	        	else
	            map.put(s.charAt(i),i);
	        }
	        
	        for(int i=0;i<l;i++){
	            char ch = s.charAt(i);
	            if(ch>='a'&& ch<='z' && map.containsKey((char) (ch-32))){
	                int val=map.get((char) (ch-32));
	                if(val>i && arr[ch-'a']!=-1 )
	                  arr[ch-'a']++;
	                else 
	                	arr[ch-'a']=-1;
	                
	                
	            }
	        }
	         for(int i=0;i<l;i++){
	             if(arr[i]>=1)
	                 c++;
	         }

	        return c;

    }
	public static void main (String args[]) {
		String s ="cCceDC";
		System.out.println(numberOfSpecialChars1(s));

	}
	
}
