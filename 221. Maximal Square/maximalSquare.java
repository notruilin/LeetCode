class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] f = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '1')    continue;
                f[i][j] = 1;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    f[i][j] = Math.min(Math.min(f[i-1][j-1], f[i-1][j]), f[i][j-1]) + 1;
                }
                ans = Math.max(ans, f[i][j]);
            }
        return ans * ans;
    }
}
