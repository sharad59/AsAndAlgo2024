package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPairsThatFormCompleteDay {

	static public int countCompleteDayPairs1(int[] hours) {
        int count = 0;

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
	
	public static void main(String args[]) {

		int arr[] = { 21,144,24,3,48};
		int l = countCompleteDayPairs1(arr);
		System.out.println(l);

	}

}
