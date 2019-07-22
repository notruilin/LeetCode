class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int ai = A[0];
        int ans = 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, ai + A[j] - j);
            if (A[j] + j > ai)  ai = A[j] + j;
        }
        return ans;
    }
}
