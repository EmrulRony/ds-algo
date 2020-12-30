package dsalgo.stack;

class ArrayImplementation {
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(){
		}
		Node(int data){
			this.data=data;
		}
	}
	
	boolean isEmpty() {
		if (head==null) {
			return true;
		}
		else {
			return false;
		}
	}
	boolean push(int data) {
		Node newNode= new Node(data);
		
		if(head==null) {
			head = newNode;
			System.out.println("Node added "+data );
			return true;
		}
		else{
			Node tempNode= head;
			head = newNode;
			head.next=tempNode;
			System.out.println("Node added "+data );
			return true;
		}
	}
	int pop() {
		if(head==null) {
			System.out.println("The statck is empty");
			return 0;
		}
		else {
			int x= head.data;
			head=head.next;
			return x;
		}
	}
	int top() {
		if (head==null) {
			System.out.println("Stack is null");
			return 0;
		}
		else {
			return head.data;
		}
	}
}

public class iStackImplementationUsingArrayList {
public static void main(String[] args) {
	ArrayImplementation obj = new ArrayImplementation();
	obj.push(10);
	obj.push(20);
	obj.push(30);
	obj.push(40);
	
//	System.out.println(obj.isEmpty());
	System.out.println(obj.pop());
	System.out.println("Current top"+obj.top());
	System.out.println(obj.pop());
	System.out.println("Current top"+obj.top());
	System.out.println(obj.pop());
	System.out.println("Current top"+obj.top());
	System.out.println(obj.pop());
	System.out.println("Current top"+obj.top());
	System.out.println(obj.pop());
}
}
