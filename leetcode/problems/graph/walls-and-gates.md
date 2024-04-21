# [Walls and gates](https://leetcode.com/problems/walls-and-gates/description/)
https://leetcode.com/problems/walls-and-gates/description/
<hr />

### Problem Statement
You are given a m x n 2D grid initialized with these three possible values.

- -1 - A wall or an obstacle.
- 0 - A gate.
- INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a Gate, that room should remain filled with INF
![image info](./wallsgrid.jpg)
#### Example 1:

```
Input:
[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output:
[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Explanation:
the 2D grid is:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
the answer is:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

```
#### Example 2

```
Input:
[[0,-1],[2147483647,2147483647]]
Output:
[[0,-1],[1,2]]
```

<hr />

### Solution

[WallsAndGatesGrid.java](../../src/main/java/org/example/graph/WallsAndGatesGrid.java)

```java
package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGatesGrid {
    int ROW;
    int COL;
    int[][] grid;
    record Cell(int i, int j, int dist){}
    static final int INF = Integer.MAX_VALUE;
    static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1,0}};
    public WallsAndGatesGrid(int[][] grid) {
        this.grid = grid;
        ROW = grid.length;
        COL = grid[0].length;
    }

    boolean safe(int i, int j) {
        return (i>= 0 && i<ROW) && (j>=0 && j<COL) && grid[i][j] == INF;
    }

    public void doBFSFromGates() {
        Queue<Cell> q = new LinkedList<>();

        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new Cell(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()) {
            int N = q.size();
            for(int n=0; n<N; n++) {
                Cell cell = q.poll();
                for(int[] move : moves) {
                    int ni = cell.i() + move[0];
                    int nj = cell.j() + move[1];
                    if (safe(ni, nj)) {
                        grid[ni][nj] = cell.dist() + 1;
                        q.offer(new Cell(ni, nj, grid[ni][nj]));
                    }
                }
            }
        }
    }
}

```

[WallsAndGates.java](../../src/main/java/org/example/graph/WallsAndGates.java)

```java
package org.example.graph;

import java.util.Arrays;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        WallsAndGatesGrid grid = new WallsAndGatesGrid(rooms);
        grid.doBFSFromGates();
    }

    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int[][] rooms = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        solution.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));


        int[][] rooms2 = {
                {0,-1},
                {2147483647,2147483647}
        };
        solution.wallsAndGates(rooms2);
        System.out.println(Arrays.deepToString(rooms2));

    }
}

```