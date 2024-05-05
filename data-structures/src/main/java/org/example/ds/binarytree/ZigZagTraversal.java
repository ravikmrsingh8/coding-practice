package org.example.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {
    public List<Integer> traverse(BinaryTree.Node root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;

        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.offer(root);
        boolean ltr = true;

        while(!q.isEmpty()) {
            int N = q.size();
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<N; i++) {
                BinaryTree.Node node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if(ltr) {
                    nodes.add(node.val);
                } else {
                    stack.push(node.val);
                }
            }
            if(!ltr) {
                while(!stack.isEmpty())nodes.add(stack.pop());
            }
            ltr = !ltr;
        }
        return nodes;
    }
}
