package org.example.graph;

import java.util.Arrays;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        WallsAndGatesGrid grid = new WallsAndGatesGrid(rooms);
        grid.doBFSFromGates();
    }

    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int[][] rooms = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        solution.wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));


        int[][] rooms2 = {
                {0,-1},
                {2147483647,2147483647}
        };
        solution.wallsAndGates(rooms2);
        System.out.println(Arrays.deepToString(rooms2));

    }
}
