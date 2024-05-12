# Depth First Search

Depth-first search is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.


## DFS Algorithm 

### Recursive implementation of DFS
Input: Output: A recursive implementation of DFS:[5]
```text
DFS(G, v) is
    label v as discovered
    for all directed edges from v to w that are in G.adjacentEdges(v) do
         if vertex w is not labeled as discovered then
            recursively call DFS(G, w)
    
```


### Non Recursive implementation of DFS
Input: Output: A recursive implementation of DFS:[5]
```text
DFS(G, v) is
    label v as discovered
    for all directed edges from v to w that are in G.adjacentEdges(v) do
         if vertex w is not labeled as discovered then
            recursively call DFS(G, w)
    
```


### A non-recursive implementation of DFS with worst-case space complexity
𝑂(|𝐸|)
```text
procedure DFS_iterative(G, v) is
    let S be a stack
    S.push(v)
    while S is not empty do
        v = S.pop()
        if v is not labeled as discovered then
            label v as discovered
            for all edges from v to w in G.adjacentEdges(v) do
                S.push(w)
```
The non-recursive implementation is similar to breadth-first search but differs from it in two ways:

- it uses a stack instead of a queue, and
- it delays checking whether a vertex has been discovered until the vertex is popped from the stack rather than making this check before adding the vertex.

<hr />

### Implementation
```java
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

```

### Test
```java
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
```