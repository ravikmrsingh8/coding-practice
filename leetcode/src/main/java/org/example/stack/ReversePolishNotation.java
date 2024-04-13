package org.example.stack;

import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class ReversePolishNotation {
    static Map<String, IntBinaryOperator> operator = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    private boolean isOperator(String token) {
        return operator.containsKey(token);
    }

    private int evaluateOp(String op, int a, int b) {
        return operator.get(op).applyAsInt(a, b);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = evaluateOp(token, a, b);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}
