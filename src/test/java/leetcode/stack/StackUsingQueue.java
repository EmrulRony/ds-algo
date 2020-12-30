package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    /** Initialize your data structure here. */
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;

    public StackUsingQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1){
            top = q1.poll();
            q2.add(top);
        }
        int peekVal = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return peekVal;
    }

    /** Get the top element. */
    public int top() {
        return  top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
