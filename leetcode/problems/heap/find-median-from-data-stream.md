# [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/description/)
https://leetcode.com/problems/find-median-from-data-stream/description/
<hr />

### Problem Statement
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

- For example, for arr = [2,3,4], the median is 3.
- For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:

- MedianFinder() initializes the MedianFinder object.
- void addNum(int num) adds the integer num from the data stream to the data structure.
- double findMedian() returns the median of all elements so far. Answers within 10^-5 of the actual answer will be accepted.

#### Example 1:

```
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

```
Explanation
- MedianFinder medianFinder = new MedianFinder();
- medianFinder.addNum(1);    // arr = [1]
- medianFinder.addNum(2);    // arr = [1, 2]
- medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
- medianFinder.addNum(3);    // arr[1, 2, 3]
- medianFinder.findMedian(); // return 2.0


#### Follow up:
- If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
- If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

<hr />

### Solution

[MedianFinder.java](../../src/main/java/org/example/heap/MedianFinder.java)

```java
package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> minQ = new PriorityQueue<Integer>();
    Queue<Integer> maxQ = new PriorityQueue<Integer>(Comparator.reverseOrder());

    double median = Integer.MAX_VALUE;

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (num < median) {
            if(maxQ.size() > minQ.size()) {
                minQ.offer(maxQ.poll());
            }
            maxQ.offer(num);
        } else {
            if(minQ.size() > maxQ.size()) {
                maxQ.offer(minQ.poll());
            }
            minQ.offer(num);
        }
        median = updateMedian();
    }


    public double updateMedian() {
        if (maxQ.size() > minQ.size()) return maxQ.peek();
        if (minQ.size() > maxQ.size()) return minQ.peek();
        return (minQ.peek() + maxQ.peek()) / 2.0;
    }

    public double findMedian() {
        return median;
    }
}

```