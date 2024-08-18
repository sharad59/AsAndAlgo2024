package DivideAndConquer;

public class AppearOnlyOnceInSortyedArray {

	int findOnce(int arr[], int n) {
		int low = 0, high = n - 1;
		return binarySearch(arr, low, high);

	}

	int binarySearch(int arr[], int low, int high) {

		if (low > high)
			return -1;
		if (low == high) {
			return arr[low];
		}

		int mid = (low + high) / 2;

		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1])
			return 	binarySearch(arr, mid + 2, high);
			else {
			return	binarySearch(arr, low, mid);
			}
		} else  if( mid%2==1){
			if (arr[mid] == arr[mid - 1])
				return binarySearch(arr, mid + 1, high);
			else {
				return binarySearch(arr, low, mid);
			}
		}
		return -1;
	}

	public static void main(String args[]) {

		int arr[] = { 1, 1, 2, 4, 4, 5, 5, 6, 6 };
		System.out.println(new AppearOnlyOnceInSortyedArray().findOnce(arr, arr.length));

	}
}
