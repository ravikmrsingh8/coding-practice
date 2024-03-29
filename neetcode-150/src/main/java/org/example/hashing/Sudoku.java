package org.example.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sudoku {
    public boolean isValid(char[][] board) {
        Map<Character, Set<String>> map = new HashMap<>();
        int N = board.length;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                String row = String.format("%s%d", "R", i);
                String col = String.format("%s%d", "C", j);
                String box = String.format("%s%d%d", "B", i/3, j/3);
                Set<String> mappings = map.getOrDefault(board[i][j], new HashSet<>());
                if (mappings.contains(row) || mappings.contains(col) || mappings.contains(box)) {
                    return false;
                }
                mappings.addAll(Set.of(row, col, box));
                map.put(board[i][j], mappings);
            }
        }
        return true;
    }
}
