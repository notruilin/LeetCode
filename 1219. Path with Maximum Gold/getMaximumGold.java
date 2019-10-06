class Solution {
    boolean[][] vis = new boolean[16][16];
    int[][] grid;
    int ans = 0;
    int N, M;
    
    boolean isValid(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M)
            return true;
        return false;
    }
    
    void dfs(int x, int y, int count) {
        vis[x][y] = true;
        ans = Math.max(ans, count);
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                if (Math.abs(dx) + Math.abs(dy) == 1) {
                    int newX = x + dx;
                    int newY = y + dy;
                    if (isValid(newX, newY) && grid[newX][newY] > 0 && !vis[newX][newY]) {
                        dfs(newX, newY, count + grid[newX][newY]);
                        vis[newX][newY] = false;
                    }
                }
    }
    
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (grid[i][j] > 0) {
                    for (int ii = 0; ii < N; ii++)
                        for (int jj = 0; jj < M; jj++)
                            vis[ii][jj] = false;
                    dfs(i,j,grid[i][j]);
                }
            }
        return ans;
    }
}
