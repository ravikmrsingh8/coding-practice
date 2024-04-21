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
