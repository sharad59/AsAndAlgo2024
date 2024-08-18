package Hashing;

import java.util.HashMap;
import java.util.Map;

public class DividedIntoPairsWhoseSumIsDivisibleByK {

	public static boolean canPairs(int[] nums, int k) {

		if (nums.length % 2 != 0)
			return false;

		int freq[] = new int[k];
		for (int i : nums) {
            int y = ((i % k)+k)%k;

			if (freq[(k - y) % k] != 0)
				freq[(k - y) % k]--;
			else
				freq[y]++;
		}
		for (int i : freq) {
			if (i != 0)
				return false;
		}
		return true;
	}

	  public boolean canArrange1(int[] arr, int k) {

	        Map<Integer, Integer> map = new HashMap<>();
	        if (arr.length % 2 == 1) {
	            return false;
	        }
	        for (int i = 0; i < arr.length; i++) {
	            int rem = (arr[i] % k + k) % k;
	            map.put(rem, map.getOrDefault(rem, 0) + 1);
	        }
	         map.forEach((key, value) -> System.out.println(key + "," + value));
	         
	        for (int i = 0; i < arr.length; i++) {
	            int rem = (arr[i] % k + k) % k;

	            if (rem == 0) {
	                if (map.get(rem) % 2 == 1) {
	                    return false;
	                }
	            } else if (2 * rem == k) {
	                if (map.get(rem) % 2 == 1) {
	                    return false;
	                }
	            } else { 
	                if (map.get(rem) != map.get(k - rem)) {
	                    return false;
	                }
	            }

	        }
	        return true;
	    }
	  
	public static void main(String[] args) {
		int arr[] = {9, 5, 7, 3};
		int k = 6;

		if (canPairs(arr, k)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

}
