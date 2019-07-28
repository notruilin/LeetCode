class Solution {
    int N;
    int[] sum = new int[101];
    int[][] f = new int[101][202];
    
    private int getSum(int i, int j) {
        return sum[Math.min(j, N-1)] - (i-1 >= 0 ? sum[i-1] : 0);
    }
    
    private int dp(int i, int j) {
        if (i == N) return 0;
        if (f[i][j] != -1)  return f[i][j];
        int value = 0;
        for (int x = 1; x <= j; x++) {
            if (i + x > N) break;
            int pre = getSum(i + x, N - 1) - dp(i + x, Math.max(x * 2, j));
            int cur = getSum(i, i + x - 1);
            value = Math.max(value, pre + cur);
        }
        f[i][j] = value;
        return value;
    }
    
    public int stoneGameII(int[] piles) {
        N = piles.length;
        sum[0] = piles[0];
        for (int i = 1; i < N; i++) sum[i] = sum[i-1] + piles[i];
        for (int i = 0; i < N; i++) Arrays.fill(f[i], -1);
        return dp(0, 2);
    }
}
