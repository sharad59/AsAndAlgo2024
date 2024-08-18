package lamdaExpressions;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Square {
	int calculate(int x);
}

@FunctionalInterface
interface Sqc{
	
	int cal(int a,int b);
}

public class Test1 {
	public static void main(String args[]) {
		Square s = (int x) -> x * x;
		List<Integer> l =new ArrayList<>();
		
		l.forEach(n->{  if(n%2==0)
			 System.out.println(n); });

		int ans = s.calculate(5);
		System.out.println(ans);

		Square z1 =( x) -> x / 2;
		Square z2 =(int x) -> x / 2;
		Square z = x ->{return  x / 2;};

		

        Sqc c= (a,b)->a/2;
        Sqc g= (d,e)->d*e;
        System.out.println(g.cal(2, 5));
		System.out.println(z.calculate(10));

	}

}
