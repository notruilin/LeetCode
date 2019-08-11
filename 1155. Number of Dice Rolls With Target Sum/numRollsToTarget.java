class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[31][1001];
        for (int i = 1; i <= f; i++) dp[1][i] = 1;
        for (int i = 2; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j-k < 0)    break;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % 1000000007;
                }
            }
        }
        return dp[d][target];
    }
}
