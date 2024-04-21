package org.example.graph;

public class IslandsDFS {
    boolean[][] visited;
    int row;
    int col;
    char[][] grid;

   static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

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
        for (int[] move: moves) {
            int ni = i + move[0];
            int nj = j + move[1];
            if (isSafe(ni, nj)) {
                dfs(ni, nj);
            }
        }
    }
}