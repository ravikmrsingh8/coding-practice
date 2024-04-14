# [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)
https://leetcode.com/problems/linked-list-cycle/description/
<hr />

### Problem Statement
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

#### Example 1:
![image info](./circularlinkedlist.png)
```
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

```
#### Example 2:
![image info](./circularlinkedlist_test2.png)
```
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

```
#### Example 3:

```
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 
```

<hr />

### Solution

[CycleInList.java](../../src/main/java/org/example/linkedlist/CycleInList.java)

```java
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

```