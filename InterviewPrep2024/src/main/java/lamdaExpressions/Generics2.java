package lamdaExpressions;


class Generics2<T, U>
{
	T obj1; 
	U obj2; 

	Generics2(T obj1, U obj2)
	{
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public void print()
	{
		System.out.println(obj1);
		System.out.println(obj2);
	}
}

class Main
{
	public static void main (String[] args)
	{
		Generics2 <String, Integer> obj =
			new Generics2<String, Integer>("GfG", 15);

		obj.print();
	}

}