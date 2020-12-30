package leetcode.stack;

import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] imputChars = s.toCharArray();
        StringBuilder resultBuilder = new StringBuilder();
        for (Character ch : imputChars){
            if (!stack.isEmpty() && ch.toString().equalsIgnoreCase(stack.peek().toString()) && (
                    (Character.isUpperCase(ch) && Character.isLowerCase(stack.peek())) ||
                            Character.isLowerCase(ch) && Character.isUpperCase(stack.peek()))){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        while(!stack.empty()){
            resultBuilder.append(stack.pop());
        }
        return resultBuilder.reverse().toString();
    }
}
