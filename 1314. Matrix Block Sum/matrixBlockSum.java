class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] += i - 1 >= 0 ? mat[i-1][j] : 0;
                mat[i][j] += j - 1 >= 0 ? mat[i][j-1] : 0;
                mat[i][j] -= i - 1 >= 0 && j - 1 >=0 ? mat[i-1][j-1] : 0; 
            }
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++) {
                int a = Math.max(0, i - K);
                int b = Math.max(0, j - K);
                int x = Math.min(mat.length - 1, i + K);
                int y = Math.min(mat[0].length - 1, j + K);
                ans[i][j] = mat[x][y] - (a - 1 >= 0 ? mat[a-1][y] : 0) - (b - 1 >= 0 ? mat[x][b-1] : 0) + 
                    (a - 1 >= 0 && b - 1 >= 0 ? mat[a-1][b-1] : 0);
            }
        return ans;
    }
}
