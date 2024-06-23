package org.example.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintAllPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };


        printAllPaths(matrix1);
    }

    static void printAllPaths(int[][] matrix) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        List<List<Integer>> allPaths = new ArrayList<>();
        for(int c=0; c<COL; c++) {
            LinkedList<Integer> currPath = new LinkedList<>();
            dfs(matrix, ROW, COL, 0, c, currPath, allPaths);
        }
        //System.out.println(allPaths);
        allPaths.forEach(System.out::println);
    }

    static void dfs(int[][] matrix, int ROW, int COL, int i, int j, LinkedList<Integer> currPath,List<List<Integer>> allPaths) {
        if(i == ROW) {
            allPaths.add(new ArrayList<>(currPath));
            return;
        }

        currPath.add(matrix[i][j]);
        for(int c=0; c<COL; c++) {
            dfs(matrix, ROW, COL, i+1, c, currPath, allPaths);
            if(i + 1 == ROW) break;
        }
        currPath.pollLast();
    }

}
