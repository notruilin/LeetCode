class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        boolean [][] f = new boolean [1000][1000];
        f[0][0] = true;
        for (i = 0; i <= s.length(); i++)
            for (j = 0; j <= p.length(); j++) {
                if (f[i][j])    continue;
                if (i > 0 && j > 0)
                    f[i][j] = f[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                if (!f[i][j] && j > 1 && p.charAt(j-1) == '*') {
                    f[i][j] = f[i][j-2];
                    if (f[i][j])    continue;
                    if (i > 0)
                        f[i][j] = (f[i-1][j-1] || f[i][j-1] || f[i-1][j]) && 
                                    (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.');
                }
            }
        return f[s.length()][p.length()];
    }
}
