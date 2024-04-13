package org.example.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PalindromeTest {
    @Test
    @DisplayName("Valid Palindrome Test 1")
    public void validPalindromeTest1() {
        Palindrome palindrome = new Palindrome();
        String input = "A man, a plan, a canal: Panama";
        Assertions.assertTrue(palindrome.isValid(input));
    }

    @Test
    @DisplayName("InValid Palindrome Test 1")
    public void validPalindromeTest12() {
        Palindrome palindrome = new Palindrome();
        String input = "race a car";
        Assertions.assertFalse(palindrome.isValid(input));
    }

    @Test
    @DisplayName("Empty String Test 1")
    public void validPalindromeTest13() {
        Palindrome palindrome = new Palindrome();
        String input = " ";
        Assertions.assertTrue(palindrome.isValid(input));
    }
}
