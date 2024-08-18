package Array;

public class ElementWithLeftSideSmallerAndRightSideGreater {

	public static void main(String args[]) {
		int arr[]= {5, 1, 4, 3, 2, 8, 10, 10, 9}; 
		findElement(arr);
}

	private static void findElement(int[] arr) {
		
		int n=arr.length;
		int lmax[]=new int[n];
		lmax[0]=arr[0];
		int rmin[]=new int[n];
		 rmin[n-1]=arr[n-1];
		for(int i=1;i<n;i++) {
			lmax[i]=Math.max(arr[i-1], lmax[i-1]);
		}
		for(int j=n-2;j>0;j--) {
			rmin[j]=Math.min(arr[j+1], rmin[j+1]);
		}
		
		for(int i=0;i<n;i++) {
			if(arr[i]>lmax[i] && arr[i]<rmin[i]) {
				System.out.println(arr[i]);
				break;
			}
		}
		
	}
}
