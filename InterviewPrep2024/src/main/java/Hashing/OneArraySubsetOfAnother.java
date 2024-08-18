package Hashing;

import java.util.HashMap;

public class OneArraySubsetOfAnother {

    public static String isSubset( long a1[], long a2[]) {
        
        HashMap<Long,Long> map= new HashMap<>();
         HashMap<Long,Long> map2= new HashMap<>();
                 
                 for(int i=0;i<a1.length;i++){
                     map.put(a1[i],map.getOrDefault(a1[i],0l)+1);
                 }
                 
                   for(int i=0;i<a2.length;i++){
                     map2.put(a2[i],map2.getOrDefault(a2[i],0l)+1);
                 }


                  for(int i=0;i<a2.length;i++){
                    if(!map.containsKey(a2[i])){
                        return "No";
                    }
                    else if(map.containsKey(a2[i]) && map.get(a2[i])<map2.get(a2[i])){
                        return "No";
                    }
                 }
                 
                 return "Yes";
     }
    

	public static void main(String args[]) {
		long a1[] = {10, 5, 2, 23, 19};
		long a2[] = {19, 5, 3};
		isSubset(a1,a2);

	}
}
