package Array;

public class Equilibriumpoint {

static void equilibriumPoint(int arr[],int l) {
	int rsum=0;
	for(int i=0;i<l;i++) {
	rsum+=arr[i];	
	}
	System.out.println("rsum="+rsum);
	int leftSum=0;
	for(int j=0;j<l;j++) {
		rsum-=arr[j];
		
		if(leftSum==rsum) {
			System.out.println(j);
			return;
		}
		leftSum+=arr[j];
	}
} 


public static void main(String[] args)
{
    int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
    int l = arr.length;
    equilibriumPoint(arr, l);

   
}
}