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
