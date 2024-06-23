package org.example.ds.stack.expression;

import java.util.Stack;

// Infix to postfix docs/stack/infixtopostfix.pdf
public class InfixToPostfix {

    public static void main(String[] args) {
        String expression = "A+B*C/D-E";
        String postfix = toPostfix(expression);
        System.out.println(postfix);


        expression = "(A+B*(C-D))/E";
        postfix = toPostfix(expression);
        System.out.println(postfix);
    }

    static String toPostfix(String infix) {
        char[] expression = infix.toCharArray();
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch: expression) {
            if(Character.isAlphabetic(ch)) {
                postfix.append(ch);
            } else if(ch == '(') {
                stack.push('(');
            }  else if (ch == ')') {
                while(!stack.isEmpty()) {
                    char popped = stack.pop();
                    if(popped != '(') postfix.append(popped);
                    else {
                        break;
                    }
                }
            } else {
                while(!stack.isEmpty() && (precedence(ch) <= precedence(stack.peek()))) {
                    char popped = stack.pop();
                    postfix.append(popped);
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }


    static int precedence(char operator) {
        if(operator == '^') return 3;
        if(operator == '*' || operator == '/') return 2;
        if(operator == '+' || operator == '-') return 1;
        return 0;
    }


}
