# [Number of Islands](https://leetcode.com/problems/number-of-islands/description/)
https://leetcode.com/problems/number-of-islands/description/
<hr />

### Problem Statement
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

#### Example 1:

```
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

```
#### Example 2:

```
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
```

<hr />

### Solution

[NumIslands.java](../../src/main/java/org/example/graph/NumIslands.java)

```java
package org.example.graph;

class NumIslands {
    public int numIslands(char[][] grid) {
        //IslandsBFS islandsByBFS = new IslandsBFS(grid);
        //return islandsByBFS.count();

        IslandsDFS islandsByDFS = new IslandsDFS(grid);
        return islandsByDFS.count();
    }
}



```

```java
package org.example.graph;

public class IslandsDFS {
    boolean[][] visited;
    int row;
    int col;
    char[][] grid;

    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};

    public IslandsDFS(char[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        visited = new boolean[row][col];
    }

    public int count() {
        int count = 0;
        for(int i=0; i < row; i++) {
            for(int j=0; j< col; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(i,j);
                }
            }
        }
        return count;
    }

    boolean isSafe(int i, int j) {
        return (i >= 0 && i < row) && (j >=0 && j < col)
                && grid[i][j] == '1'
                && !visited[i][j];
    }

    void dfs(int i, int j) {
        visited[i][j] = true;
        for (int m = 0; m < 4; m++) {
            int ni = i + di[m];
            int nj = j + dj[m];
            if (isSafe(ni, nj)) {
                dfs(ni, nj);
            }
        }
    }
}
```

```java
package org.example.graph;


import java.util.LinkedList;
import java.util.Queue;

public class IslandsBFS {
    record Node(int i, int j){}
    boolean[][] visited;
    int row;
    int col;
    char[][] grid;

    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};

    public IslandsBFS(char[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        visited = new boolean[row][col];
    }

    int count() {
        int count = 0;
        for(int i=0; i < row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    bfs(i,j);
                }
            }
        }
        return count;
    }

    boolean isSafe(int i, int j) {
        return (i >= 0 && i < row) && (j >=0 && j < col)
                && grid[i][j] == '1'
                && !visited[i][j];
    }

    void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(i, j));
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int N = q.size();
            for(int n = 0; n< N; n++) {
                Node node = q.poll();
                for (int m = 0; m < 4; m++) {
                    int ni = node.i() + di[m];
                    int nj = node.j() + dj[m];
                    if (isSafe(ni, nj)) {
                        visited[ni][nj] = true;
                        q.offer(new Node(ni, nj));
                    }
                }
            }
        }
    }
}

```