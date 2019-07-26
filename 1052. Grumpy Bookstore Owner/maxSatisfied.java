class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int totalSum = customers[0];
        int[] sum = new int[customers.length];
        sum[0] = grumpy[0] == 1 ? customers[0] : 0;
        for (int i = 1; i < customers.length; i++) {
            sum[i] = sum[i-1] + (grumpy[i] == 1 ? customers[i] : 0);
            totalSum += customers[i];
        }
        int ans = 0;
        for (int i = 0; i < customers.length - X + 1; i++) {
            int n = sum[i + X - 1] - (i == 0? 0 : sum[i-1]);
            ans = Math.max(ans, totalSum - (sum[customers.length - 1] - n));
        }
        return ans;
    }
}
