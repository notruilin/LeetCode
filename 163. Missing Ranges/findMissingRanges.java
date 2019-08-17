class Solution {
    List<String> ans = new ArrayList();
    
    private void addAns(int left, int right) {
        if (right >= left) {
            if (left == right) {
                ans.add(Integer.toString(left));
            }
            else {
                ans.add(Integer.toString(left)+"->"+Integer.toString(right));
            }
        }
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            addAns(lower, upper);
            return ans;
        }
        if (nums[0] != lower) {
            addAns(lower, nums[0] - 1);    
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                addAns(nums[i-1]+1, nums[i]-1);
            }
        }
        if (nums[nums.length-1] != upper) {
            addAns(nums[nums.length-1]+1, upper);    
        }
        return ans;
    }
}
