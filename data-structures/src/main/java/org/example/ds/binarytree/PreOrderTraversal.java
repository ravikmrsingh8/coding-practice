package org.example.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    List<Integer> traverseIterative(BinaryTree.Node root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;

        Stack<BinaryTree.Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            BinaryTree.Node curr = stack.pop();
            nodes.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left!= null) stack.push(curr.left);
        }
        return nodes;
    }
}
