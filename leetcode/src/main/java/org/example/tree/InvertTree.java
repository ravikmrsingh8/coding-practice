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
