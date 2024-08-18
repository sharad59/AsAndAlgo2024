package DivideAndConquer;

public class SearchElemetinRoatedArray {


    int search(int arr[], int l, int h, int key)
    {
        int pivot =pivot(arr,l,h);
        if(pivot==-1)
           return binarySearch(arr,l,h,key);
           
           if(arr[pivot]==key)
           return pivot;
           if(arr[l]<=key)
           return binarySearch(arr,l,pivot-1,key);
           
           return binarySearch(arr,pivot+1,h,key);
    }
    
    
    
    int pivot(int arr[], int low,int high){
        
        if(low>high)
        return -1;
        int mid= (low+high)/2;
         
         if(mid<high && arr[mid]>arr[mid+1])
         return mid;
         
         if( mid> low  && arr[mid]<arr[mid-1])
         return mid-1;
         
         if(arr[mid]<arr[low]){
             return pivot(arr,low,mid-1);
         }
         // if(arr[mid]>arr[high])
             return pivot(arr,mid+1,high);
         
         
    }
    
    int binarySearch(int arr[],int low,int high,int k){
        
        if(low>high)
        return -1;
        int mid=(low+high)/2;
        if(arr[mid]==k)
        return mid;
        if(k>arr[mid]){
            return binarySearch(arr,mid,high,k);
        } 
            return binarySearch(arr,low,mid,k);
        
        
    }
    
    public static void main(String args[])
    {
        int arr1[] = {5, 6, 1, 2, 3, 4};
        int n = arr1.length;
        int key = 5;
        System.out.println(
            "Index of the element is : "
            + new SearchElemetinRoatedArray().search(arr1,0, n-1, key));
    }
}
