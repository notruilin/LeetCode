class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? -Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] f = new int[envelopes.length];
        Arrays.fill(f, 1);
        int ans = 0;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1])
                    f[i] = Math.max(f[i], f[j] + 1);
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
