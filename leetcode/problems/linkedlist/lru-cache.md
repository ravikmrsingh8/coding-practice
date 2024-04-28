# [LRU Cache](https://leetcode.com/problems/lru-cache/description/)
https://leetcode.com/problems/lru-cache/description/
<hr />

### Problem Statement
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- <code>LRUCache(int capacity)</code> Initialize the LRU cache with positive size capacity.
- <code>int get(int key)</code> Return the value of the key if the key exists, otherwise return -1.
- <code>void put(int key, int value)</code> Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

#### Example 1:

```
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation:
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
```

<hr />

### Solution

[LRUCache.java](../../src/main/java/org/example/linkedlist/LRUCache.java)

```java
package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class LRUCache {
    private final int size;
    Node head = null;
    Node tail = null;
    Map<Integer, Node> map = new HashMap<>();

    /*Initialize an LRU cache with size N */
    public LRUCache(int N) {
        this.size = N;
    }

    /*Returns the value of the key x if present else returns -1 */
    public int get(int x) {

        Node node = map.get(x);

        if(node != null) {
            deleteNode(node);
            addLast(node);
            return node.value;
        }
        return -1;

    }

    /*Sets the key x with value y in the LRU cache */
    public void put(int x, int y) {
        if(!map.containsKey(x)) {
            if(map.size() == size) {
                map.remove(head.key);
                deleteNode(head);
            }
            Node node = new Node(x, y);
            addLast(node);
            map.put(x, node);
        } else {
            Node node = map.get(x);
            node.value = y;

            deleteNode(node);
            addLast(node);
        }
    }


    static class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void deleteNode(Node node) {
        if(head == null){
            return;
        } else if(head == tail && node == head) {
            head = null;
            tail = null;
        } else if(head == node) {
            head = head.next;
            head.prev = null;
        } else if(node == tail)  {
            tail = tail.prev;
            tail.next = null;
        } else  {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

    }
    private void addLast(Node node) {
        if(head == null) {
            head = tail = node;
        } else {
            node.next = null;
            node.prev = tail;
            tail.next = node;

            tail = node;
        }
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        Node itr = head;
        while(itr != null) {
            joiner.add("("+ itr.key +"->"+ itr.value +")");
            itr = itr.next;
        }
        return joiner.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache);

        System.out.println(cache.get(1));
        System.out.println(cache);
        System.out.println(cache.get(2));
        System.out.println(cache);

    }
}

```