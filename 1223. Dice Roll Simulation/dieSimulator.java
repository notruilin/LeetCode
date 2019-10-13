class Solution {
    int[][][] f = new int[5005][7][16];
    int M = 1000000007;
    int N;
    int[] rollMax;
    
    void dp(int i, int j) {
        for (int d = 1; d <= 6; d++) {
            if (d != j) {
                for (int k = 1; k <= rollMax[j - 1]; k++) {
                    f[i+1][d][1] = (f[i+1][d][1] + f[i][j][k]) % M;
                }
            }
            else {
                for (int k = 1; k < rollMax[j - 1]; k++) {
                    f[i+1][j][k+1] = (f[i+1][j][k+1] + f[i][j][k]) % M;
                }
            }
        }
    }
    
    public int dieSimulator(int n, int[] rollMax) {
        N = n;
        this.rollMax = rollMax;
        for (int j = 1; j <= 6; j++) {
            f[1][j][1] = 1;
        }
        
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= 6; j++)
                dp(i, j);
        
        int ans = 0;
        for (int j = 1; j <= 6; j++)
            for (int k = 1; k <= rollMax[j - 1]; k++) {
                ans = (ans + f[n][j][k]) % M;
            }
        
        return ans;
    }
}
