package org.example.ds.graph.bfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphBFSTest {
    @Test
    @DisplayName("BFS Test1")
    void bfsTest1() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        List<Integer> bfsOrder = g.bfs();
        assertIterableEquals(List.of(0,1,2,3), bfsOrder);
    }

    @Test
    @DisplayName("BFS Test2")
    void bfsTest2() {
        Graph g = new Graph(5);
        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        List<Integer> bfsOrder = g.bfs();
        assertIterableEquals(List.of(0,1,2,3,4), bfsOrder);
    }
}