# [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/description/)
https://leetcode.com/problems/pacific-atlantic-water-flow/description/
<hr />

### Problem Statement
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.


#### Example 1:
![image](./waterflow-grid.jpg)
```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the
Pacific and Atlantic oceans.

```
#### Example 2:

```
Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 
```

<hr />

### Solution

[WaterFlowGrid.java](../../src/main/java/org/example/graph/WaterFlowGrid.java)

```java
package org.example.graph;

import java.util.ArrayList;
import java.util.List;

public class WaterFlowGrid {
    int ROW;
    int COL;
    int[][] heights;
    char[][] ocean;
    List<List<Integer>> coordinates = new ArrayList<>();

    WaterFlowGrid(int[][] heights) {
        this.heights = heights;
        ROW = heights.length;
        COL = heights[0].length;
        ocean = new char[ROW][COL];
    }

    void pacificFlow() {
        for(int j=0; j<COL; j++) pdfs(0, j);
        for(int i=0; i<ROW; i++) pdfs(i, 0);
    }

    int[][] moves = {{0, 1}, {1, 0}, {0,-1}, {-1, 0}};

    boolean safe(int i, int j, char ch) {
        return (i>=0 && i<ROW) && (j>=0 && j<COL) && ocean[i][j] != ch;
    }

    void pdfs(int i, int j) {
        ocean[i][j] = 'P';
        for(int[] move : moves) {
            int ni = i + move[0];
            int nj = j + move[1];
            if(safe(ni, nj, 'P') && heights[i][j] <= heights[ni][nj]) {
                pdfs(ni, nj);
            }
        }
    }

    void atlanticFlow() {
        for(int j=0; j<COL; j++) adfs(ROW-1, j);
        for(int i=0; i<ROW; i++) adfs(i, COL-1);
    }

    void adfs(int i, int j) {
        if(ocean[i][j] == 'P') {
            coordinates.add(List.of(i, j));
        }
        ocean[i][j] = 'A';
        for(int[] move : moves) {
            int ni = i + move[0];
            int nj = j + move[1];
            if(safe(ni, nj, 'A') && heights[i][j] <= heights[ni][nj]) {
                adfs(ni, nj);
            }
        }
    }
}

```

[PacificAtlanticWaterFlow.java](../../src/main/java/org/example/graph/PacificAtlanticWaterFlow.java)
```java
package org.example.graph;

import java.util.List;

class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        WaterFlowGrid grid = new WaterFlowGrid(heights);
        grid.pacificFlow();
        grid.atlanticFlow();
        List<List<Integer>> coordinates = grid.coordinates;
        System.out.println(coordinates);
    }
}

```