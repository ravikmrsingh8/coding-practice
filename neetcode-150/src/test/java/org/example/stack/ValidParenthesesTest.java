package org.example.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ValidParenthesesTest {
    @Test
    @DisplayName("Valid Parentheses Test 1")
    public void validParenthesesTest1() {
        ValidParentheses test = new ValidParentheses();
        Assertions.assertTrue(test.isValid("()"));
    }

    @Test
    @DisplayName("Valid Parentheses Test 2")
    public void validParenthesesTest2() {
        ValidParentheses test = new ValidParentheses();
        Assertions.assertTrue(test.isValid("()[]{}"));
    }

    @Test
    @DisplayName("InValid Parentheses Test 1")
    public void inValidParenthesesTest1() {
        ValidParentheses test = new ValidParentheses();
        Assertions.assertFalse(test.isValid("(]"));
    }

}