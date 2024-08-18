package Array;

public class CountTripletsInArray {

	
	static void  countTriplets(int arr[],int n ) {
	int count =0;
	int freq[]=new int[100];
	
	for (int i=0;i<n;i++) {
		freq[arr[i]]++;
	}
	
	for(int j=0;j<n;j++) {
		for(int k=j+1;k<n;k++) 
		{
			if(freq[arr[j]+arr[k]]>0)
				count++;
		}
	}
	System.out.println(count);
	}
	
	
	public static void main(String args[]) {
     int arr[] =  {3, 2, 7,5,9} ;
     countTriplets(arr, arr.length);


		

	}
}
