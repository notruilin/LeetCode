class Solution {
    int N = 0;
    
    class Position {
        public int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int calDis(Position pos1, Position pos2) {
        return Math.abs(pos1.x-pos2.x) + Math.abs(pos1.y-pos2.y);
    }
    
    public int maxDistance(int[][] grid) {
        N = grid.length;
        ArrayList<Position> water = new ArrayList();
        ArrayList<Position> land = new ArrayList();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    water.add(new Position(i,j));
                }
                else {
                    land.add(new Position(i,j));
                }
            }
        if (water.size() == 0 || land.size() == 0)  return -1;
        
        int ans = -1;
        for (Position wpos: water) {
            int nearDis = N*N;
            for (Position lpos: land) {
                nearDis = Math.min(nearDis, calDis(wpos, lpos));
            }
            ans = Math.max(ans, nearDis);
        }
        return ans;
    }
}
