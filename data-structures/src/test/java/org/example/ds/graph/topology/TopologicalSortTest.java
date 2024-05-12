package org.example.ds.graph.topology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class TopologicalSortTest {
    @Test
    @DisplayName("Topological order test1")
    public void topologicalSortTest1() {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        List<Integer> topologyOrder = g.topologicalSort();
        System.out.println(topologyOrder);
        Assertions.assertIterableEquals(List.of(5,4,2,3,1,0),  topologyOrder);
    }

    @Test
    @DisplayName("Topological order test2")
    public void topologicalSortTest2() {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.topologicalSort();
        List<Integer> topologyOrder = g.topologicalSort();
        System.out.println(topologyOrder);
        Assertions.assertIterableEquals(List.of(3,0,1,2),  topologyOrder);
    }
}