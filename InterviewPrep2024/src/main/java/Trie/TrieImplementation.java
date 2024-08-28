package Trie;

import java.util.Arrays;
import java.util.List;

public class TrieImplementation {

	static void insertKey(TrieNode node, String key) {

		TrieNode curr = node;
		for (char ch : key.toCharArray()) {

			if (curr.child[ch - 'a'] == null) {
				curr.child[ch - 'a'] = new TrieNode();
			}
			curr = curr.child[ch - 'a'];
		}
		curr.wordEnd = true;
	}

	static boolean searchKey(TrieNode node, String key) {

		TrieNode curr = node;

		for (char ch : key.toCharArray()) {

			if (curr.child[ch - 'a'] == null) {
				return false;
			}
			curr = curr.child[ch - 'a'];
		}
		return curr.wordEnd;

	}

	public static void main(String[] args) {

		TrieNode root = new TrieNode();
		List<String> arr = Arrays.asList("and", "ant", "do", "geek", "dad", "ball");
		for (String s : arr) {
			insertKey(root, s);
		}

		// One by one search strings
		List<String> searchKeys = Arrays.asList("do", "gee", "bat");
		for (String s : searchKeys) {
			System.out.print("Key : " + s);
			if (searchKey(root, s)) {
				System.out.print(" Present");
				System.out.println("");
			} else {
				System.out.print(" Not Present");
				System.out.println("");
			}

		}
	}
}
