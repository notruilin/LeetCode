class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] T = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int count = 0;
        int x = 0, y = 0, t = 0;
        while (count < n*n) {
            ans[x][y] = ++count;
            if (!(x + T[t][0] >= 0 && x + T[t][0] < n && y + T[t][1] >= 0 && y + T[t][1] < n) || ans[x+T[t][0]][y+T[t][1]] != 0) {
                t = (t+1) % 4;
            }
            x += T[t][0];
            y += T[t][1];
        }
        return ans;
    }
}
