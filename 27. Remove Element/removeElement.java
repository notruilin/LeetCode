class Solution {
    public int removeElement(int[] nums, int val) {
        int delNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[delNum++] = nums[i];
            }
        }
        return delNum;
    }
}
