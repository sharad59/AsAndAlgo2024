package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
public class FindAllPairsWithsumKIn2Arrays {
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
