class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0;
        int[][] hor = new int[grid.length][grid[0].length];
        int[][] ver = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                hor[i][j] = grid[i][j];
                ver[i][j] = grid[i][j];
                if (grid[i][j] == 1)    ans = 1;
            }
        for (int i = 0; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++)
                hor[i][j] += hor[i][j-1];
        for (int i = 1; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                ver[i][j] += ver[i-1][j];
        
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                for (int k = 0; k < Math.min(grid.length, grid[0].length); k++) {
                    if (i + k >= grid.length || j + k >= grid[0].length)    break;
                    int x = hor[i][j+k] - (j - 1 >= 0 ? hor[i][j-1] : 0);
                    int y = hor[i+k][j+k] - (j - 1 >= 0 ? hor[i+k][j-1] : 0);
                    int a = ver[i+k][j] - (i - 1 >= 0 ? ver[i-1][j] : 0);
                    int b = ver[i+k][j+k] - (i - 1 >= 0 ? ver[i-1][j+k] : 0);
                    if (x == k + 1 && y == k + 1 && a == k + 1 && b == k + 1)  
                        ans = Math.max(ans, (k + 1) * (k+1));
                }
        return ans;
    }
}
