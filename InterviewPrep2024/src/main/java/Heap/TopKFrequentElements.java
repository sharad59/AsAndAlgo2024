package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
 
 static class pair{
	 
	 int first;
	 int sec;
	 pair(int first,int sec){
		 this.first=first;
		 this.sec=sec;
	 }	
 }
 
static  int[] getTopKFrequentElements(int arr[],int k) {
	int outputArr []=new int [k];
	PriorityQueue<pair> pq =new PriorityQueue<pair>((a,b)->{return b.sec-a.sec;});
	Map<Integer,Integer> map = new HashMap<>();
	for(int i:arr) {
		map.put(i, map.getOrDefault(i, 0)+1);
	}
	
	for(Map.Entry<Integer,Integer> entry: map.entrySet() ) {
		pq.add(new pair(entry.getKey(),entry.getValue()));
	}
	
	for(int i=0;i<k;i++) {
		outputArr[i]=pq.poll().first;
	}
	return outputArr;
}
 public static void main (String args[]) {
	 
	 int k=2;
	 int arr[]= {1,1,1,2,2,3};
	 
	 System.out.println( Arrays.toString (getTopKFrequentElements(arr, k)));
	 
 }
	
	
}
