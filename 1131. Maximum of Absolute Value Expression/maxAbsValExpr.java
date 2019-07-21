class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] f = new int[arr1.length];
        int ans = 0;
        for (int k1 = -1; k1 <= 1; k1 += 2) {
            for (int k2 = -1; k2 <= 1; k2 += 2) {
                for (int i = 0; i < arr1.length; i++) {
                    f[i] = arr1[i] * k1 + arr2[i] * k2 + i;
                }
                ans = Math.max(ans, Arrays.stream(f).max().getAsInt() - Arrays.stream(f).min().getAsInt());
            }
        }
        return ans;
    }
}
