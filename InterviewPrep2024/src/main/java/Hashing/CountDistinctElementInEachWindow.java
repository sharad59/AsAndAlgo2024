package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctElementInEachWindow {

	 static ArrayList<Integer> countDistinct(int arr[], int n, int k)
	    {
	 Map <Integer, Integer> map = new HashMap<Integer,Integer>();
	 ArrayList<Integer> list= new ArrayList<Integer>();
	 
	 for(int i=0;i<k;i++){
	     map.put(arr[i],map.getOrDefault(arr[i],0)+1);
	 }
	 
	 list.add(map.size());
	 
	 for(int i=k;i<n;i++){
	     
	     if(map.get(arr[i-k])==1)
	       map.remove(arr[i-k]);
	       else{
	           map.put(arr[i-k], map.get(arr[i-k])-1);
	       }
	       
         map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

 	       list.add(map.size());
	 }
	 
	 return list;
	 
	}
	 
	 public static void main(String arg[])
	    {
	        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
	        int K = 4;
	 
	        // Function call
	      List<Integer> l=  countDistinct(arr,arr.length, K);
	      System.out.println(Arrays.toString( l.toArray()));
	    }
}
