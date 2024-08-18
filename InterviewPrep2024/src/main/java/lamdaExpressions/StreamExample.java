package lamdaExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String args[]) {
		
		List<Integer> l = Arrays.asList(6, 3, 1, 4);
		
		
		List<Integer> p = l.stream().map(x -> x / 2).collect(Collectors.toList());
		System.out.println(Arrays.toString(p.toArray()));

		List<Integer> t = l.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(Arrays.toString(t.toArray()));

		List<Integer> t1 = l.stream().sorted().collect(Collectors.toList());
		System.out.println(Arrays.toString(t1.toArray()));
		
		l.stream().map(x -> x / 2).forEach(x->System.out.println(x));

		List<Integer> number = Arrays.asList(2,3,4,5,6,8,10);
		int even = number.stream().filter(x->x%2==0).reduce(5,(ans,i)-> ans+i);
		System.out.println("even"+even);
		

	}

}
