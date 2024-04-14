package org.example.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
    // Copy list with nodes having random pointer
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node itr = head;
        while(itr != null) {
            map.put(itr, new Node(itr.val));
            itr = itr.next;
        }

        itr = head;
        while(itr != null) {
            Node copy = map.get(itr);
            copy.next = map.get(itr.next);
            copy.random = map.get(itr.random);
            itr = itr.next;
        }
        return map.get(head);
    }
}
