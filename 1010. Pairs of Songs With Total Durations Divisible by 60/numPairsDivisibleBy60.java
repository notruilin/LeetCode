class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] nums = new int[501];
        for (int x: time) {
            nums[x]++;
        }
        
        int ans = 0;
        for (int i = 0; i <= 500; i++) {
            if (nums[i] > 0) {
                if (i * 2 % 60 == 0) {
                    ans += (1 + nums[i]-1) * (nums[i]-1) / 2;
                }
                for (int j = i + 1; j <= 500; j++)
                    if ((i + j) % 60 == 0) {
                        ans += nums[i] * nums[j];
                    }
            }
        }
        return ans;
    }
}
