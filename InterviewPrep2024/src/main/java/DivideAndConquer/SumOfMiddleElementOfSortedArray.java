package DivideAndConquer;

public class SumOfMiddleElementOfSortedArray {
	public static double findMidSum(int[] ar1, int[] ar2, int n, int n1) {
		/*
		 * if (n == 1) return ar1[0] + ar2[0]; if (n == 2) return Math.max(ar1[0],
		 * ar2[0]) + Math.min(ar1[1], ar2[1]);
		 */
		int i = 0;
		int j = 0;
		int count;
		int m1 = -1, m2 = -1;

		 if (n == 0) {
	            int mid = n1 / 2;
	            if (n1 % 2 == 0) {
	            	System.out.println((ar2[mid - 1] + ar2[mid]) / 2);
	                return (double)(ar2[mid - 1] + ar2[mid]) / 2;
	            } else {
	                return ar2[mid];
	            }
	        }

	        if (n1 == 0) {
	            int mid = n / 2;
	            if (n % 2 == 0) {
	                return (ar1[mid - 1] + ar1[mid]) / 2;
	            } else {
	                return ar1[mid];
	            }
	        }
		for (count = 0; count <= (n + n1) / 2; count++) {

			if (i == n) {
				m1 = m2;
				m2 = ar2[j];
				break;
			} else if (j == n1) {
				m1 = m2;
				m2 = ar1[i];
				break;
			}

			if (ar1[i] <= ar2[j]) {
				m1 = m2;
				m2 = ar1[i];
				i++;
			} else {
				m1 = m2;
				m2 = ar2[j];
				j++;
			}
		}

		if ((m1 + m2) % 2 == 1)
			return (m2);
		else
			return (m1 + m2) / 2;
	}

	public static int findMidSumBS(int[] ar1, int[] ar2, int n) {
		if (n == 1) {
			return ar1[0] + ar2[0];
		}
		if (n == 2) {
			return Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1]);
		}

		int low = 0, high = n - 1;
		int ans = -1;
		while (low <= high) {
			int cut1 = low + (high - low) / 2; // Find the midpoint in the first array
			int cut2 = n - cut1; // Calculate the corresponding midpoint in the second array

			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : ar1[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : ar2[cut2 - 1];
			int r1 = (cut1 == n) ? Integer.MAX_VALUE : ar1[cut1];
			int r2 = (cut2 == n) ? Integer.MAX_VALUE : ar2[cut2];

			if (l1 > r2) {
				// If the left element of the first array is greater than the right element of
				// the second array,
				// move the partition point to the left in the first array
				high = cut1 - 1;
			} else if (l2 > r1) {
				// If the left element of the second array is greater than the right element of
				// the first array,
				// move the partition point to the right in the first array
				low = cut1 + 1;
			} else {
				// If neither of the above conditions is met, it means we've found the correct
				// partition points.
				// Calculate the maximum of the left elements and the minimum of the right
				// elements and return the sum.
				ans = Math.max(l1, l2) + Math.min(r1, r2);
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		 //int[] ar1 = {0,0,0,0,0 };
		// int[] ar2 = {-1,0,0,0,0,0,1};

		//int[] ar1 = { 2 };
		//int[] ar2 = { };
			int[] ar1 = {1};
			int[] ar2 = { 2,3,4};
		int n = ar1.length;
		System.out.println(findMidSum(ar1, ar2, n, ar2.length));
	}

}
