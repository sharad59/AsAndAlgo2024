package lamdaExpressions;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
	private int s = 5;

	int method1(int a, int b) {
		System.out.println("a+b " + a + b);
		return a + b;
	}
	
	void method() {
		System.out.println("a+b " +10);
	}


	void method2(Boolean c) {
		System.out.println("boolean output" + c);
		
	}

	public static void main(String args[]) throws Exception {
		Reflection rf = new Reflection();
		Class c = rf.getClass();
		Method m2 = c.getDeclaredMethod("method");
		m2.invoke(rf);
		Field [] f=c.getDeclaredFields();
		int arr []= new int [5];
		Field f2 =f[0];
		f2.setAccessible(true);
		System.out.println(f[0]);
		Object obj = Class.forName("lamdaExpressions.Reflection");
		Method[] mlist = obj.getClass().getMethods();
		Method m = mlist[0];
		System.out.println(mlist);
		System.out.println(m);

		// Reflection o = (Reflection) obj;
		// o.method1(4, 3);
	}
	
	 public int maximumCandies(int[] arr, long k) {

	        int n = arr.length;
	        long sum = Arrays.stream(arr).sum();
	        long r = sum / k;
	         r++;

	        long l = 0;
	        long ans = 0;
	        while (l < r) {
	            long c = 0;

	            long mid = (l + r) / 2;
	            if (mid == 0)
	                return 0;

	            for (int i = 0; i < n; i++) {
	                c += arr[i] / mid;
	            }
	            if (c >= k) {
	                ans =Math.max(mid,ans);
	                l = mid + 1;
	            } else {
	                r = mid;
	            }
	        }
	        return (int)ans;
	    }

}
