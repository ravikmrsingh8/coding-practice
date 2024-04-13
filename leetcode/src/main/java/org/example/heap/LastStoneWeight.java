package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones) q.offer(stone);

        while(q.size() > 1) {
            int x = q.poll();
            int y = q.poll();
            int z = Math.abs(x-y);
            if (z != 0) {
                q.offer(z);
            }
        }

        return !q.isEmpty() ? q.peek() : 0;
    }
}
