package Array;
import java.util.*; 

public class xtoPowerYPairs {


	public static int countPairs(int[] X, int[] Y) 
	{ 
		if (X.length == 0 || Y.length == 0) { 
			return 0; 
		} 
		if (X.length == 1) { 
			int count = 0; 
			for (int y : Y) { 
				if (y < X[0]) { 
					count++; 
				} 
			} 
			return count; 
		} 
		if (Y.length == 1) { 
			int count = 0; 
			for (int x : X) { 
				if (x > Y[0]) { 
					count++; 
				} 
			} 
			return count; 
		} 
		int[] X_left = Arrays.copyOfRange(X, 0, X.length / 2); 
		int[] X_right = Arrays.copyOfRange(X, X.length / 2, X.length); 
		int[] Y_left = Arrays.copyOfRange(Y, 0, Y.length / 2); 
		int[] Y_right = Arrays.copyOfRange(Y, Y.length / 2, Y.length); 
		int count = 0; 
		count += countPairs(X_left, Y_left); 
		count += countPairs(X_left, Y_right); 
		count += countPairs(X_right, Y_left); 
		count += countPairs(X_right, Y_right); 
		return count; 
	} 

	public static void main(String[] args) 
	{ 
		int[] X = { 2, 1, 6 }; 
		int[] Y = { 1, 5 }; 
		System.out.println(countPairs(X, Y)); 
	} 
} 
