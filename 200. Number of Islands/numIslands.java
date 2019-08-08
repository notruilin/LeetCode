class Solution {
    boolean[][] visited;
    int N, M;
    public int numIslands(char[][] grid) {
        int ans = 0;
        if (grid.length == 0)   return 0;
        N = grid.length;
        M = grid[0].length;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    floodfill(i, j, grid);
                    ++ans;
                }
            }
        return ans;
    }
    
    boolean isValid(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }
        return false;
    }
    
    void floodfill(int i, int j, char[][] grid) {
        visited[i][j] = true;
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                if (Math.abs(dx) + Math.abs(dy) < 2 && isValid(i+dx, j+dy) && !visited[i+dx][j+dy] && grid[i+dx][j+dy] == '1') {
                    floodfill(dx+i, dy+j, grid);    
                }
    }
}
