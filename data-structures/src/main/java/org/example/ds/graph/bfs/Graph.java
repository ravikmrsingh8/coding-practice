package org.example.ds.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i=0; i<vertices; i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    // Undirected Graph
    void addEdge(int src, int dest) {
        this.adjList[src].add(dest);
    }

    List<Integer> bfs() {
        int N = vertices;
        boolean[] visited = new boolean[N];

        List<Integer> bfsOrder = new ArrayList<>();
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                List<Integer> list = bfsUtil(i, visited);
                bfsOrder.addAll(list);
            }
        }
        return bfsOrder;
    }


    private List<Integer> bfsUtil(int vertex, boolean[] visited) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        visited[vertex] = true;
        q.offer(vertex);

        while(!q.isEmpty()) {
            int N = q.size();
            for(int i=0; i<N; i++) {
                int v = q.poll();
                list.add(v);
                for(int adjNode : adjList[v]) {
                    if(!visited[adjNode]) {
                        visited[adjNode] = true;
                        q.offer(adjNode);
                    }
                }
            }
        }
        return list;
    }

}
