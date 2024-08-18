package DyamicProgramming;

public class FibonacciSeries {

	static int arr[] = new int[100];

	public static void main(String args[]) {

		int a = 0;
		findFibonacci(a);

	}

	private static void findFibonacci(int a) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
	int b= fib(a);
		 System.out.println(b);
	}

	private static int fibonacci(int a) {

		if (arr[a] == -1) { 
			if (a <= 1)
				arr[a]=a;
			else
				arr[a] = fibonacci(a - 1) + fibonacci(a - 2);
		}
		return arr[a];
	}
	
	 static int fib(int n)
	    {
	        int f[] = new int[n + 1];
	        f[0] = 0;
	        f[1] = 1;
	        for (int i = 2; i <= n; i++)
	            f[i] = f[i - 1] + f[i - 2];
	        return f[n];
	    }
}


