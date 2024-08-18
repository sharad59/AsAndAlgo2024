package Hashing;

public class UncommonCharactersBw2Strings {

	 static 
	 String uncommonChars(String A, String B)
	    {
	                String str=new String();

	       
	        int arr[]=new int [26];
	        for(int i=0;i<A.length();i++){
	            char ch = A.charAt(i);
	            arr[ch-'a']=1;
	        }
	        
	         for(int i=0;i<B.length();i++){
	            char ch = B.charAt(i);
	            if (arr[ch-'a']==1 || arr[ch-'a']==-1)
	           { arr[ch-'a']=-1;
	        }
	        else{
	             arr[ch-'a']=2;
	       }
	    }
	    
	    for(int i=0;i<arr.length;i++){
	        if(arr[i]==1||arr[i]==2){
	            str+=(char)(i+'a');
	        }
	    }
	        if(str.isEmpty()){
	        return "-1";
	    }
	    
	    return str;
	    

	     }
	 
	 public static void main(String args[]) {
		 String a="geeksforgeeks";
		 String b="geeksquiz";
		 String s= uncommonChars(a, b);
		 System.out.println(s);
		 
	 }
	
}
