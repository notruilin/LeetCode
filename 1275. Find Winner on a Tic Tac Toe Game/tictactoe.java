class Solution {
    public String tictactoe(int[][] moves) {
        String[][] grid = new String[3][3];
        for (int i = 0; i < moves.length; i++) {
            String c = "A";
            if (i % 2 != 0) c = "B";
            grid[moves[i][0]][moves[i][1]] = c;
        }

        for (int i = 0; i < 3; i++)
            if (grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2] && grid[i][0] != null)
                return grid[i][0];
        
        for (int j = 0; j < 3; j++) 
            if (grid[0][j] == grid[1][j] && grid[0][j] == grid[2][j] && grid[0][j] != null)
                return grid[0][j];

        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != null)
            return grid[0][0];
        
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != null)
            return grid[0][2];
        
        if (moves.length == 9)  return "Draw";
        return "Pending";
    }
}
