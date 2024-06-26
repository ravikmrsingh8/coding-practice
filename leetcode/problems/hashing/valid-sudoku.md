# [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/description/)
https://leetcode.com/problems/valid-sudoku/description/

<hr />

### Problem Statement
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.



#### Example 1
```
Input: board =
[['5','3','.','.','7','.','.','.','.']
,['6','.','.','1','9','5','.','.','.']
,['.','9','8','.','.','.','.','6','.']
,['8','.','.','.','6','.','.','.','3']
,['4','.','.','8','.','3','.','.','1']
,['7','.','.','.','2','.','.','.','6']
,['.','6','.','.','.','.','2','8','.']
,['.','.','.','4','1','9','.','.','5']
,['.','.','.','.','8','.','.','7','9']]
Output: true
```


#### Example 2
```
Input: board =
[['8','3','.','.','7','.','.','.','.']
,['6','.','.','1','9','5','.','.','.']
,['.','9','8','.','.','.','.','6','.']
,['8','.','.','.','6','.','.','.','3']
,['4','.','.','8','.','3','.','.','1']
,['7','.','.','.','2','.','.','.','6']
,['.','6','.','.','.','.','2','8','.']
,['.','.','.','4','1','9','.','.','5']
,['.','.','.','.','8','.','.','7','9']]
Output: false
```
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

<hr />

### Solution
[Sudoku.java](../../src/main/java/org/example/hashing/Sudoku.java)
```java
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

```