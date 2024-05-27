package org.example.graph;

class NumIslands {
    public int numIslands(char[][] grid) {
        Grid islands = new Grid(grid);
        return islands.count();
    }

    private static class Grid {
        int ROW;
        int COL;
        char[][] grid;

        Grid(char[][] grid) {
            this.grid = grid;
            ROW = grid.length;
            COL = grid[0].length;
        }

        int count() {
            int N = 0;
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (grid[i][j] == '1') {
                        N++;
                        dfs(i, j);
                    }
                }
            }
            return N;
        }

        void dfs(int i, int j) {
            grid[i][j] = '2';
            if (isSafe(i + 1, j)) dfs(i + 1, j);
            if (isSafe(i - 1, j)) dfs(i - 1, j);
            if (isSafe(i, j + 1)) dfs(i, j + 1);
            if (isSafe(i, j - 1)) dfs(i, j - 1);
        }

        boolean isSafe(int i, int j) {
            return (i >= 0 && i < ROW)
                    && (j >= 0 && j < COL)
                    && grid[i][j] == '1';
        }
    }
}


