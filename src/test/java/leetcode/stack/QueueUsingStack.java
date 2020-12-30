package leetcode.stack;

import java.util.Stack;

public class QueueUsingStack {
    /** Initialize your data structure here. */
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int front;
    public QueueUsingStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.empty()){
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int popVal = s2.pop();
        while (!s2.isEmpty()){
            if (s1.isEmpty()) {
                front = s2.peek();
            }
            s1.push(s2.pop());
        }
        return popVal;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }
}
