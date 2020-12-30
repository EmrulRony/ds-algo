package leetcode.stack;

import org.junit.Test;

import java.util.Stack;

public class BasketBallGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops){
            switch (op){
                case "+":
                    int prev1 = stack.pop();
                    int prev2 = stack.pop();
                    int newScore = prev1+prev2;
                    stack.push(prev2);
                    stack.push(prev1);
                    stack.push(newScore);
                    break;
                case "D":
                    int updated = stack.peek() * 2;
                    stack.push(updated);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    @Test
    public void test(){
        String[] ops = {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }
}
