# [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/)
https://leetcode.com/problems/merge-two-sorted-lists/description/
<hr />

### Problem Statement
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

![image info](./merge_ex1.jpg)
#### Example 1:

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

```
#### Example 2:

```
Input: list1 = [], list2 = []
Output: []

```
#### Example 3:

```
Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 
```

<hr />

### Solution

[MergeTwoSortedList.java](./src/main/java/org/example/linkedlist/MergeTwoSortedList.java)

```java
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

```