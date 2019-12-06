class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] even = new int[nums.length];
        even[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                even[i] = even[i+1] + 1;
            }
            else
                even[i] = 1;
        }

        int l = 0, ans = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 != 0)   ++count;
            if (count > k) {
                while (nums[l] % 2 == 0)    ++l;
                ++l;
                --count;
            }
            if (count == k) ans += even[l];
        }
        return ans;
    }
}
