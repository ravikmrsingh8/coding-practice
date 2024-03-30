package org.example.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        char[] expression = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : expression) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.empty()) {
                    return false;
                }
                char popped = stack.pop();
                if(!isValidMatch(popped, ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isValidMatch(char popped, char ch) {
        return (popped == '[' && ch == ']')
                || (popped == '{' && ch == '}')
                || (popped == '(' && ch == ')');
    }
}
