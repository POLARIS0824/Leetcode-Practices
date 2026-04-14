public class sudoku {
    public void solveSudoku(char[][] board) {
        Helper(board);
    }

    private boolean Helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (Helper(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }

        return true;
    }

    private boolean isValid(int row, int col, char num, char[][] board) {
        // row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // col
        for (char[] chars : board) {
            if (chars[col] == num) {
                return false;
            }
        }

        // 九宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
