class Solution {
    int[][] g = new int[120][120];
    int N = 0;
    
    private boolean isValid(int i, int j) {
        return (i >= 0 && i < N*4 && j >= 0 && j < N*4);
    }
    
    private void dfs(int i, int j) {
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                if (Math.abs(dx) + Math.abs(dy) == 1)
                    if (isValid(i+dx, j+dy) && g[i+dx][j+dy] == 0) {
                        g[i+dx][j+dy] = 1;
                        dfs(i+dx, j+dy);
                    }
    }
    
    public int regionsBySlashes(String[] grid) {
        N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '/') {
                    g[i*4][j*4+3] = 1;
                    g[i*4+1][j*4+2] = 1;
                    g[i*4+2][j*4+1] = 1;
                    g[i*4+3][j*4] = 1;
                }
                else {
                    if (grid[i].charAt(j) == '\\') {
                        g[i*4][j*4] = 1;
                        g[i*4+1][j*4+1] = 1;
                        g[i*4+2][j*4+2] = 1;
                        g[i*4+3][j*4+3] = 1;    
                    }
                }
            }
        }
        
        int ans = 0;
        for (int i = 0; i < N * 4; i++)
            for (int j = 0; j < N * 4; j++)
                if (g[i][j] == 0) {
                    ++ans;
                    dfs(i, j);
                }
        return ans;
    }
}
