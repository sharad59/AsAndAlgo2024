package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Test {


    public int lastIndex( String s) {
        
        int l= s.length();
        
        for(int i=l-1;i>0;i--){
          //  char ch= s.charAt();
           // if(ch=='1')
            return i;
        }
        return -1;
    }
    
    public static ArrayList<Integer> common_element(int v1[], int v2[])
    {
        
        List<Integer> list = new ArrayList<Integer>();
      int max=Integer.MIN_VALUE;
      
        for(int i=0;i<v1.length;i++){
            max=Math.max(max,v1[i]);
        }
        
        int arr[]= new int[max];
        
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<v1.length;i++){
            
            if(!map.containsKey(v1[i])){
            map.put(v1[i],1);
                
            }
            else
            {
                map.put(v1[i],map.get(v1[i])+1);
            }
        }
        
        for(int i=0;i<v1.length;i++){
              if( map.containsKey(v2[i]) && arr[v2[i]] > map.get(v2[i])  ){
               continue;
            }
          else  if( map.containsKey(v2[i])){
                arr[v2[i]]++;
            }
        }
        
        for(int i=0;i<max;i++){
            if(arr[i]>0){
                list.add(arr[i]);
            }
        }
		return null;
    }
    

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

    
public pair[] allPairs( long A[], long B[], long N, long M, long X) {

    HashSet<Long> set = new HashSet<Long>();
    List<pair> list= new ArrayList<pair>();
    for(int i=0;i<N;i++){
        set.add(A[i]);
    }
    
    for(int i=0;i<M;i++){
        if(set.contains(X-B[i]))
        list.add(new pair(X-B[i],B[i]));
    }
    
           Collections.sort(list, new Comparator<pair>() {

	@Override
	public int compare(pair o1, pair o2) {
		return (int) (o1.first-o2.first);
	}
});

            pair arr[]=new pair[list.size()];

for(int i=0;i<list.size();i++){
    arr[i]=list.get(i);
}
return arr;
}
}


