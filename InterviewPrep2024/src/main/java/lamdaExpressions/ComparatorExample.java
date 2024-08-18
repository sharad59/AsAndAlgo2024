package lamdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {

	static class Student {
		int a;
		int b;

		Student(int a, int b) {
			this.a = a;
			this.b = b;
		}

	}

	public static void main(String args[]) {

		Student a = new Student(1, 2);
		Student b = new Student(3, 5);

		List<Student> l = new ArrayList<>();
		l.add(b);
		l.add(b);
		Collections.sort(l, (p1, p2) -> {
			return p1.a - p2.a;
		});

	}
}
