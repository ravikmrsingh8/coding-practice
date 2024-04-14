# [Valid Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/description/)
https://leetcode.com/problems/validate-binary-search-tree/description/
<hr />

### Problem Statement
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.

#### Example 1:
![img](./bst-tree1.jpg)
```
Input: root = [2,1,3]
Output: true

```
#### Example 2:
![img](./bst-tree2.jpg)
```
Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
```
Explanation: The root node's value is 5 but its right child's value is 4.

<hr />

### Solution

[ValidBST.java](../../src/main/java/org/example/tree/ValidBST.java)

```java
package org.example.tree;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;

        return (root.val > min && root.val < max)
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
}

```