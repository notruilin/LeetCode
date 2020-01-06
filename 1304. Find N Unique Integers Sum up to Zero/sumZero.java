class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int num = 0;
        for (int i = 0; i < n - n % 2; i+=2) {
            ans[num++] = i + 1;
            ans[num++] = - (i+1);
        }
        return ans;
    }
}
