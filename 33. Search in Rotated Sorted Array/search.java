class Solution {
    
    public int search(int[] nums, int target) {
        int N = nums.length;
        if (N == 0)   return -1;
        int left = 0, right = N - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        
        int offset = left;
        left = 0;
        right = N - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[(mid + offset) % N] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        if (nums[(left + offset) % N] != target) return -1;   
        return (left + offset) % N;
    }
}
