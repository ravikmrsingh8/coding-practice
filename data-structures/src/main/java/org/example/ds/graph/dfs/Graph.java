package org.example.ds.graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;
    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i=0; i<vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    List<Integer> dfs() {
        List<Integer> dfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for(int i=0; i<vertices; i++) {
            if(!visited[i]) {
                dfsUtil(i, visited, dfsOrder);
            }
        }
        return dfsOrder;
    }

    private void dfsUtil(int vertex, boolean[] visited, List<Integer> list) {
        if(visited[vertex]) return;
        visited[vertex] = true;
        list.add(vertex);
        for(int adjNode: adjList[vertex]) {
            if(!visited[adjNode]) {
                dfsUtil(adjNode, visited, list);
            }
        }
    }
}
