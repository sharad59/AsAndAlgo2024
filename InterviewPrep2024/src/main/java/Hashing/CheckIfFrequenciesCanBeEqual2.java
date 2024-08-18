package Hashing;

public class CheckIfFrequenciesCanBeEqual2 {

	static final int M = 26;


	static int getIdx(char ch) {
		return (ch - 'a');
	}

	static boolean allSame(int freq[], int N) {
		int same = 0;
		int i;
		for (i = 0; i < N; i++) {
			if (freq[i] > 0) {
				same = freq[i];
				break;
			}
		}
		for (int j = i + 1; j < N; j++)
			if (freq[j] > 0 && freq[j] != same)
				return false;

		return true;
	}

	// Returns true if we can make all character
	// frequencies same
	static boolean possibleSameCharFreqByOneRemoval(String str) {
		int l = str.length();

		// fill frequency array
		int[] freq = new int[M];

		for (int i = 0; i < l; i++)
			freq[getIdx(str.charAt(i))]++;

		// if all frequencies are same, then return true
		if (allSame(freq, M))
			return true;

		/*
		 * Try decreasing frequency of all character by one and then check all equality
		 * of all non-zero frequencies
		 */
		for (char c = 'a'; c <= 'z'; c++) {
			int i = getIdx(c);

			// Check character only if it occurs in str
			if (freq[i] > 0) {
				freq[i]--;

				if (allSame(freq, M))
					return true;
				freq[i]++;
			}
		}

		return false;
	}

	// Driver code to test above methods
	public static void main(String args[]) {
		String str = "xyyzz";
		if (possibleSameCharFreqByOneRemoval(str))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
