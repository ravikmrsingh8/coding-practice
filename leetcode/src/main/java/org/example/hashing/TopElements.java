package org.example.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/***
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopElements {
    public int[] topKFrequent(int[] nums, int k) {
        //Map<Integer, Long> map = Arrays.stream(nums)
        //        .boxed()
        //        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, Long> map = new HashMap<>();
        for(int num: nums) map.put(num, 1 + map.getOrDefault(num, 0L));

        PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>((e1, e2) -> (int)(e1.getValue()-e2.getValue()));
        var entries = map.entrySet().stream().toList();
        for (int i = 0; i < k; i++) {
            queue.offer(entries.get(i));
        }

        for (int i = k; i < entries.size(); i++) {
            var entry = queue.peek();
            if (entry != null && entry.getValue() < entries.get(i).getValue()) {
                queue.poll();
                queue.offer(entries.get(i));
            }
        }

        return queue.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
