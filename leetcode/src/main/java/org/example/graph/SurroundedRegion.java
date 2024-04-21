package org.example.graph;

import java.util.Arrays;

public class SurroundedRegion {
    public void solve(char[][] board) {
        SurroundedRegionBoard regions = new SurroundedRegionBoard(board);
        regions.captureOpenSide();
        regions.markCapture();
        System.out.println(Arrays.deepToString(board));
    }
}
