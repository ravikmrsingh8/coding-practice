package org.example.ds.graph.dfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphDFSTest {
    @Test
    @DisplayName("DFS Test1")
    void dfsTest1() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        List<Integer> dfsOrder = g.dfs();

        assertIterableEquals(List.of(0,1,2,3), dfsOrder);
    }

    @Test
    @DisplayName("dFS Test2")
    void dfsTest2() {
        Graph g = new Graph(5);
        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        List<Integer> dfsOrder = g.dfs();
        assertIterableEquals(List.of(0,1,3,4,2), dfsOrder);

    }

}