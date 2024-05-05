package org.example.binarytree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeTraversalTest {
    @Test
    public void inOrderTraversalTest() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.left.right.left = new BinaryTree.Node(6);
        root.left.right.right = new BinaryTree.Node(7);
        root.left.right.right.left = new BinaryTree.Node(8);

        List<Integer> nodes = new InOrderTraversal().traverseIterative(root);
        assertIterableEquals(List.of(4, 2, 6, 5, 8, 7, 1, 3), nodes);
    }

    @Test
    public void preOrderTraversalTest() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.left.right.left = new BinaryTree.Node(6);
        root.left.right.right = new BinaryTree.Node(7);
        root.left.right.right.left = new BinaryTree.Node(8);

        List<Integer> nodes = new PreOrderTraversal().traverseIterative(root);
        assertIterableEquals(List.of(1, 2, 4, 5, 6, 7, 8, 3), nodes);
    }

    @Test
    public void diagonalTraversalTest() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.left.right.left = new BinaryTree.Node(6);
        root.left.right.right = new BinaryTree.Node(7);
        root.left.right.right.left = new BinaryTree.Node(8);

        List<Integer> nodes = new DiagonalTraversal().traverse(root);
        assertIterableEquals(List.of(1, 3, 2, 5, 7, 4, 6, 8), nodes);
    }

    @Test
    public void zigZagTraversalTest() {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.left.right.left = new BinaryTree.Node(6);
        root.left.right.right = new BinaryTree.Node(7);
        root.left.right.right.left = new BinaryTree.Node(8);

        List<Integer> nodes = new ZigZagTraversal().traverse(root);
        assertIterableEquals(List.of(1, 3, 2, 4, 5, 7, 6, 8), nodes);
    }
}