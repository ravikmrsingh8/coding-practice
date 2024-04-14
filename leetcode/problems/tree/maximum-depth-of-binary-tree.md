# [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
<hr />

### Problem Statement
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

![image](./max-depth-tree.jpg)

#### Example 1:

```
Input: root = [3,9,20,null,null,15,7]
Output: 3

```
#### Example 2:

```
Example 2:
Input: root = [1,null,2]
Output: 2
 
```

<hr />

### Solution

[MaxDepthOfTree.java](../../src/main/java/org/example/tree/MaxDepthOfTree.java)

```java
package org.example.tree;

public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

```