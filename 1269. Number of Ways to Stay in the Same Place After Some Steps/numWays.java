class Solution {
    public int numWays(int steps, int arrLen) {
        int M = 1000000007;
        int f[][] = new int[501][501];
        f[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= steps; j++) {
                if (j < steps)
                    f[i][j] = (f[i][j] + f[i-1][j+1]) % M;
                if (j > 0 && j < arrLen)
                    f[i][j] = (f[i][j] + f[i-1][j-1]) % M;
                f[i][j] = (f[i][j] + f[i-1][j]) % M;
            }
        }
        return f[steps][0];
    }
}
