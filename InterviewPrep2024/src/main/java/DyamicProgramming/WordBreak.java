package DyamicProgramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	/*
	 * Given a string s and a dictionary of strings wordDict, return true if s can
	 * be segmented into a space-separated sequence of one or more dictionary words.
	 */
	
	public static boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp=new boolean[s.length()+1];
       dp[0]=true;
       for(int i=1;i<=s.length();i++){
           for(int j=0;j<i;j++){
               if(wordDict.contains(s.substring(j,i)) && dp[j]) 
               dp[i]=true;
           }
       }
       return dp[s.length()];
   }
	
	// study this 
	  public static boolean wordBreakBetterAproach(String s, List<String> wordDict) {
	        boolean[] dp = new boolean[s.length() + 1];
	        dp[0] = true;

	        for (int i = 1; i <= s.length(); i++) {// complexity= n
	            for (String w : wordDict) { //// complexity= m
	                int start = i - w.length();
	                if (start >= 0 && dp[start] && s.substring(start,i).equals(w))// worst casecomplexity= n
	                {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[s.length()];        
	    }
	
	public static void main(String args[]) {
		
		String s ="applepenapple";
		 List<String> list= Arrays.asList("apple","pen");
		boolean b= wordBreakBetterAproach(s, list);
		System.out.println(b);
	} 
}
