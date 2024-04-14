package org.example.linkedlist;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;

        ListNode p1 = start;
        ListNode p2 = start;

        for(int i=0; i<n; i++) p2 = p2.next;

        while(p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        p1.next = p1.next.next;
        return start.next;
    }
}
