class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[51][51];
        for (int i = 0; i < indices.length; i++) {
            for (int p = 0; p < n; p++)
                matrix[p][indices[i][1]]++;
            for (int q = 0; q < m; q++)
                matrix[indices[i][0]][q]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] % 2 != 0)
                    ++ans;
        return ans;
    }
}
