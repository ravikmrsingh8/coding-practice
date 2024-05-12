package org.example.ds.graph.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {
    int vertices;
    List<List<Integer>>  adjList = new ArrayList<List<Integer>>();
    Graph(int vertices) {
        this.vertices = vertices;
        for(int i=0; i<vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for(int i=0; i<vertices; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        List<Integer> topologicalOrder = new ArrayList<>();
        while(!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
        if(visited[vertex]) return;
        visited[vertex] = true;
        for(int w: adjList.get(vertex)) {
            if(!visited[w]) {
                dfs(w, visited, stack);
            }
        }
        stack.push(vertex);
    }
}

