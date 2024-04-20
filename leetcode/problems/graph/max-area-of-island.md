# [Max Area of Island](https://leetcode.com/problems/max-area-of-island/description/)
https://leetcode.com/problems/max-area-of-island/description/
<hr />

### Problem Statement
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

![image info](./maxarea1-grid.jpg)
#### Example 1:

```
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

```
#### Example 2:

```
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 
```

<hr />

### Solution

[IslandMaxArea.java](../../src/main/java/org/example/graph/IslandMaxArea.java)

```java
package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandMaxArea {
    int ROW;
    int COL;
    boolean[][] visited;
    int[][] grid;

    record Node(int i, int j){};

    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};


    IslandMaxArea(int[][] grid) {
        this.grid = grid;
        ROW = grid.length;
        COL = grid[0].length;
        visited = new boolean[ROW][COL];
    }

    int maxArea() {
        int count = 0;
        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count = Math.max(count, bfs(i,j));
                }
            }
        }
        return count;
    }

    boolean isSafe(int i, int j) {
        return (i >= 0 && i < ROW) && (j >=0 && j<COL)
                && !visited[i][j] && grid[i][j] == 1;
    }

    int bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        visited[i][j] = true;
        int count = 0;
        while(!q.isEmpty()) {
            int N = q.size();
            count += N;

            for(int n=0; n<N; n++) {
                Node node = q.poll();
                for (int m=0; m<4; m++) {
                    int ni = node.i() + di[m];
                    int nj = node.j() + dj[m];
                    if (isSafe(ni, nj)) {
                        visited[ni][nj] = true;
                        q.offer(new Node(ni, nj));
                    }
                }
            }
        }
        return count;
    }

}
```