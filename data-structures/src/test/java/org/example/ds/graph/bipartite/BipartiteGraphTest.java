package org.example.ds.graph.bipartite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BipartiteGraphTest {

    @Test
    @DisplayName("Bipartite Graph Test1")
    public void bipartiteGraphTest1() {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(3,2);
        assertFalse(g.isBipartite());
    }

    @Test
    @DisplayName("Bipartite Graph Test2")
    public void bipartiteGraphTest2() {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(2,1);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(3,2);
        assertTrue(g.isBipartite());
    }

}