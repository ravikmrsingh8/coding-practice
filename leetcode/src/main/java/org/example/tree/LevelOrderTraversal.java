package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        q.offer(root);
        while(!q.isEmpty()) {
            int N = q.size();
            List<Integer> nodesAtLevel = new ArrayList<>();
            for(int i=0; i<N; i++) {
                TreeNode node = q.poll();
                nodesAtLevel.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            list.add(nodesAtLevel);
        }

        return list;
    }
}
