package String;

public class NaiveStringMatching {

	public static void main(String args[]) {

		String pat = "BAACAADABAAABAA";
		String txt = "AABA";
		search(pat, txt);
	}

	private static void search(String pat, String txt) {

		int l1 = pat.length();
		int l2 = txt.length();
		int i = 0, j = 0, k = 0, c = 0;

		while (i < l1 - l2) {

			while (j < l2) {
				if (pat.charAt(i) == txt.charAt(j)) {
					i++;
					j++;
					c++;
				} else {
					k++;
					i = k;
					j = 0;
					c=0;
				}
			}
			if (c == l2) {
				System.out.println(true);
			System.out.println((i-j)+" "+i);
				
				break;

			}
		}

	}
	
	public static void search1(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		for (int i = 0; i <= N - M; i++) {
			int j;

			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == M) {
				System.out.println("Pattern found at index " + i);
			}
		}
	}

}
