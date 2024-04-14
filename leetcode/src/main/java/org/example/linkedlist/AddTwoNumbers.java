package org.example.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        int carry = 0;
        ListNode result = new ListNode();
        ListNode itr = result;

        while(list1 != null && list2 != null) {
            int sum = carry + list1.val + list2.val;
            carry = sum / 10;
            sum = sum % 10;
            itr.next = new ListNode(sum);
            itr = itr.next;
            list1 =  list1.next;
            list2 = list2.next;
        }

        ListNode list = list1 == null ? list2 : list1;
        while(list != null) {
            int sum = carry + list.val;
            carry = sum / 10;
            sum = sum % 10;
            itr.next = new ListNode(sum);
            itr = itr.next;
            list = list.next;
        }

        if(carry > 0) {
            itr.next = new ListNode(carry);
        }
        return result.next;
    }
}
