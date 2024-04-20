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