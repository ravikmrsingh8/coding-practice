# [Reorder List](https://leetcode.com/problems/reorder-list/description/)
https://leetcode.com/problems/reorder-list/description/
<hr />

### Problem Statement

You are given the head of a singly linked-list. The list can be represented as:

L0 -> L1 -> ... -> Ln - 1 -> Ln
Reorder the list to be on the following form:

L0 -> Ln -> L1 -> Ln - 1 -> L2 -> Ln - 2 -> ...
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

#### Example 1:
![image info](./reorder1linked-list.jpg)
```
Input:head = [1,2,3,4]
Output: [1,4,2,3]

```
#### Example 2:
![image info](./reorder2-linked-list.jpg)
```
Example 2:
Input:head = [1,2,3,4,5]
Output: [1,5,2,4,3]

```

<hr />

### Solution

[ReorderList.java](../../src/main/java/org/example/linkedlist/ReorderList.java)

```java
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

```