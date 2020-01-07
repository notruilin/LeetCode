class Solution {
    public int minPathSum(int[][] f) {
        int N = f.length, M = f[0].length;
        for (int i = 1; i < N; i++)
            f[i][0] += f[i-1][0];
        for (int j = 1; j < M; j++)
            f[0][j] += f[0][j-1];
        for (int i = 1; i < N; i++)
            for (int j = 1; j < M; j++)
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + f[i][j];
        return f[N-1][M-1];
    }
}
