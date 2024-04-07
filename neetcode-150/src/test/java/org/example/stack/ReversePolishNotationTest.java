package org.example.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @Test
    @DisplayName("Should evaluate RPN expression test 1")
    public void evaluateExpressionTest1() {
        String[] tokens = {"2","1","+","3","*"};
        ReversePolishNotation notation = new ReversePolishNotation();
        int actual = notation.evalRPN(tokens);
        assertEquals(9, actual);
    }

    @Test
    @DisplayName("Should evaluate RPN expression test 2")
    public void evaluateExpressionTest2() {
        String[] tokens = {"4","13","5","/","+"};
        ReversePolishNotation notation = new ReversePolishNotation();
        int actual = notation.evalRPN(tokens);
        assertEquals(6, actual);
    }

    @Test
    @DisplayName("Should evaluate RPN expression test 3")
    public void evaluateExpressionTest3() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        ReversePolishNotation notation = new ReversePolishNotation();
        int actual = notation.evalRPN(tokens);
        assertEquals(22, actual);
    }
}