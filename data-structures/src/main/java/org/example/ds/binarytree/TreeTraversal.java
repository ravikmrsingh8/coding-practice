package org.example.ds.binarytree;

import java.util.List;

public class TreeTraversal {
    BinaryTree.Node root;
    TreeTraversal(BinaryTree.Node root) {
        this.root = root;
    }
    List<Integer> traverse(TraversalOrder order) {
        if(order == TraversalOrder.InOrderIterative) {
            return new InOrderTraversal().traverseIterative(root);
        }
        if(order == TraversalOrder.PreOrderIterative) {
            return new PreOrderTraversal().traverseIterative(root);
        }

        return null;
    }
}
