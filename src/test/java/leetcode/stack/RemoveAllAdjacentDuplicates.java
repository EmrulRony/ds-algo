package leetcode.stack;

import org.junit.Test;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i=0 ; i<S.length(); i++){
            if (!stack.empty() && S.charAt(i) == stack.peek()){
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        while (!stack.empty()){
            result.append(stack.pop());
        }
        return  result.reverse().toString();
    }

    @Test
    public void test(){
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }
}
