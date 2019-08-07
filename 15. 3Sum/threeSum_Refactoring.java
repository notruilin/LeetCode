class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> hash = new HashMap();
        List<List<Integer>> ans = new ArrayList();
        for (int num: nums) {
            if (hash.containsKey(num)) hash.put(num, hash.get(num) + 1);
            else    hash.put(num, 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j != i+1 && nums[j] == nums[j-1])   continue;
                int c = -nums[i]-nums[j];
                if (hash.containsKey(c) && c >= nums[j]) {
                    int count = (c == nums[i] ? 1 : 0) + (c == nums[j] ? 1 : 0);
                    if (hash.get(c) > count) {
                        List<Integer> newAns = Arrays.asList(nums[i], nums[j], c);
                        ans.add(newAns);
                    }
                }
            }
        }
        return ans;               
    }
}
