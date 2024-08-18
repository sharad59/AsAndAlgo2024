package Array;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

	static void findSubArray(int arr[], int sum) {
int currSum=0;
int start=0;
		for (int i=0;i<arr.length;i++) {

		currSum+=arr[i];
		while(currSum>sum) {
			currSum=currSum-arr[start];
			start++;
		}
		if(currSum==sum)
		{	System.out.println(start+", "+ i);
		break;
		}
	}
	}	
	
	static void findSubArray2(int arr[],int sum ){
		int currSum=0;
		Map<Integer, Integer> m= new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			currSum +=arr[i];
			if(currSum==sum) {
				System.out.println(0+" ,"+i);

			}
			if(m.containsKey(currSum-sum)) {
				System.out.println(m.get(currSum-sum)+1+" ,"+i);
				return ;
			}
			m.put(currSum, i);
		}

		
		
	}
	public static void main(String args[]) {
		int sum = 23;
     int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };

     // 15,17,21,29,38,43,53,76
    //  -8,-6,-2,6,15,19,29,53
		findSubArray(arr, sum);
		findSubArray2(arr, sum);


	}
}
