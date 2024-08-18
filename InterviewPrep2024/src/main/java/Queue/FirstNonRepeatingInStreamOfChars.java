package Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingInStreamOfChars {
	
	//Using Hashmap 
	static String FirstNonRepeating(String A) {
		ArrayList<Character> list = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : A.toCharArray()) {
			if (!map.containsKey(ch)) {
				list.add(ch);
				map.put(ch, 1);
			} else {
				int index = list.indexOf(ch);
				if (index != -1)
					list.remove(index);
			}
			sb.append(list.isEmpty() ? '#' : list.get(0));
		}
		return sb.toString();
	}
	
	 final static int MAX_CHAR = 256;
	 // Using DLL
		static void findFirstNonRepeating() {

			List<Character> inDLL = new ArrayList<Character>();
			boolean[] repeated = new boolean[MAX_CHAR];

			String stream = "geeksforgeeksandgeeksquizfor";
			for (int i = 0; i < stream.length(); i++) {
				char x = stream.charAt(i);
				System.out.println("Reading " + x + " from stream \n");
				if (!repeated[x]) {

					if (!(inDLL.contains(x))) {
						inDLL.add(x);
					} else {
						inDLL.remove((Character) x);
						repeated[x] = true;
					}
				}

				if (inDLL.size() != 0) {
					System.out.print("First non-repeating character so far is ");
					System.out.println(inDLL.get(0));
				}
			}
		}
		
		static String FirstNonRepeating1(String A) {
			String ans = "";

			Map<Character, Integer> mp = new HashMap<>();
			Queue<Character> q = new LinkedList<>();

			for (int i = 0; i < A.length(); i++) {

				if (!mp.containsKey(A.charAt(i))) {
					q.add(A.charAt(i));
				}
				mp.put(A.charAt(i), mp.getOrDefault(A.charAt(i), 0) + 1);

				while (!q.isEmpty() && (mp.get(q.peek()) > 1)) {
					q.remove();
				}
				if (!q.isEmpty()) {
					ans += q.peek();
				} else {
					ans += '#';
				}
			}
			return ans;
		}
		
	public static void main(String[] args) {
		findFirstNonRepeating();
		String A = "geeksforgeeksandgeeksquizfor";
		String ans = FirstNonRepeating(A);
		System.out.print(ans);
	}
}
