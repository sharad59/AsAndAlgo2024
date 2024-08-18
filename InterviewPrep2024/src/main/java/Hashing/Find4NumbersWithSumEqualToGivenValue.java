package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class Find4NumbersWithSumEqualToGivenValue {

	public static void main(String[] args) {
		// int[] arr = { 10, 20, 30, 40, 1, 2 };
		// int X = 91;
		int[] arr = {10, 2, 3, 4, 5, 7, 8 };
Arrays.sort(arr);
		int X = 23;
		ArrayList<ArrayList<Integer>> l =fourSum(arr, X);
		System.out.println(Arrays.toString(l.toArray()));
	}

	public static class Pair {
		int first;
		int sec;

		Pair(int first, int sec) {
			this.first = first;
			this.sec = sec;
		}

	}

	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
		ArrayList<ArrayList<Integer>> l = new ArrayList<>();
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				map.put(arr[i] + arr[j], new Pair(i, j));
			}

		}

		System.out.println(map.toString());
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (map.containsKey(k - (arr[i] + arr[j]))) {
					Pair p = map.get(k - (arr[i] + arr[j]));
					if (i != p.first && i != p.sec && j != p.first && j != p.sec) {
						ArrayList<Integer> l1 = new ArrayList<>();
						l1.add(arr[i]);
						l1.add(arr[j]);
						l1.add(arr[p.first]);
						l1.add(arr[p.sec]);
						Collections.sort(l1);
						if(!l.contains(l1))
						{l.add(l1);}
						//return l;

					}

				}
			}
		}
		return l;
	}
	
	 public ArrayList<ArrayList<Integer>> fourSum1(int[] arr, int k) {
	        Arrays.sort(arr);
	        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	        HashSet<ArrayList<Integer>> hs = new LinkedHashSet<ArrayList<Integer>>();
	        for(int i=0; i<arr.length-2; i++){
	            for(int j=i+1; j<arr.length-1; j++){
	                int num = arr[i]+arr[j];
	                int l = j+1;
	                int r = arr.length-1;
	                
	                while(l<r){
	                    if(num+arr[l]+arr[r] == k){
	                        ArrayList<Integer> list = new ArrayList<>();
	                        list.add(arr[i]);
	                        list.add(arr[j]);
	                        list.add(arr[l]);
	                        list.add(arr[r]);
	                        hs.add(list);
	                        l++;
	                        r--;
	                    }
	                    else if(num+arr[l]+arr[r]<k) l++;
	                    else r--;
	                }
	                
	                
	            }
	        }
	        
	        for(ArrayList<Integer> li: hs){
	            ans.add(li);
	        }
	        return ans;
	    }
}
