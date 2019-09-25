class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                ans[0] = nums[i];
            }
        }
        int target = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])  --target;
            if (nums[i] != target) {
                ans[1] = target;
                break;
            }
            ++target;
        }
        if (ans[1] == 0)    ans[1] = target;
        return ans;
    }
}
