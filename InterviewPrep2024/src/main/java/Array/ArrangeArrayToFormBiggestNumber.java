package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeArrayToFormBiggestNumber {

	 public static void main(String[] args)
	    {
	 
	        List<String> arr;
	        arr = new ArrayList<>();
	 
	        // output should be 6054854654
	        arr.add("54");
	        arr.add("546");
	        arr.add("548");
	        arr.add("60");
	        printLargest(arr);
	        System.out.println(Arrays.toString( arr.toArray()));
	    }

		private static void printLargest(List<String> arr) {
			
			Collections.sort(arr, new Comparator<String>() {

				@Override
				public int compare(String x, String y) {
					
					String xy=x+y;
					String yx=y+x;
					return xy.compareTo(yx)>0?-1:1;
				}
			});
			
			Collections.sort(arr, (x, y) -> {
				String xy = x + y;
				String yx = y + x;
				return xy.compareTo(yx) > 0 ? -1 : 1;
			});
		}
}
