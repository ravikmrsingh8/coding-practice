package org.example.graph;


import java.util.LinkedList;
import java.util.Queue;

public class IslandsBFS {
    record Node(int i, int j){}
    boolean[][] visited;
    int row;
    int col;
    char[][] grid;

    static int[][] moves = {{0, -1},{0, 1}, {-1, 0}, {1, 0}};

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
                for (int[] move : moves) {
                    int ni = node.i() + move[0];
                    int nj = node.j() + move[1];
                    if (isSafe(ni, nj)) {
                        visited[ni][nj] = true;
                        q.offer(new Node(ni, nj));
                    }
                }
            }
        }
    }
}
