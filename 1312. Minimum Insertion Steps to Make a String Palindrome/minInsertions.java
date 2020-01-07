class Solution {
    public int minInsertions(String s) {
        int L =  s.length();
        int[][] f = new int[L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) f[i][j] = L;
            f[i][i] = 0;
        }
        for (int l = 1; l < L; l++)
            for (int i = 0; i < L - l; i++) {
                int j = i+l;
                if (s.charAt(i) == s.charAt(j)) {
                    int cost = 0;
                    if (i+1 <= j-1)   cost = f[i+1][j-1];
                    f[i][j] = Math.min(f[i][j], cost);
                }
                if (i + 1 < L)
                    f[i][j] = Math.min(f[i][j], f[i+1][j] + 1);
                if (j - 1 >= 0)
                    f[i][j] = Math.min(f[i][j], f[i][j-1] + 1);
            }
        return f[0][L-1];
    }
}
