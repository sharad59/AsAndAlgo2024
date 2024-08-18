package DyamicProgramming;

public class Jump1 {
// If we can reach the end of array from start index 0 
	
	//For each index i, check if the current index is greater than reachable. 
	//If it is, return false since you can't reach this index.
	 public static boolean canJump(int[] nums) {
		  if (nums.length == 0) return false;
	        if (nums[0] == 0 && nums.length > 1) return false;
	        
	       int reachable = 0;
	       for(int i = 0; i < nums.length; i ++) {
	           if(i > reachable) return false;
	           reachable = Math.max(reachable, i + nums[i]);
	       } 
	       return true;
	    }
	 
	 public static void main(String args[]) {
		 
		//int [] nums = {2,3,1,1,4};
		int nums[]= {3,2,1,0,4};
		System.out.println(canJump(nums));
	 }
}
