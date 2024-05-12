package org.example.ds.graph.bipartite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    List<LinkedList<Integer>> adjList = new ArrayList<>();
    int vertices;
    Graph(int vertices) {
        this.vertices = vertices;
        for(int i=0; i<vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    boolean isBipartite() {
        int[] color = new int[vertices];
        for(int i=0; i<vertices; i++) {
            //if not colored node
            if(color[i] == 0) {
                if(!isBipartite(i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int vertex, int[] color) {
        // color with 1st color
        color[vertex] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(vertex);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int w: adjList.get(node)) {
                if(color[w] == 0) {
                    // color node of opposite color
                    color[w] = color[node] == 1 ? 2 : 1;
                    q.offer(w);
                } else {
                    // if adj node is already colored check that it should not be of same color
                    if(color[w] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
