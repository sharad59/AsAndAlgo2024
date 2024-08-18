package Array;

import java.util.Arrays;
import java.util.HashMap;

public class SortArrayAccordingToOtherArray {

	public static void main(String args[]) {
		int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int A2[] = { 2, 1, 8, 3 };
		System.out.println(Arrays.toString(A1));
		System.out.println(Arrays.toString(A2));

		int m = A1.length;
		int n = A2.length;
		System.out.println("Sorted array is ");
		sortA1ByA2(A1, A2, m, n);
		System.out.println(Arrays.toString(A1));
	}

	private static void sortAccording(int[] a1, int[] a2, int m, int n){
		

		int max= 0;
        for(int i=0;i<m;i++){
            max= max>a1[i]?max:a1[i];
        }
		int temp[] = new int[max+1];
		for (int i = 0; i < m; i++) {
			temp[a1[i]]++;
		}

		int i = 0, j = 0;
		while (j < n) {
			int val = a2[j];
			j++;
			int count = temp[val];
			while (count > 0) {
				a1[i] = val;
				i++;
				count--;
			}
			temp[val] = 0;
		}

		for (int k = 0; k < temp.length; k++) {
			if (temp[k] != 0) {
				int count = temp[k];
				while (count > 0) {
					a1[i] = k;
					count--;
					i++;

				}
			}
		}
	}
	
	public static int[] sortA1ByA2(int A1[],int A2[], int N,  int M) {
		int max = Arrays.stream(A1).max().getAsInt();
		int freq[] = new int[max+1];
		for (int i = 0; i <N; i++) {
			freq[A1[i]]++;
		}
		int j = 0;
		for (int i = 0; i < M; i++) {
			while (freq[A2[i]] > 0) {
				A1[j] = A2[i];
				freq[A2[i]]--;
				j++;
			}
		}

		for (int i = 0; i <max+1; i++) {
			while (freq[i] > 0) {
				A1[j] = i;
				freq[i]--;
				j++;
			}

		}

		return A1;
	}

	
	static void sortA1ByA2(int A1[], int N, int A2[], int M, int ans[]) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		int ind = 0;

		for (int i = 0; i < N; i++) {
			if (!mp.containsKey(A1[i]))
				mp.put(A1[i], 1);
			else
				mp.put(A1[i], mp.get(A1[i]) + 1);
		}

		for (int i = 0; i < M; i++) {

			if (mp.containsKey(A2[i])) {

				for (int j = 1; j <= mp.get(A2[i]); j++)
					ans[ind++] = A2[i];
			}

			mp.remove(A2[i]);
		}

		int idx = ind;

		for (HashMap.Entry<Integer, Integer> it : mp.entrySet()) {

			for (int j = 1; j <= it.getValue(); j++)
				ans[ind++] = it.getKey();
		}
		Arrays.sort(ans, idx, N);
	}
}
