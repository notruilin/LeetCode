class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] nums = new int[60];
        int ans = 0;
        for (int x: time) {
            ans += nums[(60 - x % 60) % 60];
            nums[x % 60] ++;
        }
        return ans;
    }
}
