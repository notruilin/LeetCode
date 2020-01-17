class Solution {
    private int binarySearch(List<Integer> d, int val) {
        int left = 0, right = d.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (d.get(mid) < val)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? -Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        List<Integer> d = new ArrayList();
        d.add(Integer.MIN_VALUE);
        int ans = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int k = binarySearch(d, envelopes[i][1]);
            if (d.size() - 1 == k)  d.add(envelopes[i][1]);
            else    d.set(k+1, Math.min(d.get(k+1), envelopes[i][1]));
            ans = Math.max(ans, k+1);
        }
        return ans;
    }
}
