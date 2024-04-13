package org.example.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        // Split list in two using fast and slow pointers
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        // Reverse second half
        ListNode prev = null;
        while(second != null) {
            ListNode itr = second.next;
            second.next = prev;
            prev = second;
            second = itr;
        }

        // Merge alternatively
        ListNode head2 = prev;
        ListNode head1 = head;

        while(head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;

            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
    }
}
