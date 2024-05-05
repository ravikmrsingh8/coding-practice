package org.example.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {
    Map<Integer, List<Integer>> map = new TreeMap<>();
    public ArrayList<Integer> traverse(BinaryTree.Node root) {
        //add your code here.
        diagonal(root, 0);
        ArrayList<Integer> list = new ArrayList<>();
        map.forEach((key, val) -> {
            list.addAll(val);
        });
        return list;
    }

    void diagonal(BinaryTree.Node root, int depth) {
        if(root == null) return;

        List<Integer> nodes = this.map.getOrDefault(depth, new ArrayList<>());
        nodes.add(root.val);
        map.put(depth, nodes);
        diagonal(root.left, depth + 1);
        diagonal(root.right, depth);
    }
}
