# [Min Stack](https://leetcode.com/problems/min-stack/description/)
https://leetcode.com/problems/min-stack/description/

<hr />

### Problem Statement
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
- void push(int val) pushes the element val onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.

**You must implement a solution with O(1) time complexity for each function.**

#### Example
```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```
<hr />

### Solution
[MinStack.java](../../src/main/java/org/example/stack/MinStack.java)  
```java
package org.example.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if(!minStack.empty()) {
            if(minStack.peek() < val) {
                val = minStack.peek();
            }
        }
        minStack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

```