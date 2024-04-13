# [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/)
https://leetcode.com/problems/valid-palindrome/description/

<hr />

### Problem Statement
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



#### Example 1
```
Input: s = "A man, a plan, a canal: Panama"
Output: true
```
Explanation: "amanaplanacanalpanama" is a palindrome.
#### Example 2
```
Input: s = "race a car"
Output: false
```
Explanation: "raceacar" is not a palindrome.

#### Example 3
```
Input: s = " "
Output: true
```
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

<hr />

### Solution
[Palindrome.java](../../src/main/java/org/example/twopointers/Palindrome.java)
```java
package org.example.twopointers;

public class Palindrome {
    public boolean isValid(String input) {
        char[] str = preprocess(input);
        return isPalindrome(str);
    }

    private boolean isPalindrome(char[] str) {
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

```