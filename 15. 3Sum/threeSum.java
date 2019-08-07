class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> hash = new HashMap();
        List<List<Integer>> ans = new ArrayList();
        for (int num: nums) {
            if (hash.containsKey(num)) hash.put(num, hash.get(num) + 1);
            else    hash.put(num, 1);
        }
        int i = 0;
        while (i < nums.length - 1) {
            int j = i + 1;
            while (j < nums.length) {
                if (hash.containsKey(-nums[i]-nums[j]) && -nums[i]-nums[j] >= nums[j]) {
                    int count = (-nums[i]-nums[j] == nums[i] ? 1 : 0) + (-nums[i]-nums[j] == nums[j] ? 1 : 0);
                    if (hash.get(-nums[i]-nums[j]) > count) {
                        List<Integer> newAns = Arrays.asList(nums[i], nums[j], -nums[i]-nums[j]);
                        ans.add(newAns);
                    }
                }
                ++j;
                while (j < nums.length && nums[j] == nums[j-1]) ++j;
            }
            ++i;
            while (i < nums.length && nums[i] == nums[i-1]) ++i;
        }
        return ans;               
    }
}
