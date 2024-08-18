package Array;

import java.util.Arrays;

public class RemoveDuplicateElementLeetcode {

	public static int removeElement(int[] arr, int key) {
        int index = 0; 
        for (int i=0; i<arr.length; i++) 
            if (arr[i] != key) 
                arr[index++] = arr[i]; 
 
        // Create a copy of arr[] 
        return index;
    }
	
	public static void main(String args[]) {
		int arr []= {3,2,2,3};
		int a= removeElement(arr, 3);
		System.out.println(a);
		System.out.println(Arrays.toString(arr));
		
	}
}
