package leetcode.stack;

import org.junit.Test;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        char[] chArr = S.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        for (Character ch : chArr){
            if (ch == '('){
                stack.push(ch);
            } else if (ch == ')'){
                stack.pop();
            }
            stringBuilder.append(ch);
            if (stack.isEmpty()){
                resultBuilder.append(stringBuilder.substring(1, stringBuilder.length() - 1));
                stringBuilder = new StringBuilder();
            }
        }
        return resultBuilder.toString();
    }

    @Test
    public void test(){
        String str = "(()())(())";
        System.out.println(removeOuterParentheses(str));
    }
}
