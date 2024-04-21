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