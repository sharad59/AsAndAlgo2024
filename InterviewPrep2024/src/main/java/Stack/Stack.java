package Stack;

public class Stack {

	int cap = 100;
	int arr[] = new int[cap];

	int top = -1;

	public void push(int data) {
		if (top > cap - 1) {
			System.out.println("stack overflow");
			return;
		}

		arr[++top] = data;
	}

	int pop() {

		if (top == -1) {
			System.out.println("stack underflow");
			return -1;
		}

		int data = arr[top];
		top--;
		return data;
	}

	boolean isEmpty() {

		return top < 0;
	}

	int peek() {
		return arr[top];
	}
	
	void print(){
	    for(int i = top;i>-1;i--){
	      System.out.print(" "+ arr[i]);
	    }
	}
	
	public static void main(String args[]) {
		
		Stack st =new Stack();
		
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.print();
		st.pop();
		st.pop();
		System.out.println("   after pop");
		st.print();
		
		
		
		
		
	}
}
