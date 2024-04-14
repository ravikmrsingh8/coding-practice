# [Same Tree](https://leetcode.com/problems/same-tree/description/)
https://leetcode.com/problems/same-tree/description/
<hr />

### Problem Statement
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


#### Example 1:
![image info](./same-tree-ex1.jpg)
```
Input: p = [1,2,3], q = [1,2,3]
Output: true

```
#### Example 2:
![image info](./same-tree-ex2.jpg)
```
Input: p = [1,2], q = [1,null,2]
Output: false

```
#### Example 3:
![image info](./same-tree-ex3.jpg)
```
Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
 
```

<hr />

### Solution

[SameTree.java](../../src/main/java/org/example/tree/SameTree.java)

```java
package org.example.tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

```