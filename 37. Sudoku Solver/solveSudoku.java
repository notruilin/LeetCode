class Solution {
    private static int S = 9;
    boolean[][] rowUsed, colUsed, boxUsed;
    char[][] ans;
    boolean getAns = false;
    
    int getBoxNum(int x, int y) {
        return x / 3 * 3 + y / 3;
    }
    
    void dfs(char[][] board, int i, int j) {
        if (j == S) {
            dfs(board, i+1, 0);
            return;
        }
        if (i == S) {
            getAns = true;
            for (int x = 0; x < S; x++)
                for (int y = 0; y < S; y++)
                    ans[x][y] = board[x][y];
        }
        if (getAns) return;
        if (board[i][j] != '.') dfs(board, i, j + 1);
        else {
            for (int num = 1; num <= S; num++) {
                if (!rowUsed[i][num] && !colUsed[j][num] && !boxUsed[getBoxNum(i,j)][num]) {
                    board[i][j] = (char)((int)'0' + num);
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[getBoxNum(i,j)][num] = true;
                    dfs(board, i, j+1);
                    board[i][j] = '.';
                    rowUsed[i][num] = false;
                    colUsed[j][num] = false;
                    boxUsed[getBoxNum(i,j)][num] = false;
                }
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        rowUsed = new boolean[S][10];
        colUsed = new boolean[S][10];
        boxUsed = new boolean[S][10];
        ans = new char[S][S];
        for (int i = 0; i < S; i++)
            for (int j = 0; j < S; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                rowUsed[i][num] = true;
                colUsed[j][num] = true;
                boxUsed[getBoxNum(i, j)][num] = true;
            }
        dfs(board, 0, 0);
        for (int i = 0; i < S; i++)
            for (int j = 0; j < S; j++)
                board[i][j] = ans[i][j];
    }
}
