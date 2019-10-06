class Solution {
    public int countVowelPermutation(int n) {
        long M = 1000000007;
        long[][] f = new long[20001][6];
        for (int i = 0; i < 5; i++)
            f[0][i] = 1;
        for (int i = 1; i < n; i++) {
            f[i][0] = (f[i-1][1] + f[i-1][2] + f[i-1][4]) % M;
            f[i][1] = (f[i-1][0] + f[i-1][2]) % M;
            f[i][2] = (f[i-1][1] + f[i-1][3]) % M;
            f[i][3] = f[i-1][2];
            f[i][4] = (f[i-1][2] + f[i-1][3]) % M;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++)
            ans =  (ans + f[n-1][i]) % M;
        return (int)ans;
    }
}
