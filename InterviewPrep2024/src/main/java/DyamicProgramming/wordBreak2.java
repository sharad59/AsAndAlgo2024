package DyamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak2 {

	static class Trie{
		
        Trie children[] = new Trie[26];
        boolean isEndOfWord;
        public Trie(){

            isEndOfWord = false;
        }
    }
    public static void addWord(Trie root,String s){
        Trie node = root;
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i) - 'a';
            if(node.children[ch]==null)
                node.children[ch] = new Trie();
            node = node.children[ch];
        }
        node.isEndOfWord = true;
    }
    public static boolean search(Trie root, String s){
        Trie node = root;
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i) - 'a';
            if(node.children[ch]==null)
                return false;
            node = node.children[ch];
        }
        return node.isEndOfWord;
    }
    
  static   List<String> list;
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for(String st:wordDict){
            addWord(root,st);
        }
        list = new ArrayList<String>();
        findRemainingSubString(root,"",s,s.length());
        return list;
    }
    public static  boolean findRemainingSubString(Trie root,String str,String s,int total){
        if(s==null || s.length()==0)
            return true;
        for(int i=0;i<=s.length();i++){
            String st = str;
            if(search(root,s.substring(0,i))){
                st = st + s.substring(0,i)+ " ";
                if(!findRemainingSubString(root,st,s.substring(i),total+1))
                    return false;
                if(st.trim().length()==total)
                    list.add(st.trim());
            }
        }
        return true;
    }
    
    public static void main(String args[]) {
    	
    	String s="catsanddog";
    	String wordDict[] = {"cat","cats","and","sand","dog"};
    	List<String> l = Arrays.asList(wordDict);
    	System.out.println(wordBreak(s, l));
    	
    	
    }
}
