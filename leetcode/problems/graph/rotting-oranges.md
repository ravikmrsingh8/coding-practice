# [Rotting Oranges](https://leetcode.com/problems/rotting-oranges/description/)
https://leetcode.com/problems/rotting-oranges/description/
<hr />

### Problem Statement
You are given an m x n grid where each cell can have one of three values:

- 0 representing an empty cell,
- 1 representing a fresh orange, or
- 2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
![image info](./oranges.png)
#### Example 1:

```
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

```
#### Example 2:

```
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
```
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

#### Example 3:

```
Input: grid = [[0,2]]
Output: 0
```
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

<hr />

### Solution

[RottenOrangesSolution.java](../../src/main/java/org/example/graph/RottenOrangesSolution.java)

```java
package org.example.graph;

public class RottenOrangesSolution {
    public int orangesRotting(int[][] grid) {
        RottenOrangesGrid oranges = new RottenOrangesGrid(grid);
        return oranges.letThemRot();
    }
}

```


[RottenOrangesGrid.java](../../src/main/java/org/example/graph/RottenOrangesGrid.java)

```java
package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesGrid {
    record Orange(int i, int j){}
    int[][] grid;
    int ROW;
    int COL;

    // Solution
    public RottenOrangesGrid(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        this.grid = grid;
    }

    int[][] moves = {{0, 1}, {0, -1}, {1,0}, {-1, 0}};

    boolean isSafe(int i, int j) {
        return (i>=0 && i<ROW) && (j>=0 && j<COL) && (grid[i][j] == 1);
    }

    int letThemRot() {
        int fresh = 0;
        int minutes = 0;
        Queue<Orange> q = new LinkedList<>();

        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.offer(new Orange(i, j));
            }
        }

        if (fresh == 0) return 0;

        while(!q.isEmpty()) {
            int N = q.size();
            for(int n= 0; n<N; n++) {
                Orange  o = q.poll();
                for(int[] move : moves) {
                    int ni = o.i() + move[0];
                    int nj = o.j() + move[1];
                    if(isSafe(ni, nj)) {
                        grid[ni][nj] = 2;
                        q.offer(new Orange(ni, nj));
                        fresh -= 1;
                    }
                }
            }
            minutes++;
        }

        return fresh > 0 ? -1 : minutes - 1;
    }
}
```