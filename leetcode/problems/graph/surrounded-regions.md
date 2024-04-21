# [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/description/)
https://leetcode.com/problems/surrounded-regions/description/
<hr />

### Problem Statement
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

#### Example 1:
![image info](./xogrid.jpg)
```
Input: board = [
["X","X","X","X"],
["X","O","O","X"],
["X","X","O","X"],
["X","O","X","X"]]

Output: [
["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","O","X","X"]]
```
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
- The bottom 'O' is on the border, so it is not flipped. The other three 'O' form a surrounded region, so they are flipped.

#### Example 2:

```
Input: board = [["X"]]
Output: [["X"]]
```

<hr />

### Solution

[SurroundedRegionBoard.java](../../src/main/java/org/example/graph/SurroundedRegionBoard.java)

```java
package org.example.graph;

public class Board {
    char[][] board;
    int ROW;
    int COL;
    boolean[][] visited;

    Board(char[][] board) {
        this.board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
    }

    static int[] di = {0, -1, 0, 1};
    static int[] dj = {1, 0, -1, 0};

    boolean isSafe(int i, int j) {
        return (i>=0 && i< ROW) && (j >=0 && j<COL) && board[i][j] == 'O';
    }


    void captureOpenSide() {
        for(int j = 0; j < COL; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) selectOpen(0, j);
            if (board[ROW - 1][j] == 'O' && !visited[ROW -1][j]) selectOpen(ROW -1, j);
        }
        for(int i= 0; i< ROW; i++) {
            if(board[i][0] == 'O' && !visited[i][0]) selectOpen(i, 0);
            if(board[i][COL -1] == 'O' && !visited[i][COL -1]) selectOpen(i, COL -1);
        }
    }

    void selectOpen(int i, int j) {
        board[i][j] = 'T';
        for(int m = 0; m<4; m++) {
            int ni = i + di[m];
            int nj = j + dj[m];
            if(isSafe(ni, nj)) {
                selectOpen(ni, nj);
            }
        }
    }

    void markCapture() {
        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}

```

[SurroundedRegion.java](../../src/main/java/org/example/graph/SurroundedRegion.java)
```java
package org.example.graph;

import java.util.Arrays;

public class SurroundedRegion {
    public void solve(char[][] board) {
        SurroundedRegionBoard regions = new SurroundedRegionBoard(board);
        regions.captureOpenSide();
        regions.markCapture();
        System.out.println(Arrays.deepToString(board));
    }
}


```