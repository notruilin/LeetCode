class Solution {
    int calCost(String s, int left, int right) {
        int cost = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                ++cost;
            ++left;
            --right;
        }
        return cost;
    }
    
    public int palindromePartition(String s, int k) {
        int f[][] = new int[101][101];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j <= k; j++)
                f[i][j] = 999;
        for (int i = 0; i < s.length(); i++) {
            f[i][1] = calCost(s, 0, i);
        }
        for (int i = 1; i < s.length(); i++)
            for (int j = 1; j <= k; j++) {
                for (int left = 1; left <= i; left++) {
                    f[i][j] = Math.min(f[i][j], f[left-1][j-1] + calCost(s, left, i));
                }
            }
        return f[s.length() - 1][k];
    }
}
