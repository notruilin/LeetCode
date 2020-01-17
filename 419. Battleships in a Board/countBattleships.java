class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && 
                    (i+1 >= board.length || board[i+1][j] == '.') && (j+1 >= board[0].length || board[i][j+1] == '.'))
                    ++count;
            }
        return count;
    }
}
