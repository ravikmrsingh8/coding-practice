# [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/description/)
https://leetcode.com/problems/balanced-binary-tree/description/
<hr />

### Problem Statement
Given a binary tree, determine if it is height-balanced. A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

#### Example 1:
![image](./balance_1.jpg)
```
Input: root = [3,9,20,null,null,15,7]
Output: true
```
#### Example 2:
![image2](./balance_2.jpg)
```
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
```
#### Example 3:

```
Input: root = []
Output: true
```

<hr />

### Solution

[BalancedBinaryTree.java](../../src/main/java/org/example/tree/BalancedBinaryTree.java)

```java
package org.example.tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lH = height(root.left);
        int rH = height(root.right);
        return Math.abs(lH - rH ) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

```