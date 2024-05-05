package org.example.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    List<Integer> traverseIterative(BinaryTree.Node root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;

        BinaryTree.Node curr = root;
        Stack<BinaryTree.Node> stack = new Stack<>();
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()) {
            BinaryTree.Node node = stack.pop();
            nodes.add(node.val);
            if (node.right != null) {
                curr = node.right;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return nodes;
    }
}
