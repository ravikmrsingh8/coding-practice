# [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/description/)
https://leetcode.com/problems/diameter-of-binary-tree/description/
<hr />

### Problem Statement
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

#### Example 1:
![image](./diamtree.jpg)
```
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
```
#### Example 2:

```
Input: root = [1,2]
Output: 1
```

<hr />

### Solution

[DiameterOfBinaryTree.java](../../src/main/java/org/example/tree/DiameterOfBinaryTree.java)

```java
package org.example.tree;

public class DiameterOfBinaryTree {
    private static class Height {
        int val;
        Height(int val) {
            this.val = val;
        }
    }

    //Optimal Solution
    public int diameterOfBinaryTreeOptimal(TreeNode root) {
        return diameter(root, new Height(0));
    }

    // N^2 Solution
    public int diameterOfBinaryTreeN2(TreeNode root) {
        if (root == null) return 0;
        int lD = diameterOfBinaryTreeN2(root.left);
        int rD = diameterOfBinaryTreeN2(root.right);
        int fromRoot = height(root.left) + height(root.right);
        return Math.max(fromRoot, Math.max(lD, rD));
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private int diameter(TreeNode root, Height h) {
        if(root == null) {
            h.val = 0;
            return 0;
        }

        Height lh = new Height(0);
        Height rh = new Height(0);
        int leftD = diameter(root.left, lh);
        int rightD = diameter(root.right, rh);
        h.val = 1 + Math.max(lh.val, rh.val);

        return Math.max(lh.val + rh.val, Math.max(leftD, rightD));
    }

}

```