package Array;

public class RainWaterTrapping {

	public static void main(String args[]) {

		int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		//findTrappedWater(arr, arr.length);
		maxWater(arr,arr.length);

	}

	private static void findTrappedWater(int[] arr, int l) {

		int left[]=new int[l];
		int right[]=new int [l];
		left[0]=arr[0];
	    right[l-1]=arr[l-1];
	    int res=0;
	    for(int i=1;i<l;i++) {
	    	left[i]= Math.max(left[i-1], arr[i]);
	    }
	    for(int j=l-2;j>0;j--) {
	    	right[j]=Math.max(right[j+1], arr[j]);
	    }
	    for(int i=0;i<l;i++) {
	    	res+= (Math.min(left[i], right[i]))-arr[i];
	    }
	    
	    System.out.println(res);
	}
	//int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

	static int maxWater(int[] arr, int n) {

		int left = 0;
		int right = n - 1;

		int l_max = 0;
		int r_max = 0;

		int result = 0;
 		while (left <= right) {

			if (r_max <= l_max) {

				result += Math.max(0, r_max - arr[right]);
				r_max = Math.max(r_max, arr[right]);
				right -= 1;
			} else {

				result += Math.max(0, l_max - arr[left]);
				l_max = Math.max(l_max, arr[left]);
				left += 1;
			}
		}
	    System.out.println(result);

		return result;

	}
}
