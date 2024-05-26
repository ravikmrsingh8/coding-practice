package org.example.tree;

import java.util.Stack;

public class KthSmallestNode {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        int count =0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            count++;
            if(count == k) {
                return node.val;
            }
            if(node.right != null) {
                curr = node.right;
                while(curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        //Shouldn't reach here ever
        return -1;
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
