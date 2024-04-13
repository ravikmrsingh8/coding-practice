# [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/description/)
https://leetcode.com/problems/daily-temperatures/description/

<hr />

### Problem Statement
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



#### Example 1
```
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

#### Example 2
```
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
```

#### Example 3
```
Input: temperatures = [30,60,90]
Output: [1,1,0]
```

<hr />

### Solution
[DailyTemperature.java](../../src/main/java/org/example/stack/DailyTemperature.java)

```java
package org.example.stack;

import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] days = new int[N];

        for(int i=1; i<N; i++) {
            while(!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                days[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            days[stack.peek()] = 0;
            stack.pop();
        }
        return days;
    }
}

```