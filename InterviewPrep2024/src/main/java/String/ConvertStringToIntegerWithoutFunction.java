package String;

public class ConvertStringToIntegerWithoutFunction {

	static  int atoi(String s) {
		 double res = 0;
		        boolean dig = false;
		        boolean pos = false;
		        boolean neg = false;
		        boolean other = false;
		        int n = s.length();
		        int i = 0;
		        while (i<n && s.charAt(i)==' ')
		            i++;
		        for (; i<n; i++)
		        {
		            if (other)
		                break;

		            char S = s.charAt(i);
		            if (S>='0' && S<='9')
		            {
		                res = res*10 + (S-'0');
		                dig = true;
		            }
		            else
		            {                                                                                                                                                               


		                 if (S=='-' && !neg)
		                    neg = true;

		                else if (S=='+' && !pos)
		                    pos = true;
		                
		                else
		                    other = true;
		            }
		        }
		        if (other)
		            return -1;
		        if (pos && neg)
		            return 0;

		        if (neg)
		            res = -res;

		        if (res < Integer.MIN_VALUE)
		            return Integer.MIN_VALUE;
		        
		        if (res > Integer.MAX_VALUE)
		            return Integer.MAX_VALUE;

		        return (int)res;

		    }
	
	static int myAtoi(String s) {
	        double res = 0;
	        int i = 0;
	        boolean dig = false;
	        boolean pos = false;
	        boolean neg = false;
	        boolean other = false;
	        int n = s.length();
	     {
	        while (i<n && s.charAt(i) == ' ')
	                i++;
	        }

	        for (int j = i; j < n; j++) {
	            if (other) {
	                break;
	            }
	            
	            char ch = s.charAt(j);
	            if (ch >= '0' && ch <= '9') {
	                res = res * 10 + (ch - '0');
	                dig = true;
	            } else {
	                if (dig)
	                    break;
	                else if (i == j && ch == '-' && !neg)
	                    neg = true;
	                else if (i == j && ch == '+' && !neg)
	                    pos = true;
	                else {
	                    other = true;
	                }
	            }
	        }

	        if (other)
	            return -1;
	        if (pos && neg)
	            return 0;
	        if (neg)
	            res = -res;
	        if (res < Integer.MIN_VALUE)
	            res = Integer.MIN_VALUE;

	        if (res > Integer.MAX_VALUE)
	            res = Integer.MAX_VALUE;

	        return (int) res;
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	 
	        int val = myAtoi(" ");
	        System.out.printf("%d ", val);
	    }
	}
	 

