class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right <= nums.length - 1) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target) {
                    left--;
                }
                else {
                    right++;
                }
            }
        }
        return ans;
    }
}
