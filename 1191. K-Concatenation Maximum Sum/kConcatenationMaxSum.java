class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int M = 1000000007;
        int N = arr.length;
        int[] sum = new int[N];
        int ans = 0;
        sum[0] = arr[0];
        for (int i = 1; i < N; i++)
            sum[i] = sum[i-1] + arr[i];
        
        int minn = 0, minIndex = -1, maxIndex = -1;
        for (int i = 0; i < N; i++) {
            if (sum[i] < minn) {
                minn = Math.min(minn, sum[i]);
                minIndex = i;
            }
            if (sum[i] - minn > ans) {
                maxIndex = i;
                ans = Math.max(ans, sum[i] - minn);
            }
        }
        
        if (sum[N-1] > 0) {
            int tmp = 0;
            for (int i = 0; i < k; i++)
                tmp = (tmp + sum[N-1]) % M;
            if (minIndex > -1)
                tmp -= sum[minIndex];
            if (maxIndex < N-1)
                tmp -= sum[N-1] - sum[maxIndex];
            return Math.max(ans, tmp);
        }
        else {
            if (k == 1) return ans;
            
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp = Math.max(tmp, sum[N-1] - sum[i]);
            }
            int tmp2 = 0;
            for (int i = 0; i < N; i++) {
                tmp2 = Math.max(tmp2, sum[i]);
            }
            ans = Math.max(ans, tmp + tmp2);
            return ans;
        }
    }
}
