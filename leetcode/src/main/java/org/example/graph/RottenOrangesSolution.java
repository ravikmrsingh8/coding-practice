package org.example.graph;

public class RottenOrangesSolution {
    public int orangesRotting(int[][] grid) {
        RottenOrangesGrid oranges = new RottenOrangesGrid(grid);
        return oranges.letThemRot();
    }
}
