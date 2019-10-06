class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] f = new int[40050];
        int M = 20000, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            f[arr[i] + M] = f[arr[i] - difference + M] + 1;
            ans = Math.max(ans, f[arr[i] + M]);    
        }
        return ans;
    }
}
