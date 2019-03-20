class Solution {
    public int bitwiseComplement(int N) {
        int i = 31, ans = 0;
        if (N == 0) {
            return 1;
        }
        while (((N >> (i-1)) & 1) == 0) {
            --i;
        }
        while (i > 0) {
            ans += (1 - (N >> (i-1) & 1)) << (i-1);
            --i;
        }
        return ans;
    }
}
