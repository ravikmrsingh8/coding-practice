# [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)
https://leetcode.com/problems/add-two-numbers/description/
<hr />

### Problem Statement
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

#### Example 1:
![image info](./addtwonumber1.jpg)
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

```
#### Example 2:

```
Input: l1 = [0], l2 = [0]
Output: [0]

```
#### Example 3:

```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

<hr />

### Solution

[AddTwoNumbers.java](../../src/main/java/org/example/linkedlist/AddTwoNumbers.java)

```java
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

```