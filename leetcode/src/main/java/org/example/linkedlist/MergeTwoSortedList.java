package org.example.linkedlist;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        ListNode itr = newNode;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                itr.next = list1;
                list1 = list1.next;
            } else {
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }
        itr.next = list1 != null ? list1 : list2;
        return newNode.next;
    }
}
