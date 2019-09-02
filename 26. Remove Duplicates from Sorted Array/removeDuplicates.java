class Solution {
    public int removeDuplicates(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < res; i++) {
            int count = 0;
            int j = i+1;
            while (j < res && nums[i] == nums[j]) {
                ++count;
                ++j;
            }
            for (; j < res; j++) {
                nums[j-count] = nums[j];
            }
            res -= count;
        }
        return res;
    }
}
