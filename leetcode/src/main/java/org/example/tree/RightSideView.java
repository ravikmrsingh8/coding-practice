package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if(root == null) return nodes;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int N = q.size();
            for(int i=0; i<N; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    nodes.add(node.val);
                }
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
        }
        return nodes;
    }
}
