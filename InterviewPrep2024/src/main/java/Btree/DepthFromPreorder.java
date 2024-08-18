package Btree;

public class DepthFromPreorder {

	public static int getDepth(String str, int n,int index ) {
		
	if(str.charAt(index)=='l'||index>=n )
		return 0;
	
	index++;
	int lefth=getDepth(str,n,index);
	index++;
	int righth=getDepth(str,n,index);
	
	return Math.max(lefth, righth)+1;
	
	}
	
	public static void main(String args[]) {
		String str ="nlnnlll";
		int d=getDepth(str,str.length(),0);
		System.out.println(d);
		
		
	}
}
