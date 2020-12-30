package leetcode.stack;

import org.junit.Test;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                else if (ch == ')' && stack.peek() == '('){
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{'){
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '['){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        System.out.println(isValid("([}}])"));
    }
}
