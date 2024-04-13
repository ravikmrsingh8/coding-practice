package org.example.linkedlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    @DisplayName("Reverse Linked List Test1 ")
    public void reverseLinkedListTest1() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode head2 = list.reverseList(head);
        assertNotNull(head2);

        int val = 4;
        ListNode itr = head2;
        while(itr != null) {
            assertEquals(val--, itr.val);
            itr = itr.next;
        }
    }

    @Test
    @DisplayName("Reverse Linked List Test2 ")
    public void reverseLinkedListTest2() {
        ListNode head = new ListNode(1);
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode head2 = list.reverseList(head);
        assertNotNull(head2);

        int val = 1;
        ListNode itr = head2;
        while(itr != null) {
            assertEquals(val--, itr.val);
            itr = itr.next;
        }
    }

    @Test
    @DisplayName("Reverse Linked List Test3 ")
    public void reverseLinkedListTest3() {
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode head2 = list.reverseList(null);
        assertNull(head2);
    }

}