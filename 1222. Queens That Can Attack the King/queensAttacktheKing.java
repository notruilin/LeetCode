class Solution {
    List<List<Integer>> ans = new ArrayList();
    boolean[][] map = new boolean[64][64];
    int N = 8, M = 8;
    
    void addToAns(int x, int y) {
        List<Integer> pair = new ArrayList();
        pair.add(x);
        pair.add(y);
        ans.add(pair);
    }
    
    void tryPos(int x, int y, int dx, int dy) {
        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || x >= N || y < 0 || y >= M) break;
            if (map[x][y]) {
                addToAns(x, y);
                break;
            }
        }
    }
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        for (int i = 0; i < queens.length; i++) {
            map[queens[i][0]][queens[i][1]] = true;
        }
        
        int x = king[0], y = king[1];
        tryPos(x, y, -1, 0);
        tryPos(x, y, 1, 0);
        tryPos(x, y, 0, -1);
        tryPos(x, y, 0, 1);
        tryPos(x, y, -1, -1);
        tryPos(x, y, 1, 1);
        tryPos(x, y, -1, 1);
        tryPos(x, y, 1, -1);
        
        return ans;
    }
}
