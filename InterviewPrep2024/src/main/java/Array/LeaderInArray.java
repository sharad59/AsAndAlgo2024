package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {

	public static void main(String[] args) {
		int arr[] = {16, 17, 4, 3, 5, 2};
		int l = arr.length;
		List li=findLeaders(arr, l);
		System.out.println(li.toString());

	}

	private static List<Integer> findLeaders(int[] arr, int l) {
		List<Integer> list = new ArrayList<>();

		list.add(arr[l-1]);
		int max=arr[l-1];
		for (int i = l - 2; i > 0; i--) {

			if(arr[i]>max) {
				max=arr[i];
				list.add(arr[i]);
			}
		}
	 	Collections.reverse(list);
	 	return list;
		
	}
}
