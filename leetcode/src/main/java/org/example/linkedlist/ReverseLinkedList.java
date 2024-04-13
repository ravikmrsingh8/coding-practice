package org.example.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode itr = head.next;
            head.next = prev;
            prev = head;
            head = itr;
        }
        return prev;
    }
}
