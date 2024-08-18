package Test;

import java.util.HashMap;

public class Test {
	public static int maximumPrimeDifference(int[] arr) {

		int n = arr.length;
		int l = 0, r = n - 1;
		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;

		while (r >= 0 && l <= n - 1) {

			if (isPrime(arr[l]) && l < left) {
				left = l;
			} else {
				l++;
			}

			if (isPrime(arr[r]) && r > right) {
				right = r;
			} else {
				r--;
			}

		}

		return right - left;
	}

	static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		else if (n == 2)
			return true;

		else if (n % 2 == 0)
			return false;

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {

		int arr[] = { 21,144,24,3,48};
		int l = countCompleteDayPairs1(arr);
		System.out.println(l);

	}


	
	static public int countCompleteDayPairs1(int[] hours) {
        int count = 0;
		//int arr[] = { 21,144,24,3,48};

        int n = hours.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            var r = hours[i] % 24;
            if(map.containsKey((24 - r) % 24))
            	count += map.get((24 - r) % 24);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return count;      
    }
}
