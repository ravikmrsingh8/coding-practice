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
