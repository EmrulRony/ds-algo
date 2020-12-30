package dsalgo.stack;

class Stack {
	static final int MAX = 1000;
	int top;
	int arr[] = new int[MAX];

	Stack() {
		top = -1;
	}
	boolean push(int num) {
		if (top >= MAX) {
			return false;
		} else {
			arr[++top] = num;
			System.out.println("Number stacked " + num);
		}
		return true;
	}
	int pop() {
		if (top < 0) {
			System.out.println("Stack underflow...");
			return 0;
		}
		else {
			int x = arr[top--];
			return x;
		}
	}
	boolean isEmpty() {
		if (top < 0) {
			return true;
		} else {
			return false;
		}
	}
	int top() {
		if (top < 0) {
			System.out.println("Stack underflow..");
			return 0;
		} else {
			int x = arr[top];
			return x;
		}
	}
}
public class iStackImplementation {
	public static void main(String[] args) {
		Stack obj = new Stack();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		
		System.out.println("----popping-----");
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		
		System.out.println("----------");
		System.out.println(obj.isEmpty());
		System.out.println(obj.top());
	}
}
