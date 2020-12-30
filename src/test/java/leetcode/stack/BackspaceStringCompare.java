package leetcode.stack;

import org.junit.Test;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return  getString(S).equals(getString(T));
    }
    public String getString(String str){
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (Character ch : chars){
            if (ch.equals('#')){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }

    @Test
    public void test(){
        String S = "y#f#o##f";
        String T = "y#fo##f";
        System.out.println(backspaceCompare(S,T));
    }
}
