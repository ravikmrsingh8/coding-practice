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
