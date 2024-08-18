package lamdaExpressions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface CustomAnnotation {
	int value();

	int value2();

}

@CustomAnnotation(value = 10, value2 = 20)
 class Annotations2 {
	public static void main(String args[]) {
		Annotations2 a = new Annotations2();
		CustomAnnotation ca = a.getClass().getAnnotation(CustomAnnotation.class);
		System.out.println(ca.value() + " " + ca.value2());
	}

}

public class Annotations extends Annotations2 {

	public static void main(String args[]) {
		Annotations c = new Annotations();
		CustomAnnotation a = c.getClass().getAnnotation(CustomAnnotation.class);
		System.out.println(a.value());
	}
}
