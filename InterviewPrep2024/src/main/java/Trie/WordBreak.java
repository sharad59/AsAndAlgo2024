package Trie;

public class WordBreak {

	static boolean wordBreak(String str, TrieNode root) {
		int size = str.length();

		if (size == 0)
			return true;

		for (int i = 1; i <= size; i++) {
 			if (TrieImplementation.searchKey(root, str.substring(0, i))
					&& wordBreak(str.substring(i, size), root))
				return true;
		}
		return false;
	}
	 
	 public static void main(String[] args)
	    {
	        String dictionary[]
	            = { "mobile", "samsung",  "sam",  "sung", "ma",
	                "mango",  "icecream", "and",  "go",   "i",
	                "like",   "ice",      "cream" };
	 
	        int n = dictionary.length;
	        TrieNode root = new TrieNode();
	 
	        for (int i = 0; i < n; i++)
	        	TrieImplementation.insertKey(root, dictionary[i]);
	 
	        System.out.println(wordBreak("ilikesamsung", root)
	                             ? "Yes"
	                             : "No");
	        System.out.println(
	            wordBreak("iiiiiiii", root) ? "Yes" : "No");
	        System.out.println(wordBreak("", root) ? "Yes"
	                                             : "No");
	        System.out.println(
	            wordBreak("ilikelikeimangoiii", root) ? "Yes"
	                                                  : "No");
	        System.out.println(wordBreak("samsungandmango", root)
	                             ? "Yes"
	                             : "No");
	        System.out.println(wordBreak("samsungandmangok", root)
	                             ? "Yes"
	                             : "No");
	    }
	
}
