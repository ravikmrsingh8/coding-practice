# [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
<hr />

### Problem Statement
Given the head of a linked list, remove the nth node from the end of the list and return its head.

![image](./remove_ex1.jpg)
#### Example 1:

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

```
#### Example 2:

```
Input: head = [1], n = 1
Output: []

```
#### Example 3:

```
Example 3:
Input: head = [1,2], n = 1
Output: [1]
```

<hr />

### Solution

[RemoveNthNodeFromEnd.java](../../src/main/java/org/example/linkedlist/RemoveNthNodeFromEnd.java)

```java
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

```