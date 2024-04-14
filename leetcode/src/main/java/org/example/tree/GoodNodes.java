package org.example.tree;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    int goodNodes(TreeNode root, int max) {
        if(root == null) return 0;
        max = Math.max(root.val, max);
        int goodnode = root.val >= max ? 1 : 0;
        return goodnode + goodNodes(root.left, max)  + goodNodes(root.right, max);
    }
}
