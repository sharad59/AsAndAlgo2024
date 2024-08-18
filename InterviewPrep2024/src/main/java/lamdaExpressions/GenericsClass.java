package lamdaExpressions;

public class GenericsClass<T> {
	T obj;
	
	public void set(T obj) {
		this.obj=obj;
	}
	
	T getObj() {
		return obj;
	}
	
	
	public   T method1(T obj) {
		
		System.out.println(obj.getClass().getName()
                + " = " + obj);
		return obj;
		
		
	}
	public static void main(String args[]) {
		GenericsClass<Double> o=new GenericsClass<Double>();
	o.set(2.3);	
	System.out.println(o.getObj());
	
	o.method1(2.3);
	}
	

}
