# [Valid Parentheses ](https://leetcode.com/problems/valid-parentheses/description/)
https://leetcode.com/problems/valid-parentheses/description/


| Solution | [ValidParentheses.java](../../src/main/java/org/example/stack/ValidParentheses.java)          |
|----------|-----------------------------------------------------------------------------------------------|
| Test     | [ValidParenthesesTest.java](../../src/test/java/org/example/stack/ValidParenthesesTest.java) |

## Problem Statement
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.


### Example 1:
```
Input: s = "()"
Output: true
```

### Example 2:
```
Input: s = "()[]{}"
Output: true
```

### Example 3:
```
Input: s = "(]"
Output: false
```

### Constraints:
- 1 <= s.length <= 10^4
- s consists of parentheses only '()[]{}'.