package DivideAndConquer;

public class FindKthElementIn2SortedArrays {
	 public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
	        int c=1;
	        int i=0,j=0;
	        
	        while(i<n&& j<m){
	            
	            if(arr1[i]<arr2[j]){
	                if(c==k)
	                return arr1[i];
	                i++;
	                c++;

	            }else{
	                 if(c==k)
	                return arr2[j];
	                j++;
	                c++;
	            }
	        }
	        
	        while(i<n){
	              if(c==k)
	                return arr1[i];
	                i++;
	                c++;
	            
	        }
	           while(j<n){
	              if(c==k)
	                return arr2[j];
	                j++;
	                c++;
	            
	        }
	        return -1;
	    }
	 
	 public static void main(String[] args)
	    {
	        int[] A = { 2, 3, 6, 7, 9 };
	        int[] B = { 1, 4, 8, 10 };
	        int k = 5;

	        System.out.println(kthElement(A, B, 5, 4, k));
	    }
}
