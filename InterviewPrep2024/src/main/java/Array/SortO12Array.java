package Array;

public class SortO12Array {

	public static void main(String args[]) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		sorto12(arr);
	}

	private static void sorto12(int[] arr) {

		int lo = 0, mid = 0, high = arr.length-1 ;

		while (mid <= high) {

			switch (arr[mid]) {

			case 0: {
				int temp=arr[lo];
				arr[lo]= arr[mid];
				arr[mid]=temp;
				lo++;
				mid++;
				break;
			}

			case 1: {
				mid++;
				break;
			}

			case 2: {
				int temp=arr[high];
				arr[high]= arr[mid];
				arr[mid]=temp;
				high--;
				break;
			}
			}

		}

		        int i;
		        for (i = 0; i < arr.length; i++)
		            System.out.print(arr[i] + " ");
		    
	}

}
