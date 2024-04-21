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
