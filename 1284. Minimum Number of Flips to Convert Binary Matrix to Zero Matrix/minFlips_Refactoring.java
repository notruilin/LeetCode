class Solution {
    int[][] mat;
    int[] seq = new int[9];
    int m, n, ans = 9999999;
    
    boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    void flip(int i, int j, int[][] newMat) {
        newMat[i][j] = 1 - newMat[i][j];
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                if (isValid(i+dx, j+dy) && Math.abs(dx) + Math.abs(dy) == 1)
                    newMat[i+dx][j+dy] = 1 - newMat[i+dx][j+dy];
    }
    
    void checkAns() {
        int[][] newMat = new int[m][n];
        int sum = 0, count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                newMat[i][j] = mat[i][j];
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (seq[i*n + j] == 1)
                    flip(i, j, newMat);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                sum += newMat[i][j];
        for (int i = 0; i < m*n; i++)
            count += seq[i] == 1 ? 1 : 0;
        if (sum == 0)   ans = Math.min(ans, count);
    }
    
    void dfs(int num) {
        for (int x = 0; x <= 1; x++) {
            seq[num] = x;
            if (num == m*n-1) checkAns();
            else    dfs(num+1);
        }
    }
    
    public int minFlips(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        this.mat = mat;
        dfs(0);
        if (ans == 9999999) return -1;
        return ans;
    }
}
