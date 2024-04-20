package org.example.tree;

public class KthSmallestNode {
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    void inOrder(TreeNode root, int k) {
        if(root == null) return;
        System.out.println("Traversing root.left "+ root.val);
        inOrder(root.left, k);
        System.out.println("Traversing root "+ root.val);
        count += 1;
        if(count == k) {
            ans = root.val;
            return;
        }
        if (count < k) {
            inOrder(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        KthSmallestNode obj = new KthSmallestNode();
        System.out.println(obj.kthSmallest(root, 3));
    }
}
