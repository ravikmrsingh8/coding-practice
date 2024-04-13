# [Valid Parentheses ](https://leetcode.com/problems/valid-parentheses/description/)
https://leetcode.com/problems/valid-parentheses/description/

<hr>

### Problem Statement
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.


#### Example 1
```
Input: s = "()"
Output: true
```

#### Example 2
```
Input: s = "()[]{}"
Output: true
```

#### Example 3
```
Input: s = "(]"
Output: false
```

<hr>

### Solution
[ValidParentheses.java](../../src/main/java/org/example/stack/ValidParentheses.java)  
```java
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

```