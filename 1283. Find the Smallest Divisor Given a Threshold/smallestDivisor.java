class Solution {
    int calculate(int[] nums, int x) {
        int res = 0;
        for (int num: nums) {
            res += (int) Math.ceil((num / (float)x));
        }
        return res;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1000000;
        while (left < right) {
            int mid = (left + right) / 2;
            int re = calculate(nums, mid);
            if (re <= threshold)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
