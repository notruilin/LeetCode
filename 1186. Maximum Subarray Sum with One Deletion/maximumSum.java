class Solution {
    public int maximumSum(int[] arr) {
        int[] maxEndI = new int[arr.length];
        int[] maxStartI = new int[arr.length];
        maxEndI[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            maxEndI[i] = Math.max(maxEndI[i-1] + arr[i], arr[i]);
        maxStartI[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--)
            maxStartI[i] = Math.max(maxStartI[i+1] + arr[i], arr[i]);
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, maxStartI[i]);
            if (i > 0 && i < arr.length - 1)
                ans = Math.max(ans, maxEndI[i-1] + maxStartI[i+1]);
        }
        return ans;
    }
}
