package String;

public class ReverseWordsInaString {

	static String reverseWords(String s) {

		s = s.trim();
		s=" "+s;
		int lastSpaceIx = s.length();
		String fin = new String();

		for (int i = s.length()-1; i >= 0; i--) {

			if (s.charAt(i) == ' ') {
				String subs=s.substring(i, lastSpaceIx);
				if(subs.equals(" ")) // understand its use ??//to remove extra spaces
				{	lastSpaceIx = i;
					continue;}
				fin = fin+ subs;
				lastSpaceIx = i;
			}
		}
		return fin.trim();
	}

	public static void main(String[] args) {
		String str = "example   good a";
		str = reverseWords(str);
		System.out.println(str);
	}
}
