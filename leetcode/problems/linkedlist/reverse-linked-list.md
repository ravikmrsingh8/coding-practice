# [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)
https://leetcode.com/problems/reverse-linked-list/description/
<hr />

### Problem Statement

Given the head of a singly linked list, reverse the list, and return the reversed list.

![image](./rev1ex1.jpg)
#### Example 1:

```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

```
#### Example 2:

```
Input: head = [1,2]
Output: [2,1]

```
#### Example 3:

```
Example 3:
Input: head = []
Output: []
 
```

<hr />

### Solution

[ReverseLinkedList.java](./src/main/java/org/example/linkedlist/ReverseLinkedList.java)

```java
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

```