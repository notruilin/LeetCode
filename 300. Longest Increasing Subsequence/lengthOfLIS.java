class Solution {
    private List<Integer> d = new ArrayList();
    
    private int binarySearch(int val) {
        int left = 0, right = d.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (d.get(mid) < val)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
    
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        d.add(Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            int k = binarySearch(nums[i]);
            ans = Math.max(ans, k + 1);
            if (k + 1 == d.size())    d.add(nums[i]);
            else    d.set(k+1, Math.min(d.get(k+1), nums[i]));
        }
        return ans;
    }
}
