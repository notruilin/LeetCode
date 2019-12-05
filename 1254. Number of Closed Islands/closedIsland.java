class Solution {
    int[][] grid;
    boolean isIsland;
    
    boolean isValid(int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    
    boolean isEdge(int x, int y) {
        return x == 0 || x == grid.length-1 || y == 0 || y == grid[0].length-1;
    }
    
    void dfs(int x, int y) {
        grid[x][y] = -1;
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++) {
                if (Math.abs(dx) + Math.abs(dy) == 1) {
                    if (isValid(x+dx, y+dy) && grid[x + dx][y + dy] == 0) {
                        if (isEdge(x+dx, y+dy)) isIsland = false;
                        dfs(x+dx, y+dy);
                    }
                }
            }
    }
    
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        int ans = 0;
        
        for (int i = 1; i < grid.length - 1; i++)
            for (int j = 1; j < grid[0].length - 1; j++)
                if (grid[i][j] == 0) {
                    isIsland = true;
                    dfs(i,j);
                    if (isIsland)   ++ans;
                }
        
        return ans;
    }
}
