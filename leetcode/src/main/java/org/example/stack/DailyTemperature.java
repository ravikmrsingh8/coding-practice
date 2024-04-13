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
