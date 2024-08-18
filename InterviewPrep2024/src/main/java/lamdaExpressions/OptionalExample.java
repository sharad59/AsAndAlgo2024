package lamdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

	public static void main(String args[]) throws Exception {

		Optional<String> e = Optional.empty();
		List<String> li = new ArrayList<>();
		// System.out.println(e.get());

		String arr[] = new String[5];
		Optional<String> a = Optional.ofNullable(arr[2]);
		 Optional<String> b = Optional.of(arr[2]);

		System.out.println(a.isEmpty() + " " + a.isPresent());
		// System.out.println(b.get());
		String o = e.orElse("Default value ");
		e.orElseThrow(() -> new Exception());

		System.out.println(o);
		// String d=e.orElseGet(arr[0]);
		System.out.println("Value by orElseThrow(" + "ArithmeticException::new) method: "
				+ e.orElseThrow(ArithmeticException::new));
		

	}

}
