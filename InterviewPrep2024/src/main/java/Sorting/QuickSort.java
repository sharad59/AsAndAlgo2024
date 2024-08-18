package Sorting;
import java.io.*;

public class QuickSort {
//pivot = it is in correct position in sorted array
//items to its left are smaller
// items to its right are greater
// in below implementation : last element is picked as pivot


	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];

	
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (arr[j] < pivot) {

				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			int pi = partition(arr, low, high);


			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	public static void printArr(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args)
	{
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		//int []arr={ 23, 8, 28, 13, 18, 26 };  
		int N = arr.length;

		// Function call
 		quickSort(arr, 0, N - 1);
		System.out.println("Sorted array:");
		printArr(arr);
	}
}

