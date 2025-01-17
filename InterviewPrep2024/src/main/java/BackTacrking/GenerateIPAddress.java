package BackTacrking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GenerateIPAddress {

	public static ArrayList<String> restoreIpAddresses(String A) {
		if (A.length() < 3 || A.length() > 12)
			return new ArrayList<>();
		return convert(A);
	}

	private static ArrayList<String> convert(String s) {
		ArrayList<String> l = new ArrayList<>();
		int size = s.length();

		String snew = s;

		for (int i = 1; i < size - 2; i++) {
			for (int j = i + 1; j < size - 1; j++) {
				for (int k = j + 1; k < size; k++) {
					snew = snew.substring(0, k) + "." + snew.substring(k);
					snew = snew.substring(0, j) + "." + snew.substring(j);
					snew = snew.substring(0, i) + "." + snew.substring(i);

					if (isValid(snew)) {
						l.add(snew);
					}
					snew = s;
				}
			}
		}

		Collections.sort(l, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String a1[] = o1.split("[.]");
				String a2[] = o2.split("[.]");

				int result = -1;
				for (int i = 0; i < 4 && result != 0; i++) {
					result = a1[i].compareTo(a2[i]);
				}
				return result;
			}
		});
		return l;
	}

	private static boolean isValid(String ip) {
		String a[] = ip.split("[.]");
		for (String s : a) {
			int i = Integer.parseInt(s);
			if (s.length() > 3 || i < 0 || i > 255) {
				return false;
			}
			if (s.length() > 1 && i == 0)
				return false;
			if (s.length() > 1 && i != 0 && s.charAt(0) == '0')
				return false;
		}

		return true;
	}

	
	static void solve(String s, int i, int j, int level, String temp, ArrayList<String> res) {
		if (i == (j + 1) && level == 5) {
			res.add(temp.substring(1));
		}

		for (int k = i; k < i + 3 && k <= j; k++) {
			String ad = s.substring(i, k + 1);

			if ((s.charAt(i) == '0' && ad.length() > 1) || Integer.valueOf(ad) > 255)
				return;

			solve(s, k + 1, j, level + 1, temp + '.' + ad, res);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135").toString());
		
		   String s = "25525511135";
		    int n = s.length();
		 
		    ArrayList<String> ans = new ArrayList<>();
		    solve(s, 0, n - 1, 1, "", ans);

	}
}
