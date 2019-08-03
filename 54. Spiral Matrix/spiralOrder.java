class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        int sm = 0, m = matrix.length - 1;
        if (m < 0)    return ans;
        int sn = 0, n = matrix[0].length - 1;
        int di = 0, dj = 1;
        while (true) {
            for (int j = sn; j <= n; j++)    ans.add(matrix[sm][j]);
            for (int i = sm + 1; i <= m; i++)    ans.add(matrix[i][n]);
            if (sn == n || sm == m) break;
            for (int j = n-1; j >= sn; j--) ans.add(matrix[m][j]);
            for (int i = m-1; i >= sm + 1; i--) ans.add(matrix[i][sn]);
            ++sn;
            --n;
            ++sm;
            --m;
            if (sn > n || sm > m)   break;
        }
        return ans;
    }
}
