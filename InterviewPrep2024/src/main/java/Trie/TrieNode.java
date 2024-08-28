package Trie;

public class TrieNode {

	TrieNode child[];
	boolean wordEnd;
	
	TrieNode(){
		
		child=new TrieNode[26];
		wordEnd=false;
	}
}
