package org.example.twopointers;

public class Palindrome {
    public boolean isValid(String input) {
        char[] str = preprocess(input);
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    char[] preprocess(String input) {
        char[] arr = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch : arr) {
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        }
        return sb.toString().toCharArray();
    }
}
