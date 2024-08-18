package DyamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {

	static class Pair {
		int x;
		int y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	static int maxChainLength(Pair arr[], int n) {
		int lis[] = new int[n];
		Arrays.fill(lis, 1);
		int max = 0;
		/*
		 * Arrays.sort(arr, new Comparator<Pair>() {
		 * 
		 * @Override public int compare(Pair p1, Pair p2) {
		 * 
		 * return p1.x - p2.x; } });
		 */
		Arrays.sort(arr, (a,b)->{return a.x-b.x;});
		;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i].x > arr[j].y && lis[j] + 1 > lis[i])
					lis[i] = lis[j] + 1;
			}
		}
		System.out.println(Arrays.toString(lis));

		for (int i = 0; i < n; i++) {
			max = Math.max(lis[i], max);
		}
		return max;
	}

	static int maxChainLengthA(Pair arr[], int n){
	        int prev=0;
	        int count=1;
	        Arrays.sort(arr, new Comparator<Pair>(){
	           @Override
	           public int compare(Pair p1,Pair p2){
	               
	               return p1.y-p2.y;
	           }
	       });
	        for(int j=1;j<n;j++){
	            if(arr[j].x>arr[prev].y){
	                count++;
	                prev=j;
	            }
	        }
	        return count;
	    }

		public static void main(String args[]) {
			/*
			 * Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27,
			 * 40), new Pair(50, 60) };
			 */
			
			Pair arr[] = new Pair[] {
					new Pair(1, 9),
					new Pair(8, 9), 
					new Pair(1, 4),
					new Pair(1, 8),
					new Pair(5, 9),
					new Pair(1, 7),
					new Pair(2, 3),
					new Pair(2, 9),
					new Pair(2, 2),
					new Pair(3, 7)};
			System.out.println("Length of maximum size chain is " + maxChainLength(arr, arr.length));
		}
}
