package org.example.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CycleInList {
    public boolean hasCycle(ListNode head) {
        return hasCycle1(head);
    }

    boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

    boolean hasCycle0(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while(head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }
}
