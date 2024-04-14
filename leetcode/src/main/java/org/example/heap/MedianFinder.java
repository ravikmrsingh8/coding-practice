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
