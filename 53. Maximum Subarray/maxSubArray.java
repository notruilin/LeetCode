class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, minv = 0, ans = Integer.MIN_VALUE;
        for (int x: nums) {
            sum += x;
            ans = Math.max(ans, sum - minv);
            minv = Math.min(minv, sum);
        }
        return ans;
    }
}
