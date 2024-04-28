package org.example.tree;

public class MaxDepthOfTree {
    public int maxDepth0(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth0(root.left), maxDepth0(root.right));
    }


    static class Height {
        int val;
        Height(int val) {
            this.val = val;
        }
    }
    public int maxDepth1(TreeNode root) {
        Height h = new Height(0);
        maxDepthRec(root, h);
        return h.val;
    }

    private void maxDepthRec(TreeNode root, Height h) {
        if(root == null) {
            h.val = 0;
            return;
        }
        Height lh = new Height(0);
        Height rh = new Height(0);
        maxDepthRec(root.left, lh);
        maxDepthRec(root.right, rh);
        h.val = 1 + Math.max(lh.val, rh.val);
    }
}
