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
