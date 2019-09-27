class Solution {
    private boolean checkSquare(int x, int y, char[][] board) {
        boolean[] num = new boolean[10];
        for (int i = x; i < x + 3; i++)
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == '.') continue;
                if (!num[board[i][j] - '1'])
                    num[board[i][j] - '1'] = true;
                else
                    return false;
            }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        boolean[] num = new boolean[10];
        for (int i = 0; i < N; i++)  {
            Arrays.fill(num, false);
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') continue;
                if (!num[board[i][j] - '1'])
                    num[board[i][j] - '1'] = true;
                else
                    return false;
            }
        }
        
        for (int j = 0; j < N; j++) {
            Arrays.fill(num, false);
            for (int i = 0; i < N; i++) {
                if (board[i][j] == '.') continue;
                if (!num[board[i][j] - '1'])
                    num[board[i][j] - '1'] = true;
                else
                    return false;
            }
        }
        
        for (int i = 0; i < N; i+= 3)
            for (int j = 0; j < N; j+= 3) {
                Arrays.fill(num, false);
                if (!checkSquare(i,j,board))  return false;
            }
            
        return true;
    }
}
