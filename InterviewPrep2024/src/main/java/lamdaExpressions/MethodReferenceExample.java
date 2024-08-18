package lamdaExpressions;

import java.util.ArrayList;import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReferenceExample {

	public static void main(String args[]) {
		
		List<String> l = new ArrayList<String>(); 
		l.add("Sharad");
		l.add("Abhilasha");
		l.add("jj");
		l.add("cc");
		Collections.sort(l,MethodReferenceExample::compareByName);
		System.out.println(Arrays.toString(l.toArray()));
		
		MethodReferenceExample mre= new MethodReferenceExample();
		Collections.sort(l,mre::compareByNameObj);
		System.out.println(Arrays.toString(l.toArray()));

		Collections.sort(l,
                String::compareToIgnoreCase);
		System.out.println(Arrays.toString(l.toArray()));

		//List<String> personList= String5, String::new);

		
	}



public static int compareByName(String a , String b) {
	return b.compareTo(a);
}

public  int compareByNameObj(String a , String b) {
	return a.compareTo(b);
}
}