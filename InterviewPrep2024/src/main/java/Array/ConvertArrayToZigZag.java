package Array;

import java.util.Arrays;

public class ConvertArrayToZigZag {
	static int arr[] = new int[] { 4, 7, 3, 8, 6, 2, 1 };
	//{ 3, 7, 4, 8, 6, 2, 1 };

	static void zigZag() {
		Arrays.sort(arr);
		for (int i = 1; i <= arr.length - 2; i += 2) {

			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
	}
	
	  static void zigZag1()
	    {
		  boolean flag =true;
		  // { 4, 7, 3, 8, 6, 2, 1 };
		  for(int i=0;i<arr.length-2;i++) {

			  if(flag)
			  {
				  if(arr[i]>arr[i+1]) {
					  int temp=arr[i+1];
					  arr[i+1]=arr[i];
					  arr[i]=temp;
				  }
			  }
			  else {
				  if(arr[i]<arr[i+1]) {
					  int temp=arr[i+1];
					  arr[i+1]=arr[i];
					  arr[i]=temp;  
				  }
			  }
			  flag=!flag;

	        }
	    }

	public static void main(String[] args) {
		zigZag1();
		System.out.println(Arrays.toString(arr));
	}
}
