package leetcode.stack;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.

import org.junit.Test;

import java.util.Stack;

class MinStack {
    Node top;
    Stack<Node> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
    }

    class Node{
        int data;
        Node link;

        Node (int data){
            this.data = data;
        }
    }

    public void push(int x) {
        Node newNode = new Node(x);
        if (top == null){
            top = newNode;
            min.push(newNode);
        } else {
            newNode.link = top;
            if (min.peek().data >= newNode.data){
                min.push(newNode);
            }
            top = newNode;
        }

    }

    public void pop() {
        if (top != null){
            if (top.data == min.peek().data){
                min.pop();
            }
            top = top.link;
        }
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return min.peek().data;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
