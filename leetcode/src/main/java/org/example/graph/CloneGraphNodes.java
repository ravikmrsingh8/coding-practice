package org.example.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraphNodes {
    public Node cloneGraph(Node src) {
        if(src == null) return null;

        Set<Node> visited = new HashSet<>();
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        // get mapping between old and new nodes
        q.offer(src);
        visited.add(src);
        while(!q.isEmpty()) {
            int N = q.size();
            for(int i=0; i<N; i++) {
                Node node = q.poll();
                Node newNode = new Node(node.val);
                map.put(node, newNode);
                for(Node adjNode : node.neighbors) {
                    if(!visited.contains(adjNode)) {
                        q.offer(adjNode);
                        visited.add(adjNode);
                    }
                }
            }
        }

        // fill adjList
        visited.clear();
        q.offer(src);
        visited.add(src);
        while(!q.isEmpty()) {
            int N = q.size();
            for(int i=0; i<N; i++) {
                Node node = q.poll();
                Node cNode = map.get(node);
                for(Node adjNode: node.neighbors) {
                    cNode.neighbors.add(map.get(adjNode));
                    if(!visited.contains(adjNode)) {
                        q.offer(adjNode);
                        visited.add(adjNode);
                    }
                }
            }
        }
        return map.get(src);
    }
}
