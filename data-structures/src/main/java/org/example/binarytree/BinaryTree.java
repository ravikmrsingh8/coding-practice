package org.example.binarytree;

public class BinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }

    public Node root;

    public BinaryTree() {
    }

    public BinaryTree(Node root){
        this.root = root;
    }

    BinaryTree(int root){
        this(new Node(root));
    }
}
