package Heap;

import java.util.Arrays;

public class MaxHeap {

	int arr[];
	int heapSize;
	int maxSize;

	MaxHeap(int size) {
		arr = new int[size];
		heapSize = 0;
		maxSize = size;
	}

	int lchild(int i) {
		return 2 * i + 1;
	}

	int rchild(int i) {
		return 2 * i + 2;
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	void heapify(int i) {
		int l = lchild(i);
		int r = rchild(i);
		int largest = i;
		if (l < heapSize && arr[l] > arr[i])
			largest = l;
		if (r < heapSize && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(largest);
		}
	}

	int removeMax() {
  		System.out.println("new array" + " "+Arrays.toString(arr));

		if (heapSize == 0) {
			return Integer.MIN_VALUE;
		}
		if (heapSize == 1) {
			int t = arr[0];
			heapSize--;
			return t;
		}
		int t = arr[0];
		arr[0] = arr[heapSize - 1];
		heapSize--;
		heapify(0);
		System.out.println("removed elelement"+ " "+ t);

		return t;
	}

	void increaseKey(int i, int value) {
	 arr[i]=value;
	 
	 while(i!=0 && arr[i]>arr[parent(i)]) {
		 int temp =arr[i];
		 arr[i]=arr[parent(i)];
		 arr[parent(i)]=temp;
		 i=parent(i);
	 }
	}
	 
	 
	void deleteKey(int i){
		increaseKey(i, Integer.MAX_VALUE); 
		removeMax();
	 }
	
	void insertKey(int val){
		if(heapSize==maxSize) {
			System.out.println("overflow");
			return ;
		}
		
		heapSize++;
		int i=heapSize-1;
		arr[i]=val;
		
		while(i!=0 &&arr[parent(i)]< arr[i]) {
			int temp=arr[i];
			arr[i]=arr[parent(i)];
			arr[parent(i)]=temp;
			i=parent(i);
			
		}
	} 

	public static void main(String args[]) {
		MaxHeap h= new MaxHeap(15);
		h.insertKey(5);
		h.insertKey(3);
		h.insertKey(8);
		h.insertKey(4);
		h.insertKey(9);
		h.insertKey(2);
		System.out.println(h.heapSize );
		System.out.println("first element "+ h.arr[0]);
		System.out.println(Arrays.toString(h.arr));
		h.deleteKey(3);
		System.out.println(Arrays.toString(h.arr));
		System.out.println(h.heapSize);


	}
}
