# [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/description/)
https://leetcode.com/problems/binary-tree-right-side-view/description/
<hr />

### Problem Statement
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

#### Example 1:
![image](./right-side-view.jpg)
```
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

```
#### Example 2:

```
Input: root = [1,null,3]
Output: [1,3]

```
#### Example 3:

```
Example 3:
Input: root = []
Output: []
```

<hr />

### Solution

[RightSideView.java](../../src/main/java/org/example/tree/RightSideView.java)

```java
package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int N = q.size();
            for(int i=0; i<N; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    nodes.add(node.val);
                }
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
        }
        return nodes;
    }
}

```