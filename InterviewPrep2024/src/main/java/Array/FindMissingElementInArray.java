package Array;

public class FindMissingElementInArray {

	public static void main(String args[]) {
		
		 int[] arr = { 1, 2, 3, 5,4,7 };
	        int N = arr.length;
	        findMissingElement(arr, N);
	}
	
	static void findMissingElement(int arr[],int n) {
		int total=1;
		
		for(int i=2;i<=n+1;i++) {
			total =total+i;
			total=total-arr[i-2];
		}
		System.out.println(total);
	}
}
