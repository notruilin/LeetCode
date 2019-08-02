class Solution {
    public void nextPermutation(int[] nums) {
        boolean done = false;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                int k = i+1;
                for (int j = i+2; j < nums.length; j++)
                    if (nums[j] > nums[i] && nums[j] < nums[k]) k = j;
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
                Arrays.sort(nums, i+1, nums.length);
                done = true;
                break;
            }
        }
        if (!done)  Arrays.sort(nums);
    }
}
