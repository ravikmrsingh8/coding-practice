# [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/description/)
https://leetcode.com/problems/invert-binary-tree/description/
<hr />

### Problem Statement
Given the root of a binary tree, invert the tree, and return its root.

#### Example 1:
![image](./invert1-tree.jpg)
```
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

```
#### Example 2:
![image](./invert2-tree.jpg)
```
Input: root = [2,1,3]
Output: [2,3,1]

```
#### Example 3:

```
Example 3:
Input: root = []
Output: []
 
```

<hr />

### Solution

[InvertTree.java](../../src/main/java/org/example/tree/InvertTree.java)

```java
package org.example.tree;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        // Swap Nodes
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        // Recurse for left and right subtree
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

```