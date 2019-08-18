class Solution {
    class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int maxDistance(int[][] grid) {
        Queue<Position> queue = new LinkedList();
        int[][] dis = new int[grid.length][grid.length];
        
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++) {
                dis[i][j] = grid.length * grid.length;
                if (grid[i][j] == 1) {
                    dis[i][j] = 0;
                    queue.add(new Position(i,j));
                }
            }
        
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            for (int dx = -1; dx <= 1; dx++)
                for (int dy = -1; dy <= 1; dy++)
                    if (Math.abs(dx)+Math.abs(dy) == 1) {
                        int x = now.x + dx;
                        int y = now.y + dy;
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && dis[now.x][now.y] + 1 < dis[x][y]) {
                            dis[x][y] = dis[now.x][now.y] + 1;
                            queue.add(new Position(x, y));
                        }
                    }
        }
        
        int ans = -1;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0 && dis[i][j] > ans && dis[i][j] != grid.length * grid.length)
                    ans = dis[i][j];
            }
        return ans;
    }
}
