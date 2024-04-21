package org.example.graph;

public class SurroundedRegionBoard {
    char[][] board;
    int ROW;
    int COL;
    boolean[][] visited;

    SurroundedRegionBoard(char[][] board) {
        this.board = board;
        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
    }

    static int[][] moves = {{0, 1}, {0, -1}, {-1, 0} , {1, 0}};

    boolean isSafe(int i, int j) {
        return (i>=0 && i< ROW) && (j >=0 && j<COL) && board[i][j] == 'O';
    }


    void captureOpenSide() {
        for(int j = 0; j < COL; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) selectOpen(0, j);
            if (board[ROW - 1][j] == 'O' && !visited[ROW -1][j]) selectOpen(ROW -1, j);
        }
        for(int i= 0; i< ROW; i++) {
            if(board[i][0] == 'O' && !visited[i][0]) selectOpen(i, 0);
            if(board[i][COL -1] == 'O' && !visited[i][COL -1]) selectOpen(i, COL -1);
        }
    }

    void selectOpen(int i, int j) {
        board[i][j] = 'T';
        for (int[] move : moves) {
            int ni = i + move[0];
            int nj = j + move[1];
            if(isSafe(ni, nj)) {
                selectOpen(ni, nj);
            }
        }
    }

    void markCapture() {
        for(int i=0; i<ROW; i++) {
            for(int j=0; j<COL; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
