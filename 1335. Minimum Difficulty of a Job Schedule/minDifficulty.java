class Solution {
    public int minDifficulty(int[] job, int d) {
        int[][] f = new int[d][job.length];
        int maxV = 0;
        for (int i = 0; i < d; i++)
            for (int j = 0; j < job.length; j++)
                f[i][j] = Integer.MAX_VALUE;
        for (int j = 0; j < job.length; j++) {
            maxV = Math.max(maxV, job[j]);
            f[0][j] = maxV;
        }
        for (int i = 1; i < d; i++)
            for (int j = i; j < job.length; j++) {
                for (int k = i-1; k < j; k++) {
                    if (f[i-1][k] == Integer.MAX_VALUE) continue;
                    maxV = 0;
                    for (int p = k + 1; p <= j; p++)
                        maxV = Math.max(maxV, job[p]);
                    f[i][j] = Math.min(f[i][j], f[i-1][k] + maxV);
                }
            }
        if (f[d-1][job.length - 1] == Integer.MAX_VALUE)    return -1;
        return f[d-1][job.length - 1];
    }
}
